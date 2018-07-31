package br.unifenas.mecanicajpa.sistema;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.unifenas.mecanicajpa.Carro;
import br.unifenas.mecanicajpa.Cliente;
import br.unifenas.mecanicajpa.Endereco;
import br.unifenas.mecanicajpa.TipoCombustivel;
import br.unifenas.mecanicajpa.UF;

public class AppTestaJPA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("mecanicajpa");
		
		EntityManager em = emf.createEntityManager();
		
		Cliente cli=new Cliente("jose","123456", new Endereco("rua1","bairro1","1","cidade1",UF.MG));
		
		/*em.getTransaction().begin();
		em.persist(cli);
		em.getTransaction().commit();*/
		
		Cliente cliBusca = em.find(Cliente.class, 1L);
		
		System.out.println(cliBusca.getEndereco().getBairro());
		
		em.close();
		emf.close();
		/*
		Carro c1 = new Carro("kkkk", "Bat", 
				TipoCombustivel.ALCOOL, 15500);
		
		em.getTransaction().begin();
		em.persist(c1);
		em.getTransaction().commit();
		
		//Consultar e remover
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite um id para excluir:");
		long id = entrada.nextLong();
		
		Carro carroCon = em.find(Carro.class,id);
		System.out.println(carroCon.getModelo());
		
		em.getTransaction().begin();
		em.remove(carroCon);
		em.getTransaction().commit();
		
		//Alterar
		System.out.println("Digite um id para alterar:");
		id = entrada.nextLong();
		carroCon = em.find(Carro.class, id);
		
		carroCon.setModelo("Opala");
		
		em.getTransaction().begin();
		em.merge(carroCon);
		em.getTransaction().commit();
		
		Query query = em.createQuery("from Carro");
		List<Carro> carros = query.getResultList();
		for (Carro c : carros) {
			System.out.println("Carro:"+c.getModelo());
		}
		
		em.close();
		emf.close();
		*/
		
	}

}
