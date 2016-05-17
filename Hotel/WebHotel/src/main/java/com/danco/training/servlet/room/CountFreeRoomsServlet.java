package com.danco.training.servlet.room;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danco.training.api.IRoomService;
import com.danco.training.service.RoomService;

public class CountFreeRoomsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRoomService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountFreeRoomsServlet() {
        super();
        service = new RoomService();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = service.numberOfFreeRooms();
		request.setAttribute("count", count);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/countFreeRoomsResultPage.jsp");
		dispatcher.forward(request, response);
	}

}
