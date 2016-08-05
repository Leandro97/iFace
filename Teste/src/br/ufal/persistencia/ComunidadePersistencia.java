package br.ufal.persistencia;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;

import br.ufal.modelo.Comunidade;
import br.ufal.modelo.ComunidadeUsuario;
import br.ufal.modelo.Usuario;


public class ComunidadePersistencia extends Persistencia{
	
	private static ComunidadePersistencia instance;
	
	private ComunidadePersistencia() {
		
	}
	
	public static ComunidadePersistencia getInstance() {
		if(instance == null) {
			instance = new ComunidadePersistencia();
		}
		return instance;
	}
	
	//Persiste uma comunidade no banco
		public void salvarComunidade(Comunidade com) {
			manager = factory.createEntityManager();
					
			try {
				manager.getTransaction().begin();
				manager.persist(com);
				manager.getTransaction().commit();
				incluirMembro(com, com.getDono(), true);
			}  catch (HibernateException e) {
				e.printStackTrace();
				manager.getTransaction().rollback();
			} catch (PersistenceException e) {
				System.out.println("Comunidade já cadastrada!");
			}
		}
	
	//Retorna um usuário ao receber seu id
		public Comunidade getComunidadeById(int id) {
			Comunidade com = null;
			manager = factory.createEntityManager();
			
			try {
				com = manager.find(Comunidade.class, id);
				manager.close();
			}  catch (HibernateException e) {
				e.printStackTrace();
				manager.getTransaction().rollback();
			}	
			
			return com;
		}
	
	//Retorna uma comunidade ao receber seu nome	
		public Comunidade getComunidadeByNome(String nome) {
			manager = factory.createEntityManager();
			List<Comunidade> coms = null;
			try {
				coms = (List<Comunidade>) manager.createQuery("SELECT c FROM Comunidade c WHERE c.nome = :nome")
				.setParameter("nome", nome)
				.getResultList();
				manager.close();
			}  catch (HibernateException e) {
				e.printStackTrace();
				manager.getTransaction().rollback();
			}	
			
			if(coms.size() == 0) {
				return null;
			} else {
				return coms.get(0);
			}
		}
		
	//Inclui usuário em uma comunidade
		public void incluirMembro(Comunidade com, Usuario user, boolean confirmado) {
			manager = factory.createEntityManager();
			ComunidadeUsuario uc = new ComunidadeUsuario(com, user, confirmado);
			try {
				manager.getTransaction().begin();
				manager.persist(uc);
				manager.getTransaction().commit();
				manager.close();
			}  catch (HibernateException e) {
				e.printStackTrace();
				manager.getTransaction().rollback();
			}	
		}
		
	//Retorna lista de usuários que ainda não foram aceitos em uma comunidade
		public List<ComunidadeUsuario> getMembrosPendentes(Comunidade com) {
			List<ComunidadeUsuario> pendencias = null;
			manager = factory.createEntityManager();
			
			try {
				pendencias = (List<ComunidadeUsuario>) manager.createQuery("SELECT cu FROM ComunidadeUsuario cu" +
						" WHERE cu.comunidade = :comunidade AND cu.confirmado = 0")
				.setParameter("comunidade", com)
				.getResultList();
				manager.close();
			}  catch (HibernateException e) {
				e.printStackTrace();
				manager.getTransaction().rollback();
			}
			
			return pendencias;
		}
		
	//Aceita pedido de amizade de um determinado usuário
		public void aceitarPedidos(ComunidadeUsuario cu) {
			manager = factory.createEntityManager();
			try {
				cu.setConfirmado(true);
				manager.getTransaction().begin();
				manager.merge(cu);
				manager.getTransaction().commit();
				manager.close();
			}  catch (HibernateException e) {
				e.printStackTrace();
				manager.getTransaction().rollback();
			}
		}

	//Retorna lista de membros de uma comunidade
		public List<Usuario> getMembros(Comunidade com) {
			List<Usuario> membros = null;
			manager = factory.createEntityManager();
			
			try {
				membros = (List<Usuario>) manager.createQuery("SELECT cu.participante FROM ComunidadeUsuario cu" +
						" WHERE cu.comunidade = :comunidade AND cu.confirmado = 1")
				.setParameter("comunidade", com)
				.getResultList();
				manager.close();
			}  catch (HibernateException e) {
				e.printStackTrace();
				manager.getTransaction().rollback();
			}
			
			return membros;
		}
}
