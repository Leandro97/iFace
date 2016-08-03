package br.ufal.persistencia;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;

import br.ufal.modelo.Usuario;

public class UsuarioPersistencia extends Persistencia{
	
	private static UsuarioPersistencia instance;
	
	private UsuarioPersistencia() {
		
	}
	
	public static UsuarioPersistencia getInstance() {
		if(instance == null) {
			instance = new UsuarioPersistencia();
		}
		return instance;
	}
	
	//persiste um usuário no banco
		public void salvarUsuario(Usuario user) {
			manager = factory.createEntityManager();
			
			try {
				manager.getTransaction().begin();
				manager.persist(user);
				manager.getTransaction().commit();
				manager.close();
			}  catch (HibernateException e) {
				e.printStackTrace();
				manager.getTransaction().rollback();
			}	
		}
		
		//retorna um usuário ao receber seu id
		public Usuario getUsuarioById(int id) {
			Usuario user = null;
			manager = factory.createEntityManager();
			
			try {
				user = manager.find(Usuario.class, id);
				manager.close();
			}  catch (HibernateException e) {
				e.printStackTrace();
				manager.getTransaction().rollback();
			}	
			
			return user;
		}
		
		//retorna um usuário ao receber seu username
			public Usuario getUsuarioByUsername(String username) {
				manager = factory.createEntityManager();
				List<Usuario> users = null;
				try {
					users = (List<Usuario>) manager.createQuery("SELECT u FROM Usuario u WHERE u.username = :username")
				    .setParameter("username", username)
				    .getResultList();
					manager.close();
				}  catch (HibernateException e) {
					e.printStackTrace();
					manager.getTransaction().rollback();
				}	
				
				if(users.size() == 0) {
					return null;
				} else {
					return users.get(0);
				}
			}
		
		//retorna um usuário se a combinação de username e senha estiver cadastrada
		public Usuario login(String username, String senha) {
			manager = factory.createEntityManager();
			Usuario user = null;
			try {
				user = (Usuario) manager.createQuery("SELECT u FROM Usuario u WHERE u.username = :username AND u.senha = :senha")
			    .setParameter("username", username)
			    .setParameter("senha", senha)
			    .getResultList().get(0);
				manager.close();
			}  catch (HibernateException e) {
				e.printStackTrace();
				manager.getTransaction().rollback();
			}	
			
			return user;
		}
		
		//deleta instância de usuário no banco (Tem que implementar direitinho)
		public void deletarUsuario(Usuario user) {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Query query = manager.createQuery("DELETE FROM Usuario WHERE id = 6");
			try {
				query.executeUpdate();
				manager.getTransaction().commit();
				manager.close();
			}  catch (HibernateException e) {
				e.printStackTrace();
				manager.getTransaction().rollback();
			}	
		}
}
