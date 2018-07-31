package br.unifenas.mecanicajpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carro")

public class carro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(length = 60, nullable=false)
	private String modelo;
	@Column(length = 60, nullable=false)
	private String marca;
	@Column(name="tipo_combustivel")
	@Enumerated(EnumType.STRING)
	private TipoCombustivel tipoCombustivel;
	@Column(precision=8,scale=2)
	private double valor;
	
	public carro() {
		
	}

	public carro(String modelo, String marca, TipoCombustivel tipoCombustivel, double valor) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.tipoCombustivel = tipoCombustivel;
		this.valor = valor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
