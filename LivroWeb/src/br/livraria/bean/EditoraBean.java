package br.livraria.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import Bean.Autor;
import Bean.Editora;
import Bean.Livro;
import br.livraria.DAO.AutorDAO;
import br.livraria.DAO.EditoraDAO;

import br.livraria.DAO.LivroDAO;

@ManagedBean(name = "EditoraBean")
@ViewScoped
public class EditoraBean {

	EditoraDAO editoraDao = new EditoraDAO();
	Editora editora = new Editora();


	private List<Editora> listaEditora = new ArrayList<Editora>();

	public Editora getEditora() 
	{
		return editora;
	}

	public void setEditora(Editora editora) 
	{
		this.editora = editora;
	}

	public void adicionar() throws IOException 
	{
		this.editoraDao.create(editora);
		//FacesContext.getCurrentInstance().getExternalContext().redirect("CadastroEditora.xhtml");
		//this.listaEditora.add(editora);
	}

	public List<Editora> getListaEditora() 
	{
		return this.listaEditora;
	}

	@PostConstruct
	public void setListaEditoras() 
	{
		this.listaEditora = editoraDao.getReadAll();
	}
	
		

}
