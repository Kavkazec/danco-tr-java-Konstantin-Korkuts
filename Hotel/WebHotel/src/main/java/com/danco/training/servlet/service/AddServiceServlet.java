package com.danco.training.servlet.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danco.training.api.IServiceService;
import com.danco.training.entity.Guest;
import com.danco.training.entity.Service;
import com.danco.training.service.ServiceService;

public class AddServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IServiceService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServiceServlet() {
        super();
        service = new ServiceService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isSuccess = false;
		
		String name = request.getParameter("name");
		int coast = Integer.parseInt(request.getParameter("coast"));
		
		
		if(!name.isEmpty()){
			Service serviceEntity = new Service(name, coast);
			serviceEntity.setType("service");
			service.addService(serviceEntity);
			isSuccess = true;
			request.setAttribute("isSuccess", isSuccess);
		} else {
			request.setAttribute("isSuccess", isSuccess);
		}
		getServletContext().getRequestDispatcher("/main/IsSuccessPage.jsp").forward(request, response);
	}

}
