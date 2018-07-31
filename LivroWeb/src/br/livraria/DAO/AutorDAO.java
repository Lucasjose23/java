package br.livraria.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Bean.Autor;

public class AutorDAO {
	public void create(Autor autor) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(autor);
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(Autor autor) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(autor);
		em.getTransaction().commit();
		em.close();
	}
	
	public void delete(Autor autor) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		autor = em.merge(autor);
		em.remove(autor);
		em.getTransaction().commit();
		em.close();
	}
	
	public Autor readId(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		Autor consultaAutor = em.find(Autor.class, id);
		em.close();
		return consultaAutor;
	}
	
	public List<Autor> getReadAll(){
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("from Autor");
		List<Autor> autores = query.getResultList();
		return autores;
	}
}
