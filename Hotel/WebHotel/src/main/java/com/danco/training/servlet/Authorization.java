package com.danco.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danco.training.entity.User;
import com.danco.training.service.UserService;

/**
 * Servlet implementation class RegistrationServlet
 */
public class Authorization extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		service = new UserService();
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		User user = null;
		if(!login.isEmpty() && !password.isEmpty()){
			user = new User(login, password);
		}
		
		if(!service.findUser(login, password)){
			getServletContext().getRequestDispatcher("/WrongAuthorization.jsp").forward(request, response);
		}
		
		getServletContext().getRequestDispatcher("/Main.jsp").forward(request, response);


	}

}
