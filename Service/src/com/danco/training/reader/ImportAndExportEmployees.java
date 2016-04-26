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

import com.danco.point.entity.Employee;
import com.danco.point.service.EmployeeService;

public class ImportAndExportEmployees {
	private static final String SEPAR = ", ";
	private static final String NEXT_LINE = "\n";
	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy.DD.mm");
	private EmployeeService employee;

	public EmployeeService getEmployee() {
		if (employee == null) {
			employee = new EmployeeService();
		}
		return employee;
	}

	public void writeToFileEmployees(String path) {
		FileWriter fw = null;
		List<Employee> list = getEmployee().getEmployees();
		try {
			fw = new FileWriter(path);
			for (Employee empl : list) {
				fw.append(empl.getFirstName());
				fw.append(SEPAR);
				fw.append(empl.getLastName());
				fw.append(SEPAR);
				fw.append(empl.getbDate() + "");
				fw.append(SEPAR);
				fw.append(empl.getGender());
				fw.append(SEPAR);
				fw.append(empl.getTittle());
				fw.append(SEPAR);
				fw.append(NEXT_LINE);
			}
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Employee> readFromFileRooms(String path) {
		List<String> list = new ArrayList<String>();
		List<Employee> employees = new ArrayList<Employee>();
		String line = "";
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader(path));
			while ((line = bf.readLine()) != null) {
				list.add(line);
			}
			for (int i = 1; i < list.size(); i++) {
					String[] arr = list.get(i).split(SEPAR);
					String fName = arr[0];
					String lName = arr[1];
					Date date = SDF.parse(arr[2]);
					String gender = arr[3];
					String tittle = arr[4];
					Employee employee = new Employee(fName, lName, date, gender, tittle);
					employees.add(employee);
				}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			try {
				bf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return employees;
	}
}
