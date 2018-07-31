package webmecanica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import webmecanica.dao.JPAUtil;
import modelo.Carro;;

public class CarroDAO {
	public void create(Carro carro) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(carro);
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(Carro carro) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(carro);
		em.getTransaction().commit();
		em.close();
	}
	
	public void delete(Carro carro) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(carro);
		em.getTransaction().commit();
		em.close();
	}
	
	public Carro readId(long id) {
		EntityManager em = JPAUtil.getEntityManager();
		Carro consultaCarro = em.find(Carro.class, id);
		em.close();
		return consultaCarro;
	}
	
	public List<Carro> getReadAll(){
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("from Carro");
		List<Carro> carros = query.getResultList();
		return carros;
	}
}
