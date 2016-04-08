package com.danco.training.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.danco.training.api.IGuestDao;
import com.danco.training.api.IRoomDao;
import com.danco.training.api.IServiceDao;
import com.danco.training.api.ISettlementDao;
import com.danco.training.di.DependencyInjection;
import com.danco.training.entity.Service;
import com.danco.training.entity.Settlement;
import com.danco.training.persisexception.PersistenceException;
import com.danco.training.service.SettlementService;

public class ImportAndExportSettlements {
	private static final String SEPAR = " ; ";
	private static final String NEXT_LINE = "\n";
	private static final Logger LOGGER = Logger.getLogger(ImportAndExportServices.class);
	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
	private IRoomDao rdd = (IRoomDao) DependencyInjection.getInstance().getClassInstance(IRoomDao.class);
	private IGuestDao gdd = (IGuestDao) DependencyInjection.getInstance().getClassInstance(IGuestDao.class);
	private IServiceDao sdd = (IServiceDao) DependencyInjection.getInstance().getClassInstance(IServiceDao.class);
	private ISettlementDao dao = (ISettlementDao) DependencyInjection.getInstance().getClassInstance(ISettlementDao.class);

	public void writeToFileServices(Session session, String path) throws PersistenceException {
		FileWriter fw = null;
		List<Settlement> list = dao.getAll(session);
		try {
			fw = new FileWriter(path);
			fw.append(Settlement.class.getSimpleName());
			fw.append(NEXT_LINE);
			for (int i = 0; i < list.size(); i++) {
				fw.append(list.get(i).getId() + "");
				fw.append(SEPAR);
				fw.append(list.get(i).getRoom().getId() + "");
				fw.append(SEPAR);
				fw.append(list.get(i).getGuest().getId() + "");
				fw.append(SEPAR);
				for (Service service : list.get(i).getServiceList()) {
					fw.append(service.getId() + "");
					fw.append(SEPAR);
				}
				fw.append(list.get(i).getDateOfArrival()+"");
				fw.append(SEPAR);
				fw.append(list.get(i).getDateOfDeparture()+"");
				fw.append(SEPAR);
				fw.append(list.get(i).isPaid()+"");
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
				;
			}
		}
	}

	public List<Settlement> readFromFileServices(String path, Session session) {
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
					int id = Integer.parseInt(arr[0]);
					int room_ID = Integer.parseInt(arr[1]);
					int guest_ID = Integer.parseInt(arr[2]);
					Date dateArr = SDF.parse(arr[3]);
					Date dateDep = SDF.parse(arr[4]);
					boolean isPaid = Boolean.parseBoolean(arr[5]);
					Settlement sm = new Settlement(id, rdd.getById(session, room_ID), gdd.getById(session, guest_ID),
							null, dateArr, dateDep, isPaid);
					if (!services.contains(sm)) {
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
}
