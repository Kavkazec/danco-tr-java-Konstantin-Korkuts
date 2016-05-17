package com.danco.training.servlet.room;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danco.training.api.IRoomService;
import com.danco.training.entity.Room;
import com.danco.training.service.RoomService;

public class AddRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRoomService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoomServlet() {
        super();
        service = new RoomService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isSuccess = false;
		
		
		int number = Integer.parseInt(request.getParameter("number"));
		int capacity = Integer.parseInt(request.getParameter("capacity"));
		int numberOfStars = Integer.parseInt(request.getParameter("numberOfStars"));
		int coast = Integer.parseInt(request.getParameter("coast"));
		boolean isOnRepair = Boolean.parseBoolean(request.getParameter("isOnRepair"));
		
		
		if(!isSuccess){
			Room room = new Room(number, capacity, numberOfStars, coast, isOnRepair);
			service.addRoom(room);
			isSuccess = true;
			request.setAttribute("isSuccess", isSuccess);
		} else {
			request.setAttribute("isSuccess", isSuccess);
		}
		getServletContext().getRequestDispatcher("/main/IsSuccessPage.jsp").forward(request, response);
	}

}
