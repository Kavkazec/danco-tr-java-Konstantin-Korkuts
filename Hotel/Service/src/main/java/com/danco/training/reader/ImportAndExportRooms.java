package com.danco.training.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.danco.training.api.IRoomDao;
import com.danco.training.di.DependencyInjection;
import com.danco.training.entity.Room;
import com.danco.training.persisexception.PersistenceException;
import com.danco.training.service.RoomService;

public class ImportAndExportRooms {
	private static final String SEPAR = " ; ";
	private static final String NEXT_LINE = "\n";
	private static final Logger LOGGER = Logger.getLogger(ImportAndExportRooms.class);
	private IRoomDao dao = (IRoomDao) DependencyInjection.getInstance().getClassInstance(IRoomDao.class);

	public void writeToFileRooms(Session session, String path) throws PersistenceException {
		FileWriter fw = null;
		List<Room> list = dao.getAll(session);
		try {
			fw = new FileWriter(path);
			fw.append(Room.class.getSimpleName());
			fw.append(NEXT_LINE);
			for (int i = 0; i < list.size(); i++) {
				fw.append(list.get(i).getId() + "");
				fw.append(SEPAR);
				fw.append(list.get(i).getNumber() + "");
				fw.append(SEPAR);
				fw.append(list.get(i).getCapacity() + "");
				fw.append(SEPAR);
				fw.append(list.get(i).getNumberOfStars() + "");
				fw.append(SEPAR);
				fw.append(list.get(i).getCoast() + "");
				fw.append(SEPAR);
				fw.append(list.get(i).isFreeRoom() + "");
				fw.append(SEPAR);
				fw.append(list.get(i).isOnRepair() + "");
				fw.append(SEPAR);
				fw.append(list.get(i).getType());
				fw.append(SEPAR);
				fw.append(NEXT_LINE);
			}
			fw.flush();
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
	}

	public List<Room> readFromFileRooms(Session session, String path) {
		List<String> list = new ArrayList<String>();
		List<Room> rooms = new ArrayList<Room>();
		String line = "";
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader(path));
			while ((line = bf.readLine()) != null) {
				list.add(line);
			}
			for (int i = 1; i < list.size(); i++) {
				if (Room.class.getSimpleName().equals(list.get(0))) {
					String[] arr = list.get(i).split(SEPAR);
					int id = Integer.parseInt(arr[0]);
					int number = Integer.parseInt(arr[1]);
					int capacity = Integer.parseInt(arr[2]);
					int stars = Integer.parseInt(arr[3]);
					int coast = Integer.parseInt(arr[4]);
					boolean status = Boolean.parseBoolean(arr[5]);
					boolean onRepair = Boolean.parseBoolean(arr[6]);
					String type = arr[7];
					Room rm = new Room(id, number, capacity, stars, coast, status);
					rm.setOnRepair(onRepair);
					rm.setType(type);
					if (!rooms.contains(rm)) {
						rooms.add(rm);
					}
				}
			}
		} catch (FileNotFoundException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			try {
				bf.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
		return rooms;

	}
}
