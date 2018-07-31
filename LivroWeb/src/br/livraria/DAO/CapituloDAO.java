package br.livraria.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Bean.Capitulo;



public class CapituloDAO {
	public void create(Capitulo capitulo) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(capitulo);
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(Capitulo capitulo) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(capitulo);
		em.getTransaction().commit();
		em.close();
	}
	
	public void delete(Capitulo capitulo) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		capitulo = em.merge(capitulo);
		em.remove(capitulo);
		em.getTransaction().commit();
		em.close();
	}
	
	public Capitulo readId(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		Capitulo consultaCapitulo = em.find(Capitulo.class, id);
		em.close();
		return consultaCapitulo;
	}
	
	public List<Capitulo> getReadAll(){
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("from Capitulo");
		List<Capitulo> capitulos = query.getResultList();
		return capitulos;
	}

}
