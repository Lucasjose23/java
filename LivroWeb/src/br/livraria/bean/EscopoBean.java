package br.livraria.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Bean.Autor;
import Bean.Livro;
import br.livraria.DAO.AutorDAO;
import br.livraria.DAO.LivroDAO;

@ManagedBean(name = "EscopoBean")
@ViewScoped
public class EscopoBean {
	private AutorDAO autorDao = new AutorDAO();
	private LivroDAO livroDao = new LivroDAO();
	private Livro livro = new Livro();
	private Autor autor = new Autor();
	private List<Livro> listaLivros = new ArrayList<Livro>();
	private List<Autor> autores = autorDao.getReadAll();
	
	public Livro getLivro() 
	{
		return livro;
	}
	public void setLivro(Livro livro) 
	{
		this.livro = livro;
	}
	
	public Autor getAutor() 
	{
		return autor;
	}
	public void setAutor(Autor autor) 
	{
		this.autor = autor;
	}
	
	public List<Livro> getListaLivros() 
	{
		return listaLivros;
	}
	
	@PostConstruct
	public void preencheLista() 
	{
		this.listaLivros = livroDao.getReadAll();
	}

	public List<Autor> getListaAutores() 
	{
		return autores;
	}
	
}
