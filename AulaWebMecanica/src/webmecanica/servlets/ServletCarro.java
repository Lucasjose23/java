package webmecanica.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Carro;
import modelo.TipoCombustivel;
import webmecanica.dao.CarroDAO;

/**
 * Servlet implementation class ServletCarro
 */
@WebServlet("/ServletCarro")
public class ServletCarro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCarro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		long id;
		Carro carro;
		CarroDAO dao = new CarroDAO();
		
		switch(action) {
		case "edit":
			id = Long.parseLong(request.getParameter("id"));
			carro = dao.readId(id);
			request.setAttribute("carro", carro);
			request.getRequestDispatcher("formcarro.jsp").forward(request, response);
			break;
			
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CarroDAO dao = new CarroDAO();
		
		//Inserir
		if(request.getParameter("id").isEmpty()) {
			
			Carro carro = new Carro();
			carro.setModelo(request.getParameter("modelo"));
			carro.setMarca(request.getParameter("marca"));
			carro.setTipoCombustivel(TipoCombustivel.valueOf(request.getParameter("tipocombustivel")));
			carro.setValor(Double.parseDouble(request.getParameter("valor")));
			
			dao.create(carro);
		}else {
			long id = Long.parseLong(request.getParameter("id"));
			
			Carro carro = dao.readId(id);
			
			carro.setModelo(request.getParameter("modelo"));
			carro.setMarca(request.getParameter("marca"));
			carro.setTipoCombustivel(TipoCombustivel.valueOf(request.getParameter("tipocombustivel")));
			carro.setValor(Double.parseDouble(request.getParameter("valor")));
			
			dao.update(carro);
		}
		
		response.sendRedirect("consultacarros.jsp");
		
	}

}
