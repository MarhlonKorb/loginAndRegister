package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Vo.DataUser;
import model.Conectar;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Conectar connection;
	
	public void init() {
		 connection = new Conectar();
	}
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
		register(request, response);
	} catch (ClassNotFoundException | IOException | ServletException e) {
		e.printStackTrace();
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}
	
	private void register(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException, ServletException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String buttonClicked = request.getParameter("enter");
		DataUser user = new DataUser(email, password);
		connection.createUser(user);
		
		if(buttonClicked.equals("enter") && user !=null && user.getEmail() != null) {
		request.setAttribute("mensagem", user.getEmail());
		request.getRequestDispatcher("home-page.jsp").forward(request, response);
		}
		else {
			request.setAttribute("mensagem", "Dados não encontrados");
			request.getRequestDispatcher("login-page.jsp").forward(request, response);
		}
	}
}
