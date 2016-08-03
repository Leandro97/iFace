package br.ufal.persistencia;

import org.hibernate.HibernateException;

import br.ufal.modelo.Comunidade;


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
	
	//persiste uma comunidade no banco
		public void salvarComunidade(Comunidade com) {
			manager = factory.createEntityManager();
					
			try {
				manager.getTransaction().begin();
				manager.persist(com);
				manager.getTransaction().commit();
				manager.close();
			}  catch (HibernateException e) {
				e.printStackTrace();
				manager.getTransaction().rollback();
			}	
		}
	
	//retorna um usuário ao receber seu id
		public Comunidade getComunidadeByNome(String nome) {
			manager = factory.createEntityManager();
			Comunidade com = null;
			try {
				com = (Comunidade) manager.createQuery("SELECT c FROM Comunidade c WHERE c.nome = :nome")
				.setParameter("nome", nome)
				.getResultList().get(0);
				manager.close();
			}  catch (HibernateException e) {
				e.printStackTrace();
				manager.getTransaction().rollback();
			}	
			
			return com;
		}

		public Comunidade getComunidadeByNome(int id) {
			manager = factory.createEntityManager();
			Comunidade com = null;
			try {
				com = (Comunidade) manager.createQuery("SELECT c FROM Comunidade c WHERE c.id = :id")
				.setParameter("id", id)
				.getResultList().get(0);
				manager.close();
			}  catch (HibernateException e) {
				e.printStackTrace();
				manager.getTransaction().rollback();
			}	
			
			return com;
		}
		

}
