package br.unifenas.mecanicajpa.sistema;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.unifenas.mecanicajpa.Servico;
import br.unifenas.mecanicajpa.TipoCombustivel;
import br.unifenas.mecanicajpa.carro;

public class AppTestaJPA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mecanicajpa");//momento que cria as tabelas
		EntityManager em = emf.createEntityManager();//trabalha a persistencia 
		
		carro c1 = new carro("Batmovel", "bat", TipoCombustivel.ALCOOL, 12000);
		carro c2 = new carro("gol", "volks", TipoCombustivel.GASOLINA, 13000);
		Servico s1 =  new Servico("troca de Feios", 200);
		
		//insere na tabela
		//em.getTransaction().begin();
		//em.persist(c1);
		//em.persist(c2);
		//em.persist(s1);		
		//em.getTransaction().commit();
		
		//Scanner entrada = new Scanner(System.in);
		//System.out.println("Digite o id:");
		//long id = entrada.nextLong();
		
		//consulta na tabela
		//carro carroCon = em.find(carro.class, id);//busca o registro no banco referente ao id.
		//System.out.println(carroCon.getModelo());
		
		//deleta na tabela
		//em.getTransaction().begin();
		//em.remove(carroCon);
		//em.getTransaction().commit();
		
		//Update
		/*Scanner entradaU = new Scanner(System.in);
		System.out.println("Digite o id:");
		long idU = entradaU.nextLong();
		carroCon = em.find(carro.class, idU);
		
		carroCon.setModelo("O que voce quiser");
		em.getTransaction().begin();
		em.merge(carroCon);
		em.getTransaction().commit();*/
		
		
		Query query = em.createQuery("from carro");
		List<carro> carros = query.getResultList();
		
		for (carro c : carros) {
			System.out.println("Carro:"+ c.getModelo());
		}
		
		em.close();
		emf.close();
	}

}
