package com.danco.training.servlet.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.danco.training.api.IServiceService;
import com.danco.training.entity.Service;
import com.danco.training.service.ServiceService;

public class ChangeServiceResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IServiceService service;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeServiceResultServlet() {
        super();
        service = new ServiceService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		boolean isSuccess = false;
		if(request.getParameter("coast") != null){
			int coast = Integer.parseInt(request.getParameter("coast"));
			Service serviceEntity = (Service) session.getAttribute("serviceEntity");
			serviceEntity.setCoast(coast);
			service.changeServiceCoast(serviceEntity);
			isSuccess = true;
			request.setAttribute("isSuccess", isSuccess);
		} else {
			request.setAttribute("isSuccess", isSuccess);
		}
		getServletContext().getRequestDispatcher("/main/IsSuccessPage.jsp").forward(request, response);
	}

}
