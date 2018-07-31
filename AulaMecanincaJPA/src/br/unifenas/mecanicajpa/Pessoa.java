package br.unifenas.mecanicajpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)//tabela apelas para classes comcretas (cliente)
@Inheritance(strategy=InheritanceType.JOINED)//tabela para classe pessoa e classe cliente

public abstract class Pessoa {
	
	/*
	 * Atributos
	 */
	@Id
	//@GeneratedValue(strategy=GenerationType.TABLE)
	@GeneratedValue(strategy=GenerationType.IDENTITY)//
	private long id;
	private String nome;
	
	/*
	 * Construtor
	 */
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	public Pessoa() {
		
	}

	/*
	 * Propriedades
	 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

}
