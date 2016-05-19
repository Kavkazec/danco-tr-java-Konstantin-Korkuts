package com.danco.training.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.danco.training.api.IActService;
import com.danco.training.api.IUserService;
import com.danco.training.entity.Act;
import com.danco.training.entity.User;
import com.danco.training.service.ActService;
import com.danco.training.service.UserService;

/**
 * Servlet implementation class RegistrationServlet
 */
public class Authorization extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService service;
	private IActService actServ;
	
	public Authorization(){
		super();
		service = new UserService();
		actServ = new ActService();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(true);
		String resourse = httpRequest.getRequestURL().toString();
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		User user = service.findUser(login, password);
		Act act = new Act(user, new Date(), new Date(), resourse);
		actServ.addAct(act);
		session.setAttribute("act", act);
		
		
		if(user == null){
			getServletContext().getRequestDispatcher("/WrongAuthorization.jsp").forward(request, response);
		} else{
			session.setAttribute("user", user);
			getServletContext().getRequestDispatcher("/main/MainPage.jsp").forward(request, response);
		}
	}
}
