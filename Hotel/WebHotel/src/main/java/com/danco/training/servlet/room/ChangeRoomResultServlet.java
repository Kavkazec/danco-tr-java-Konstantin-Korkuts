package com.danco.training.servlet.room;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danco.training.api.IRoomService;
import com.danco.training.entity.Room;
import com.danco.training.service.RoomService;

public class ChangeRoomResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRoomService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeRoomResultServlet() {
        super();
        service = new RoomService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isSuccess = false;
		int coast = Integer.parseInt(request.getParameter("coast"));
		boolean isOnRepair = Boolean.parseBoolean(request.getParameter("isOnRepair"));
		int id = Integer.parseInt(request.getParameter("id"));
		if(!isSuccess){
			Room room = service.getByIdRoom(id);
			room.setCoast(coast);
			room.setOnRepair(isOnRepair);
			service.changeRoomCoast(room);
			service.changeRoomStatus(room);
			isSuccess = true;
			request.setAttribute("isSuccess", isSuccess);
		} else {
			request.setAttribute("isSuccess", isSuccess);
		}
		getServletContext().getRequestDispatcher("/main/IsSuccessPage.jsp").forward(request, response);
	}

}
