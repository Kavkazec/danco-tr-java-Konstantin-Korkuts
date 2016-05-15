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
 * Servlet implementation class RegistrationServlet
 */
public class Authorization extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService service;
	
	public Authorization(){
		super();
		service = new UserService();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		User user = service.findUser(login, password);
		
		if(user == null){
			getServletContext().getRequestDispatcher("/WrongAuthorization.jsp").forward(request, response);
		} else{
			session.setAttribute("user", user);
			getServletContext().getRequestDispatcher("/main/MainPage.jsp").forward(request, response);
		}
	}
}
