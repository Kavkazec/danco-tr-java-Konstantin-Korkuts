package com.danco.training.servlet.room;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danco.training.api.IRoomService;
import com.danco.training.entity.Room;
import com.danco.training.service.RoomService;

public class ShowRoomDetailsResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRoomService service;   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowRoomDetailsResultServlet() {
        super();
        service = new RoomService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("select_room") != null){
			int id = Integer.parseInt(request.getParameter("select_room"));
			Room room = service.getByIdRoom(id);
			request.setAttribute("room", room);
		} 
		getServletContext().getRequestDispatcher("/pages/showRoomDetailsResultPage.jsp").forward(request, response);
	}

}
