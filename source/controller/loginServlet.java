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
import model.CreateConnection;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CreateConnection connection;
	
	public void init() {
		 connection = new CreateConnection();
	}
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}
	
	private void register(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		DataUser user = new DataUser(email, password);
		connection.createUser(user);
		response.sendRedirect("register.jsp");
	}

}
