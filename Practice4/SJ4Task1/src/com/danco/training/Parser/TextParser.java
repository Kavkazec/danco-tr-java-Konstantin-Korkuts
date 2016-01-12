package com.danco.training.Parser;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


import com.danco.training.TextFileWorker;
import com.danco.training.Model.GuestModel;
import com.danco.training.Model.RoomModel;
import com.danco.training.Model.ServiceModel;
import com.danco.training.Storage.Hotel;

// TODO: Auto-generated Javadoc
/**
 * The Class TextParser.
 */
public class TextParser {
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	/** The rooms text. */
	private String roomsText = "number; capasity; numberOfStars; coast; isOnRepair:	";	
	
	/** The guests text. */
	private String guestsText = "id; name; date of settlement; Check-out date:	";
	
	/** The services text. */
	private String servicesText = "name; coast; date:	";
	
	/** The Constant SEMICOLON. */
	private static final String SEMICOLON = " ; "; 
	
	/** The hotel. */
	Hotel hotel = Hotel.getInstance();
	
	/** The tfw. */
	TextFileWorker tfw;
	
	/**
	 * Instantiates a new text parser.
	 *
	 * @param tfw the tfw
	 */
	public TextParser(TextFileWorker tfw){
		this.tfw = tfw;
	}
	
	/**
	 * Write rooms to file.
	 */
	public void writeRoomsToFile(){
		String[] str = new String[10];
		int i = 0;
		for (RoomModel rm : hotel.getRoom().getListOfNumbers()) {
			str[i] = rm.toString();
			i++;
		}
		tfw.writeToFile(str);
	}
	
	/**
	 * Write guests to file.
	 */
	public void writeGuestsToFile(){
		String[] str = new String[10];
		int i = 0;
		for (GuestModel gm : hotel.getGuest().getGuests()) {
			str[i] = gm.toString();
			i++;
		}
		tfw.writeToFile(str);
	}
	
	/**
	 * Write services to file.
	 */
	public void writeServicesToFile(){
		String[] str = new String[10];
		int i = 0;
		for (ServiceModel sm : hotel.getService().getListOfServices()) {
			str[i] = sm.toString();
			i++;
		}
		tfw.writeToFile(str);
	}
	
	/**
	 * Read rooms.
	 *
	 * @return the list
	 */
	public List<RoomModel> readRooms() {
		String[] c = new String[10];
		c = tfw.readFromFile();
		List<RoomModel> list = new ArrayList<RoomModel>();
		String[] e = new String[5];
		for (String b1 : c) {
			if (!b1.equals("null")) {
				e = b1.split(";");
				int number = Integer.parseInt(e[0]);
				int capacity = Integer.parseInt(e[1]);
				int numberOfStars = Integer.parseInt(e[2]);
				int coast = Integer.parseInt(e[3]);
				boolean status = Boolean.parseBoolean(e[4]);
				RoomModel rm = new RoomModel(number, capacity, numberOfStars, coast);
				rm.setStatus(status);
				list.add(rm);
			}
		}
		return list;
	}
	
	/**
	 * Read guests.
	 *
	 * @return the list
	 */
	public List<GuestModel> readGuests() {
		String[] c = new String[10];
		String[] massA = new String[3];
		String[] massE = new String[3];
		c = tfw.readFromFile();
		List<GuestModel> list = new ArrayList<GuestModel>();
		String[] e = new String[4];
		for (String b1 : c) {
			if (!b1.equals("null")) {
				e = b1.split(";");
				int id = Integer.parseInt(e[0]);
				String name = e[1];
				String dateOfAdd = e[2];
				massA = dateOfAdd.split("-");
				String dateOfEvi = e[3];
				massE = dateOfEvi.split("-");
				GuestModel gm = new GuestModel(id, name, new GregorianCalendar(Integer.parseInt(massA[0]),Integer.parseInt(massA[1]), Integer.parseInt(massA[2])), new GregorianCalendar(Integer.parseInt(massE[0]),Integer.parseInt(massE[1]), Integer.parseInt(massE[2])));
				list.add(gm);
			}
		}
		return list;
	}
	
	/**
	 * Read services.
	 *
	 * @return the list
	 * @throws ParseException 
	 */
	public List<ServiceModel> readServices() throws ParseException {
		String[] massL = new String[10];
		String[] mass = new String[3];
		massL = tfw.readFromFile();
		List<ServiceModel> list = new ArrayList<ServiceModel>();
		String[] e = new String[3];
		for (String b1 : massL) {
			if (!b1.equals("null")) {
				e = b1.split(";");
				String name = e[0];
				int coast = Integer.parseInt(e[1]);
				String date = e[2];
				mass = date.split("-");
				ServiceModel sm = new ServiceModel(name, coast,new GregorianCalendar(Integer.parseInt(mass[0]), Integer.parseInt(mass[1]), Integer.parseInt(mass[2])));
				list.add(sm);
			}
		}
		return list;
	}
}
