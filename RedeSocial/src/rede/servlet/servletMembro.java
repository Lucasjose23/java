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


@WebServlet("/servletMembro")
public class servletMembro extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public servletMembro() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RedeDAO dao=new RedeDAO();
		Membro m=new Membro();
		String usuario=request.getParameter("usuario");
		boolean valid = dao.getUsuarioCad(usuario);
		if(valid)
		{
			request.setAttribute("mensagem", "Nome de usuário já existente! Tente outro!");
	        RequestDispatcher rd = request.getRequestDispatcher("Cadastro.jsp");
	        rd.forward(request, response);
		}
		else
		{
			m.setNome(request.getParameter("nome"));
			m.setUsuario(request.getParameter("usuario"));
			m.setSenha(request.getParameter("senha"));
			m.setPublicacoes(new ArrayList<Publicacao>());
			boolean valid2 = dao.createMembro(m);
			if(valid2)
			{
				request.setAttribute("mensagem", "Usuário criado com sucesso! Vá em publicar para fazer sua publicação!");
		        RequestDispatcher rd = request.getRequestDispatcher("Cadastro.jsp");
		        rd.forward(request, response);
			}
			else 
			{
				request.setAttribute("mensagem", "Há Campo(s) em branco(s) preencha todos!");
		        RequestDispatcher rd = request.getRequestDispatcher("Cadastro.jsp");
		        rd.forward(request, response);
			}
		}

	}

}
