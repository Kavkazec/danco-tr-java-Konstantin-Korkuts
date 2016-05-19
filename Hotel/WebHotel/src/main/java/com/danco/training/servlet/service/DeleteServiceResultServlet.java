package com.danco.training.servlet.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danco.training.api.IGuestService;
import com.danco.training.api.IServiceService;
import com.danco.training.entity.Guest;
import com.danco.training.entity.Service;
import com.danco.training.service.GuestService;
import com.danco.training.service.ServiceService;

public class DeleteServiceResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IServiceService service;   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServiceResultServlet() {
        super();
        service = new ServiceService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isSuccess = false;
		if(request.getParameter("select_service") != null){
			int id = Integer.parseInt(request.getParameter("select_service"));
			Service serviceEntity = service.getByIdService(id);
			service.deleteService(serviceEntity);
			isSuccess = true;
			request.setAttribute("isSuccess", isSuccess);
		} else {
			request.setAttribute("isSuccess", isSuccess);
		}
		getServletContext().getRequestDispatcher("/main/IsSuccessPage.jsp").forward(request, response);
	}

}
