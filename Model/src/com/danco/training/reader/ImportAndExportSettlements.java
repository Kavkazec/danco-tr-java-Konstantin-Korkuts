package com.danco.training.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.api.IGuestDao;
import com.danco.training.api.IRoomDao;
import com.danco.training.api.IServiceDao;
import com.danco.training.di.DependencyInjection;
import com.danco.training.entity.Settlement;
import com.danco.training.persistexception.PersistenceException;
import com.danco.training.service.SettlementService;

public class ImportAndExportSettlements {
	private static final String SEPAR = " ; ";
	private static final String NEXT_LINE = "\n";
	private static final Logger LOGGER = Logger.getLogger(ImportAndExportServices.class);
	private SettlementService service;
	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
	private IRoomDao rdd = (IRoomDao) DependencyInjection.getInstance().getClassInstance(IRoomDao.class);
	private IGuestDao gdd = (IGuestDao) DependencyInjection.getInstance().getClassInstance(IGuestDao.class);
	private IServiceDao sdd = (IServiceDao) DependencyInjection.getInstance().getClassInstance(IServiceDao.class);

	public SettlementService getService() {
		if (service == null) {
			service = new SettlementService();
		}
		return service;
	}

	public void writeToFileServices(String path) {
		FileWriter fw = null;
		List<Settlement> list = getService().getAll();
		try {
			fw = new FileWriter(path);
			fw.append(Settlement.class.getSimpleName());
			fw.append(NEXT_LINE);
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).getService() == null){
					fw.append(list.get(i).getRoom().getId() + "");
					fw.append(SEPAR);
					fw.append(list.get(i).getGuest().getId() + "");
					fw.append(SEPAR);
					fw.append(list.get(i).getDateOfArrival()+"");
					fw.append(SEPAR);
					fw.append(list.get(i).getDateOfDeparture()+"");
					fw.append(SEPAR);
					fw.append(list.get(i).isPaid()+"");
					fw.append(SEPAR);
					fw.append(NEXT_LINE);
				} else {
					fw.append(list.get(i).getRoom().getId() + "");
					fw.append(SEPAR);
					fw.append(list.get(i).getGuest().getId() + "");
					fw.append(SEPAR);
					fw.append(list.get(i).getService().getId() +"");
					fw.append(SEPAR);
					fw.append(list.get(i).getDateOfArrival()+"");
					fw.append(SEPAR);
					fw.append(list.get(i).getDateOfDeparture()+"");
					fw.append(SEPAR);
					fw.append(list.get(i).getServiceDateOfAdd()+"");
					fw.append(SEPAR);
					fw.append(list.get(i).isPaid()+"");
					fw.append(SEPAR);
					fw.append(NEXT_LINE);
				}
			}
			fw.flush();
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
				;
			}
		}
	}

	public List<Settlement> readFromFileServices(String path, Connection con) {
		List<String> list = new ArrayList<String>();
		List<Settlement> services = new ArrayList<Settlement>();
		String line = "";
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader(path));
			while ((line = bf.readLine()) != null) {
				list.add(line);
			}
			for (int i = 1; i < list.size(); i++) {
				if (Settlement.class.getSimpleName().equals(list.get(0))) {
					String[] arr = list.get(i).split(SEPAR);
					int room_ID = Integer.parseInt(arr[0]);
					int guest_ID = Integer.parseInt(arr[1]);
					int service_ID = Integer.parseInt(arr[2]);
					Date dateArr = SDF.parse(arr[3]);
					Date dateDep = SDF.parse(arr[4]);
					Date servDate = SDF.parse(arr[4]);
					boolean isPaid = Boolean.parseBoolean(arr[5]);
					Settlement sm = new Settlement(rdd.getById(con, room_ID), gdd.getById(con, guest_ID),
							sdd.getById(con, service_ID), dateArr, dateDep, servDate,  isPaid);
					if (!equalID(sm.getRoom().getNumber(), sm.getGuest().getName(), services)) {
						services.add(sm);
					}
				}
			}

		} catch (FileNotFoundException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (ParseException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (PersistenceException e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			try {
				bf.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
		return services;
	}

	public boolean equalID(int roomNumber, String name, List<Settlement> list) {
		boolean b = false;
		for (Settlement model : list) {
			if (model.getRoom().getNumber() == roomNumber && model.getGuest().getName().equals(name)) {
				b = true;
				break;
			}
		}
		return b;
	}
}
