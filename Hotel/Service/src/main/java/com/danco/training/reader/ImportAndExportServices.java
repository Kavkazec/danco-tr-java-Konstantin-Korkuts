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

import com.danco.training.api.IServiceDao;
import com.danco.training.api.ISettlementDao;
import com.danco.training.di.DependencyInjection;
import com.danco.training.entity.Service;
import com.danco.training.entity.Settlement;
import com.danco.training.persisexception.PersistenceException;
import com.danco.training.service.ServiceService;

public class ImportAndExportServices {
	private static final String SEPAR = " ; ";
	private static final String NEXT_LINE = "\n";
	private static final Logger LOGGER = Logger.getLogger(ImportAndExportServices.class);
	private IServiceDao dao = (IServiceDao) DependencyInjection.getInstance().getClassInstance(IServiceDao.class);
	private ISettlementDao daoSett = (ISettlementDao) DependencyInjection.getInstance().getClassInstance(ISettlementDao.class);

	public void writeToFileServices(Session session, String path) throws PersistenceException {
		FileWriter fw = null;
		List<Service> list = dao.getAll(session);
		try {
			fw = new FileWriter(path);
			fw.append(Service.class.getSimpleName());
			fw.append(NEXT_LINE);
			for (int i = 0; i < list.size(); i++) {
				fw.append(list.get(i).getId() + "");
				fw.append(SEPAR);
				fw.append(list.get(i).getName());
				fw.append(SEPAR);
				fw.append(list.get(i).getCoast() + "");
				fw.append(SEPAR);
				fw.append(list.get(i).getType());
				fw.append(SEPAR);
				fw.append(list.get(i).getSettlement().getId() + "");
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

	public List<Service> readFromFileServices(Session session, String path) throws NumberFormatException, PersistenceException {
		List<String> list = new ArrayList<String>();
		List<Service> services = new ArrayList<Service>();
		String line = "";
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader(path));
			while ((line = bf.readLine()) != null) {
				list.add(line);
			}
			for (int i = 1; i < list.size(); i++) {
				if (Service.class.getSimpleName().equals(list.get(0))) {
					String[] arr = list.get(i).split(SEPAR);
					int id = Integer.parseInt(arr[0]);
					String name = arr[1];
					int coast = Integer.parseInt(arr[2]);
					String type = arr[3];
					Settlement settlement = daoSett.getById(session, Integer.parseInt(arr[4]));
					Service sm = new Service(id, name, coast);
					sm.setType(type);
					sm.setSettlement(settlement);
					if(!services.contains(sm)){
						services.add(sm);
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
		return services;
	}
}
