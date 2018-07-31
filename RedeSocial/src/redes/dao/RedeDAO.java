package redes.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import rede.classes.Membro;
import rede.classes.Publicacao;
import redes.dao.JPAUtil;

public class RedeDAO {
	
	public boolean createMembro(Membro membro) 
	{
		if(membro.getNome()!= "" && membro.getUsuario()!= "" && membro.getSenha()!= "")
		{
			EntityManager em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(membro);
			em.getTransaction().commit();
			em.close();
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean createPublicao(Publicacao publicacao) 
	{
		if(publicacao.getTexto()!= "" )
		{
			EntityManager em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(publicacao);
			em.getTransaction().commit();
			em.close();
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void update(Membro membro) 
	{
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(membro);
		em.getTransaction().commit();
		em.close();
	}
	
	public boolean getUsuarioCad(String nomeUsuario) 
	{
		try 
		{
			EntityManager em = JPAUtil.getEntityManager();                                                
			String query="SELECT u from Membro u where u.usuario = :usuario";
			TypedQuery<Membro> usuario = em.createQuery(query,Membro.class);
			usuario.setParameter("usuario", nomeUsuario);
			Membro m=usuario.getSingleResult();
			return true;
		}
		catch (NoResultException e) 
		{
			return false;
		}
	}
	
	public Membro getUsuarioPubl(String nomeUsuario, String senha) 
	{
		try 
		{
			EntityManager em = JPAUtil.getEntityManager();                                                
			String query="SELECT u from Membro u where u.usuario = :usuario and u.senha = :senha";
			TypedQuery<Membro> usuario = em.createQuery(query,Membro.class);
			usuario.setParameter("usuario", nomeUsuario);
			usuario.setParameter("senha", senha);
			Membro m=usuario.getSingleResult();
			return m;
		}
		catch (NoResultException e) 
		{
			return null;
		}
	}
	
	public boolean getUsuarioPublBoo(String nomeUsuario, String senha) 
	{
		try 
		{
			EntityManager em = JPAUtil.getEntityManager();                                                
			String query="SELECT u from Membro u where u.usuario = :usuario and u.senha = :senha";
			TypedQuery<Membro> usuario = em.createQuery(query,Membro.class);
			usuario.setParameter("usuario", nomeUsuario);
			usuario.setParameter("senha", senha);
			Membro m=usuario.getSingleResult();
			return true;
		}
		catch (NoResultException e) 
		{
			return false;
		}
	}
	
	public List<Publicacao> getReadAll()
	{
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("from Publicacao");
		List<Publicacao> publicacoes = query.getResultList();
		return publicacoes;
	}
	
	public List<Membro> getReadAll2()
	{
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("from Membro");
		List<Membro> membros = query.getResultList();
		return membros;
	}


}
