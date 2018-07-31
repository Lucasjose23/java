package br.livraria.bean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import Bean.Autor;
import Bean.Capitulo;
import Bean.Editora;
import Bean.Livro;
import br.livraria.DAO.AutorDAO;
import br.livraria.DAO.CapituloDAO;
import br.livraria.DAO.EditoraDAO;
import br.livraria.DAO.LivroDAO;

@ManagedBean(name = "LivroBean")
@ViewScoped
public class LivroBean {
	
	private Livro livro = new Livro();
	private Editora editora = new Editora();
	private Capitulo capitulo=new Capitulo();
	
	
	public Capitulo getCapitulo() {
		return capitulo;
	}
	public void setCapitulo(Capitulo capitulo) {
		this.capitulo = capitulo;
	}

	private int autorId;
	private int editoraId;
	private int capituloId;
	public int getCapituloId() {
		return capituloId;
	}
	public void setCapituloId(int capituloId) {
		this.capituloId = capituloId;
	}
	public Livro getLivro() 
	{
		return livro;
	}
	public void setLivro(Livro livro) 
	{
		this.livro = livro;
	}
	
	public int getAutorId() 
	{
		return autorId;
	}
	public void setAutorId(int autorId) 
	{
		this.autorId = autorId;
	}
	public int getEditoraId() 
	{
		return editoraId;
	}
	public void setEditoraId(int editoraId) 
	{
		this.editoraId = editoraId;
	}
	
	//Exibe todos os autores
	public List<Autor> getAutores()
	{
		return new AutorDAO().getReadAll();
	}
	public List<Editora> getEditora()
	{
		return new EditoraDAO().getReadAll();
	}
	public List<Capitulo> getCapitulo1()
	{
		return new CapituloDAO().getReadAll();
	}
	
	//Exibe todos os livros
	public List<Livro> getLivros()
	{
		return new LivroDAO().getReadAll();
	}
	
	//Adiciona um autor a lista de autores do livro
	public void adicionarAutor()
	{
		Autor autor = new AutorDAO().readId(this.autorId);
		this.livro.adicionarAutor(autor);
	}
	
	public void deletarAutor(Autor autor)
	{
		this.livro.getAutores().remove(autor);
	}
	
	//Ver em tempo real o que esta acontecendo
	public List<Autor> getAutoresLivro()
	{
		return this.livro.getAutores();
	}
	
	
	
	
	public void adicionarEditora()
	{
		this.editora= new EditoraDAO().readId(this.editoraId);
		this.livro.adicionarEditora(editora);
	}
	
	public void deletarEditora(Editora editora)
	{
		this.livro.getEditora().remove(editora);
	}
	
	//Ver em tempo real o que esta acontecendo
	public List<Editora> getEditoraLivro()
	{
		return this.livro.getEditora();
	}
	
	
	//capitulos
	public void adicionarCapitulo()
	{
		this.capitulo= new CapituloDAO().readId(this.capituloId);
		this.livro.adicionarCapitulo(capitulo);
	}
	
	
	//Ver em tempo real o que esta acontecendo
	
	public List<Capitulo> getCapituloLivro()
	{
		return this.livro.getCapitulo();
	}
	
	public void salvar() throws IOException 
	{
		if(this.livro.getId()==0)
		{
			new LivroDAO().create(livro);
			FacesContext.getCurrentInstance().getExternalContext().redirect("cadastroLivro.xhtml");
		}else 
		{
			new LivroDAO().update(livro);
			FacesContext.getCurrentInstance().getExternalContext().redirect("cadastroLivro.xhtml");
		}
	}

	public String formAutor()
	{
		return "cadastroAutor?faces-redirect=true";
	}
	
	public void deletar(Livro livro)
	{
		new LivroDAO().delete(livro);
	}
	
	public void carregar(Livro livro)
	{
		this.livro = livro;	
	}
	
}
