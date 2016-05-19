package com.danco.training.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		session.invalidate();
		getServletContext().getRequestDispatcher("/Authorization.jsp").forward(request, response);
	}
}
