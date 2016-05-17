package com.danco.training.servlet.room;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danco.training.api.IRoomService;
import com.danco.training.entity.Room;
import com.danco.training.service.RoomService;

public class ChangeRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRoomService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeRoomServlet() {
        super();
        service = new RoomService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Room> rooms = service.getRooms();
		request.setAttribute("rooms", rooms);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/showRoomsPageResult.jsp");
		dispatcher.forward(request, response);
	}

}
