package Bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="livro")
public class Livro {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 60, nullable=false)
	private String titulo;
	
	@Column(length = 60, nullable=false)
	private String isbn;
	
	@Column(precision=8, scale=2)
	private double preco;
	
	@Temporal (TemporalType.DATE)
	private Calendar dataPublicacao = Calendar.getInstance();
	
	@ManyToMany
	private List<Autor> autores;
	
	@ManyToMany
	private List<Editora> editora;
	
	@OneToMany
	private List<Capitulo> capitulo;
	



	public List<Capitulo> getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(List<Capitulo> capitulo) {
		this.capitulo = capitulo;
	}



	public Livro(String titulo, String isbn, double preco, String dataPublicacao) 
	{
		this.titulo = titulo;
		this.isbn = isbn;
		this.preco = preco;
	}
	
	public Livro() 
	{
		this.autores = new ArrayList<Autor>();
		this.editora=new ArrayList<Editora>();
		this.capitulo=new ArrayList<Capitulo>();
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getTitulo() 
	{
		return titulo;
	}

	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}

	public String getIsbn() 
	{
		return isbn;
	}

	public void setIsbn(String isbn) 
	{
		this.isbn = isbn;
	}

	public double getPreco() 
	{
		return preco;
	}

	public void setPreco(double preco) 
	{
		this.preco = preco;
	}
	
	public Calendar getDataPublicacao() 
	{
		return dataPublicacao;
	}

	public void setDataPublicacao(Calendar dataPublicacao) 
	{
		this.dataPublicacao = dataPublicacao;
	}
	
	public void adicionarAutor(Autor autor)
	{
		this.autores.add(autor);
	}

	public List<Autor> getAutores() 
	{
		return autores;
	}
	
	
	public List<Editora> getEditora() {
		return editora;
	}

	public void setEditora(List<Editora> editora) {
		this.editora = editora;
	}
	public void adicionarEditora(Editora editora)
	{
		this.editora.add(editora);
	}
	public void adicionarCapitulo(Capitulo capitulo)
	{
		this.capitulo.add(capitulo);
	}
	

}
