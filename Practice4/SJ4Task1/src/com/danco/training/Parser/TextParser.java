package com.danco.training.Parser;


import java.util.ArrayList;
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
	public List<String> readRooms() {
		String[] c = new String[10];
		c = tfw.readFromFile();
		List<String> list = new ArrayList<String>();
		String[] e = new String[5];
		for (String b1 : c) {
			if (!b1.equals("null")) {
				e = b1.split(";");
				String number = e[0];
				String capasity = e[1];
				String numberOfStars = e[2];
				String coast = e[3];
				String status = e[4];
				StringBuilder sb = new StringBuilder();
				sb.append(roomsText);
				sb.append(number+SEMICOLON);
				sb.append(capasity+SEMICOLON);
				sb.append(numberOfStars+SEMICOLON);
				sb.append(coast+SEMICOLON);
				sb.append(status+SEMICOLON);
				System.out.println(sb.toString());
			}
		}
		return list;
	}
	
	/**
	 * Read guests.
	 *
	 * @return the list
	 */
	public List<String> readGuests() {
		String[] c = new String[10];
		c = tfw.readFromFile();
		List<String> list = new ArrayList<String>();
		String[] e = new String[4];
		for (String b1 : c) {
			if (!b1.equals("null")) {
				e = b1.split(";");
				String id = e[0];
				String name = e[1];
				String dateOfAdd = e[2];
				String dateOfEvi = e[3];
				StringBuilder sb = new StringBuilder();
				sb.append(guestsText);
				sb.append(id+SEMICOLON);
				sb.append(name+SEMICOLON);
				sb.append(dateOfAdd+SEMICOLON);
				sb.append(dateOfEvi+SEMICOLON);
				System.out.println(sb.toString());
			}
		}
		return list;
	}
	
	/**
	 * Read services.
	 *
	 * @return the list
	 */
	public List<String> readServices() {
		String[] c = new String[10];
		c = tfw.readFromFile();
		List<String> list = new ArrayList<String>();
		String[] e = new String[3];
		for (String b1 : c) {
			if (!b1.equals("null")) {
				e = b1.split(";");
				String name = e[0];
				String coast = e[1];
				String date = e[2];
				StringBuilder sb = new StringBuilder();
				sb.append(servicesText);
				sb.append(name+SEMICOLON);
				sb.append(coast+SEMICOLON);
				sb.append(date+SEMICOLON);
				System.out.println(sb.toString());
			}
		}
		return list;
	}
}
