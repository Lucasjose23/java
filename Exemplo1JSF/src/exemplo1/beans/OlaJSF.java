package exemplo1.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class OlaJSF {
	private float peso;
	private float altura;
	private float imc;
	
	public void calcularIMC() {
		this.imc = this.peso/ (this.altura * this.altura);                                                 
	}
	
	
	public OlaJSF() {
		super();
	}


	public OlaJSF(float peso, float altura, float imc) {
		super();
		this.peso = peso;
		this.altura = altura;
		this.imc = imc;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public float getImc() {
		return imc;
	}
	public void setImc(float imc) {
		this.imc = imc;
	}
	
	
}
