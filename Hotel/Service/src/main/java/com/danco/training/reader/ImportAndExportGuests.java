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

import com.danco.training.api.IGuestDao;
import com.danco.training.api.ISettlementDao;
import com.danco.training.di.DependencyInjection;
import com.danco.training.entity.Guest;
import com.danco.training.entity.Settlement;
import com.danco.training.persisexception.PersistenceException;
import com.danco.training.service.GuestService;
import com.danco.training.service.SettlementService;

public class ImportAndExportGuests {

	private static final String SEPAR = " ; ";
	private static final String NEXT_LINE = "\n";
	private static final Logger LOGGER = Logger.getLogger(ImportAndExportGuests.class);
	private IGuestDao dao = (IGuestDao) DependencyInjection.getInstance().getClassInstance(IGuestDao.class);
	private ISettlementDao daoSett = (ISettlementDao) DependencyInjection.getInstance().getClassInstance(ISettlementDao.class);

	public void writeToFileGuests(Session session, String path) throws PersistenceException {
		FileWriter fw = null;
		List<Guest> list = dao.getAll(session);
		try {
			fw = new FileWriter(path);
			fw.append(Guest.class.getSimpleName());
			fw.append(NEXT_LINE);
			for (int i = 0; i < list.size(); i++) {
				fw.append(list.get(i).getId() + "");
				fw.append(SEPAR);
				fw.append(list.get(i).getName());
				fw.append(SEPAR);
				fw.append(list.get(i).getPassportSeries());
				fw.append(SEPAR);
				fw.append(list.get(i).getPassportNumber() + "");
				fw.append(SEPAR);
				for (Settlement settlement : list.get(i).getSettlementList()) {
					fw.append(settlement.getId() + "");
					fw.append(SEPAR);
				}
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

	public List<Guest> readFromFileGuests(Session session, String path) {
		List<String> list = new ArrayList<String>();
		List<Guest> guests = new ArrayList<Guest>();
		String line = "";
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader(path));
			while ((line = bf.readLine()) != null) {
				list.add(line);
			}
			for (int i = 1; i < list.size(); i++) {
				if (Guest.class.getSimpleName().equals(list.get(0))) {
					String[] arr = list.get(i).split(SEPAR);
					int id = Integer.parseInt(arr[0]);
					String name = arr[1];
					String passSer = arr[2];
					int passNum = Integer.parseInt(arr[3]);
					List<Settlement> settlement = new ArrayList<Settlement>();
					settlement.add(daoSett.getById(session, Integer.parseInt(arr[4])));
					Guest gm = new Guest(id, name, passSer, passNum);
					gm.setSettlementList(settlement);
					if(!guests.contains(gm)){
						guests.add(gm);
					}
				}
			}
		} catch (FileNotFoundException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (NumberFormatException e) {
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
		return guests;

	}
}
