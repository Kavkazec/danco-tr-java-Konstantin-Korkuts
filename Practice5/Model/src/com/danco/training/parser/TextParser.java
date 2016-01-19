package com.danco.training.parser;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


import com.danco.training.TextFileWorker;
import com.danco.training.model.GuestModel;
import com.danco.training.model.RoomModel;
import com.danco.training.model.ServiceModel;

// TODO: Auto-generated Javadoc
/**
 * The Class TextParser.
 */
public class TextParser {
	
	/** The sdf. */
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	/** The Constant SEMICOLON. */
	private static final String SEMICOLON = " ; ";
	
	/** The tfw. */
	private TextFileWorker tfw;
	
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
	 *
	 * @param list the list
	 */
	
	
	public void writeToFile(List<?> list){
		String[] str = new String[list.size()];
		int j = 0;
		for(int i = 0; i < list.size(); i++){
			str[j] = list.get(i).toString();
			j++;
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
			if (!("null").equals(b1)) {
				e = b1.split(SEMICOLON);
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
	 * @throws ParseException the parse exception
	 */
	public List<GuestModel> readGuests() throws ParseException {
		String[] c = new String[10];
		c = tfw.readFromFile();
		List<GuestModel> list = new ArrayList<GuestModel>();
		String[] e = new String[4];
		for (String b1 : c) {
			if (!("null").equals(b1)) {
				e = b1.split(SEMICOLON);
				String name = e[0];
				Date dateOfAdd = sdf.parse(e[1]);
				Date dateOfEvi = sdf.parse(e[2]);
				GuestModel gm = new GuestModel(name, new GregorianCalendar(), new GregorianCalendar());
				gm.setDateAdd(dateOfAdd);
				gm.setDateEvi(dateOfEvi);
				list.add(gm);
			}
		}
		return list;
	}
	
	/**
	 * Read services.
	 *
	 * @return the list
	 * @throws ParseException the parse exception
	 */
	public List<ServiceModel> readServices() throws ParseException {
		String[] massL = new String[10];
		massL = tfw.readFromFile();
		List<ServiceModel> list = new ArrayList<ServiceModel>();
		String[] e = new String[3];
		for (String b1 : massL) {
			if (!("null").equals(b1)) {
				e = b1.split(SEMICOLON);
				String name = e[0];
				int coast = Integer.parseInt(e[1]);
				ServiceModel sm = new ServiceModel(name, coast);
				list.add(sm);
			}
		}
		return list;
	}
}
