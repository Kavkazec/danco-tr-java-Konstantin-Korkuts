package com.danco.training.servlet.guest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danco.training.api.IGuestService;
import com.danco.training.service.GuestService;

public class CountGuestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IGuestService service;   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountGuestsServlet() {
        super();
        service = new GuestService();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = service.numberOfGuests();
		request.setAttribute("count", count);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/countGuestsPageResult.jsp");
		dispatcher.forward(request, response);
	}

}
