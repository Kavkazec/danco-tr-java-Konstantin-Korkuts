package com.danco.training.servlet.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danco.training.api.IServiceService;
import com.danco.training.entity.Service;
import com.danco.training.service.ServiceService;

public class ChangeServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IServiceService service;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeServiceServlet() {
        super();
        service = new ServiceService();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Service> services = service.getServices();
		int size = services.size();
		request.setAttribute("services", services);
		request.setAttribute("size", size);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/changeServiceSelect.jsp");
		dispatcher.forward(request, response);
	}

}
