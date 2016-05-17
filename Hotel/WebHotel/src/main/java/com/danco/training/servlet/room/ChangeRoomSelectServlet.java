package com.danco.training.servlet.room;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.danco.training.api.IRoomService;
import com.danco.training.entity.Room;
import com.danco.training.service.RoomService;

public class ChangeRoomSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRoomService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeRoomSelectServlet() {
        super();
        service = new RoomService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String criterion = request.getParameter("criterion");
		int id = Integer.parseInt(request.getParameter("select_room"));
		Room room = service.getByIdRoom(id);
		request.setAttribute("criterion", criterion);
		request.setAttribute("room", room);
		getServletContext().getRequestDispatcher("/pages/changeRoomResult.jsp").forward(request, response);


	}

}
