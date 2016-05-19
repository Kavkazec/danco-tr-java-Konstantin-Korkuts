package com.danco.training.servlet.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.danco.training.api.IServiceService;
import com.danco.training.entity.Guest;
import com.danco.training.entity.Service;
import com.danco.training.service.ServiceService;

public class ChangeServiceSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IServiceService service;    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeServiceSelectServlet() {
        super();
        service = new ServiceService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if(request.getParameter("select_service") != null){
			int id = Integer.parseInt(request.getParameter("select_service"));
			Service serviceEntity = service.getByIdService(id);
			session.setAttribute("serviceEntity", serviceEntity);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/changeServiceResult.jsp");
		dispatcher.forward(request, response);
	}

}
