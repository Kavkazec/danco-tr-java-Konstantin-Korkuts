package com.danco.training.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import com.danco.training.api.IHotelController;
import com.danco.training.daoimpl.GuestDatabaseDao;
import com.danco.training.daoimpl.ServiceDatabaseDao;
import com.danco.training.daoimpl.SettlementDatabaseDao;
import com.danco.training.dbconnection.ConnectionProvider;
import com.danco.training.di.DependencyInjection;
import com.danco.training.entity.Guest;
import com.danco.training.entity.Room;
import com.danco.training.entity.Service;
import com.danco.training.entity.Settlement;
import com.danco.training.persistexception.PersistenceException;
import com.danco.training.reader.ImportAndExportSettlements;
import com.danco.training.service.RoomService;
import com.danco.training.service.SettlementService;

public class Test {
	public static void main(String[] args) throws PersistenceException, ParseException {
	}
}
