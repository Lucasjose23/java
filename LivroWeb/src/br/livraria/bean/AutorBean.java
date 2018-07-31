package br.livraria.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import Bean.Autor;
import Bean.Livro;
import br.livraria.DAO.AutorDAO;
import br.livraria.DAO.LivroDAO;

@ManagedBean(name = "AutorBean")
@ViewScoped
public class AutorBean {

	AutorDAO autorDao = new AutorDAO();
	Autor autor = new Autor();

	private List<Autor> listaAutores = new ArrayList<Autor>();

	public Autor getAutor() 
	{
		return autor;
	}

	public void setAutor(Autor autor) 
	{
		this.autor = autor;
	}

	public void adicionar() throws IOException 
	{
		this.autorDao.create(autor);
		FacesContext.getCurrentInstance().getExternalContext().redirect("cadastroAutor.xhtml");
	}

	public List<Autor> getListaAutores() 
	{
		return listaAutores;
	}

	@PostConstruct
	public void setListaAutores() 
	{
		this.listaAutores = autorDao.getReadAll();
	}
	
		

}
