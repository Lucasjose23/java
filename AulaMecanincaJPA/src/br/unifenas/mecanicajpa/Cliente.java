package br.unifenas.mecanicajpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity

public class Cliente extends Pessoa {
	
	private String cpf;
	//@Embedded
	
	@OneToOne(cascade = CascadeType.ALL)//cria uma classe endereco e informa que o relacionamento é um para um
	
	
	private Endereco endereco;
	//private List<Carro> carros;
	
	public Cliente(String nome, String cpf, Endereco endereco) {
		super(nome);
		this.cpf = cpf;
		this.endereco = endereco;
		//this.carros = new ArrayList<>();
	}
	
	public Cliente() {
		//this.carros = new ArrayList<>();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/*public List<Carro> getCarros() {
		//return carros;
	}

	public void setCarros(List<Carro> carros) {
		//this.carros = carros;
	}
	
	public void setCarro(Carro carro) {
		//this.carros.add(carro);
	}*/

	
	

	
	
	
	
}
