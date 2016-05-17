package com.danco.training.servlet.guest;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.danco.training.api.IGuestService;
import com.danco.training.entity.Guest;
import com.danco.training.service.GuestService;

public class ShowGuestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IGuestService service;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowGuestsServlet() {
        super();
        service = new GuestService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Guest> guests = service.getGuests();
		request.setAttribute("guests", guests);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/showGuestPageResult.jsp");
		dispatcher.forward(request, response);
		
	}

}
