package Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//primeiro classe java depois bean depois dao depois classe java livro depois classe bean livro olhar array
@Entity
@Table(name="autor")
public class Autor  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAutor;
	
	@Column(length = 60, nullable=false)
	private String nome;
	
	@Column(length = 60, nullable=false)
	private String cpf;
	

	public Autor(String nome, String cpf) 
	{
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public Autor() 
	{
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) 
	{
		this.cpf = cpf;
	}

	public Integer getIdAutor() 
	{
		return idAutor;
	}

	public void setIdAutor(Integer idAutor) 
	{
		this.idAutor = idAutor;
	}
	
	
}
