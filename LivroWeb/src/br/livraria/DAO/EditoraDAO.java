package br.livraria.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Bean.Editora;;

public class EditoraDAO {
	public void create(Editora editora) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(editora);
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(Editora editora) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(editora);
		em.getTransaction().commit();
		em.close();
	}
	
	public void delete(Editora editora) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		editora = em.merge(editora);
		em.remove(editora);
		em.getTransaction().commit();
		em.close();
	}
	
	public Editora readId(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		Editora consultaEditora = em.find(Editora.class, id);
		em.close();
		return consultaEditora;
	}
	
	public List<Editora> getReadAll(){
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("from Editora");
		List<Editora> editoras = query.getResultList();
		return editoras;
	}
}
