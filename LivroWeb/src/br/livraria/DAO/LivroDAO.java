package br.livraria.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Bean.Livro;

public class LivroDAO {
	public void create(Livro livro) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(livro);
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(Livro livro) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(livro);
		em.getTransaction().commit();
		em.close();
	}
	
	public void delete(Livro livro) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		livro = em.merge(livro);
		em.remove(livro);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public Livro readId(long id) {
		EntityManager em = JPAUtil.getEntityManager();
		Livro consultaLivro = em.find(Livro.class, id);
		em.close();
		return consultaLivro;
	}
	
	public List<Livro> getReadAll(){
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("from Livro");
		List<Livro> livros = query.getResultList();
		return livros;
	}
}
