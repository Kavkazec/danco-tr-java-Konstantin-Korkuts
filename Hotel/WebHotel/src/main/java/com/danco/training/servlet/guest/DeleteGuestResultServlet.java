package com.danco.training.servlet.guest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danco.training.api.IGuestService;
import com.danco.training.entity.Guest;
import com.danco.training.service.GuestService;

public class DeleteGuestResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IGuestService service;   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteGuestResultServlet() {
        super();
        service = new GuestService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isSuccess = false;
		if(request.getParameter("select_guest") != null){
			int id = Integer.parseInt(request.getParameter("select_guest"));
			Guest guest = service.getByIdGuest(id);
			service.deleteGuest(guest);
			isSuccess = true;
			request.setAttribute("isSuccess", isSuccess);
		} else {
			request.setAttribute("isSuccess", isSuccess);
		}
		getServletContext().getRequestDispatcher("/main/IsSuccessPage.jsp").forward(request, response);
	}

}
