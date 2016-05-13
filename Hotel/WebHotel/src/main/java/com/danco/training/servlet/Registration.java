package com.danco.training.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danco.training.entity.User;
import com.danco.training.service.UserService;

/**
 * Servlet implementation class Registrattion
 */
public class Registration extends HttpServlet {
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
		String rePassword = request.getParameter("re_password");
		
		
		boolean isFieldsEmpty = (login.isEmpty() && password.isEmpty()) ? true : false;
		boolean isPasswordEquals = (password.equals(rePassword)) ? true : false;
		
		User user = null;

		if(!isFieldsEmpty && !isPasswordEquals){
			user = new User(login, password);
			service.addUser(user);
			getServletContext().getRequestDispatcher("/Main.jsp").forward(request, response);
		}
		
		getServletContext().getRequestDispatcher("/WrongAuthorization.jsp").forward(request, response);

	}
}
