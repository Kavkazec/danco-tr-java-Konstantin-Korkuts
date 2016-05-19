package com.danco.training.servlet.guest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.danco.training.api.IGuestService;
import com.danco.training.api.IUserService;
import com.danco.training.entity.Guest;
import com.danco.training.service.GuestService;
import com.danco.training.service.UserService;


public class AddGuestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IGuestService service;
	
	public AddGuestServlet(){
		super();
		service = new GuestService();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isSuccess = false;
		
		
		String name = request.getParameter("name");
		String passportSeries = request.getParameter("passportSeries");
		int passportNumber = Integer.parseInt(request.getParameter("passportNumber"));
		
		
		if(!name.isEmpty() && !passportSeries.isEmpty()){
			Guest guest = new Guest(name, passportSeries, passportNumber);
			service.addGuest(guest);
			isSuccess = true;
			request.setAttribute("isSuccess", isSuccess);
		} else {
			request.setAttribute("isSuccess", isSuccess);
		}
		getServletContext().getRequestDispatcher("/main/IsSuccessPage.jsp").forward(request, response);
	}

}
