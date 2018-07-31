package rede.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rede.classes.Membro;
import rede.classes.Publicacao;
import redes.dao.RedeDAO;


@WebServlet("/servletPublicacao")
public class servletPublicacao extends HttpServlet {
private static final long serialVersionUID = 1L;
	
    public servletPublicacao() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RedeDAO dao=new RedeDAO();
		Publicacao p=new Publicacao();
		p.setTexto(request.getParameter("texto"));
		p.setDatahora(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(System.currentTimeMillis()));
		
		String usuario=request.getParameter("usuario");
		String senha=request.getParameter("senha");
		boolean valid = dao.getUsuarioPublBoo(usuario, senha);
		
		if(valid)
		{
			Membro m=dao.getUsuarioPubl(usuario,senha); 	  				
			List<Publicacao>lista=new ArrayList<>();
			lista.add(p);
			m.setPublicacoes(lista);
			p.setMembro(m);
			boolean valid2 = dao.createPublicao(p);
			if(valid2)
			{
				dao.update(m);
				request.setAttribute("mensagem", "Publicação cadastrada com sucesso! Vá no inicio para vê-la!");
		        RequestDispatcher rd = request.getRequestDispatcher("Publicar.jsp");
		        rd.forward(request, response);
			}
			else
			{
				request.setAttribute("mensagem", "Campo de publicação em branco preencha-o!");
		        RequestDispatcher rd = request.getRequestDispatcher("Publicar.jsp");
		        rd.forward(request, response);
			}
		}
		else
		{
			request.setAttribute("mensagem", "Usuario e senha incompatíveis ou inexistente(s)!");
	        RequestDispatcher rd = request.getRequestDispatcher("Publicar.jsp");
	        rd.forward(request, response);
		}

	}
}
