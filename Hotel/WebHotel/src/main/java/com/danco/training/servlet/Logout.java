package com.danco.training.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.danco.training.api.IActService;
import com.danco.training.entity.Act;
import com.danco.training.service.ActService;

public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IActService service;
   
    public Logout() {
        super();
        service = new ActService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if(session != null && session.getAttribute("act") != null){
			Act act = (Act) session.getAttribute("act");
			System.out.println("something to output");
			System.out.println(act.getId());
			Date date = new Date();
			act.setLogoutDate(date);
			service.addAct(act);
		}
		session.invalidate();
		
		getServletContext().getRequestDispatcher("/Authorization.jsp").forward(request, response);
	}
}
