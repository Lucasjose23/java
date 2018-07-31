package br.livraria.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Bean.Capitulo;

import br.livraria.DAO.CapituloDAO;


@ManagedBean(name = "CapituloBean")
@ViewScoped

public class CapituloBean {
	CapituloDAO capituloDao = new CapituloDAO();
	Capitulo capitulo = new Capitulo();


	private List<Capitulo> listaCapitulo = new ArrayList<Capitulo>();

	public Capitulo getCapitulo() 
	{
		return capitulo;
	}

	public void setCapitulo(Capitulo capitulo) 
	{
		this.capitulo = capitulo;
	}

	public void adicionar() throws IOException 
	{
		this.capituloDao.create(capitulo);
		//FacesContext.getCurrentInstance().getExternalContext().redirect("CadastroEditora.xhtml");
		//this.listaEditora.add(editora);
	}

	public List<Capitulo> getListaCapitulo() 
	{
		return this.listaCapitulo;
	}

	@PostConstruct
	public void setListaCapitulos() 
	{
		this.listaCapitulo = this.capituloDao.getReadAll();
	}
	
		

}
