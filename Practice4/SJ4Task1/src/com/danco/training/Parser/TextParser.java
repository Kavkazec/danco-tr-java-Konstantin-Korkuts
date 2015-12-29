package com.danco.training.Parser;


import java.util.ArrayList;

import com.danco.training.TextFileWorker;
import com.danco.training.Model.RoomModel;
import com.danco.training.Storage.Hotel;

public class TextParser {
	Hotel hotel = Hotel.getInstance();
	TextFileWorker tfw;
	public TextParser(TextFileWorker tfw){
		this.tfw = tfw;
	}
	public void writeRoomsToFile(){
		String[] str = new String[10];
		int i = 0;
		for (RoomModel rm : Hotel.getInstance().getRoom().getListOfNumbers()) {
			str[i] = rm.toString();
			i++;
		}
		tfw.writeToFile(str);
	}
	public ArrayList<String> readRooms() {
		String[] c = new String[10];
		c = tfw.readFromFile();
		ArrayList<String> list = new ArrayList<String>();
		String[] e = new String[5];
		for (String b1 : c) {
			if (b1.equals("null")) {
			} else {
				e = b1.split(";");
				String number = e[0];
				String capasity = e[1];
				String numberOfStars = e[2];
				String coast = e[3];
				String status = e[4];
				StringBuilder sb = new StringBuilder();
				sb.append(number);
				sb.append(";");
				sb.append(capasity);
				sb.append(";");
				sb.append(numberOfStars);
				sb.append(";");
				sb.append(coast);
				sb.append(";");
				sb.append(status);
				sb.append(";");
				System.out.println(sb.toString());
			}
		}
		return list;
	}
}
