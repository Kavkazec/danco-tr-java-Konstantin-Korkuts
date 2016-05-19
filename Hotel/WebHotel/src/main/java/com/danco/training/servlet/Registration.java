package com.danco.training.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.danco.training.api.IUserService;
import com.danco.training.entity.User;
import com.danco.training.service.UserService;

/**
 * Servlet implementation class Registrattion
 */
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService service;   
	
	public Registration(){
		super();
		service = new UserService();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("re_password");
		
		boolean isPasswordEquals = (password.equals(rePassword)) ? true : false;
		
		User user = null;

		if(!isPasswordEquals){
			user = new User(login, password);
			if(user != service.findUser(login, password)){
				service.addUser(user);
				session.setAttribute("user", user);
				getServletContext().getRequestDispatcher("/main/MainPage.jsp").forward(request, response);
			}
		}
		
		getServletContext().getRequestDispatcher("/WrongAuthorization.jsp").forward(request, response);

	}
}
