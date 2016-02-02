package com.danco.training.properties;

public class PropertiesUtil {
	private boolean switchOff = false;
	private int recordNumber = 0;
	private String path = null;
	private String csvPath = null;
	private String annotPath = null;
	private String servName = null;

	public String getServName() {
		return servName;
	}

	public void setServName(String servName) {
		this.servName = servName;
	}

	public String getAnnotPath() {
		return annotPath;
	}

	public void setAnnotPath(String annotPath) {
		this.annotPath = annotPath;
	}

	public String getCsvPath() {
		return csvPath;
	}

	public void setCsvPath(String csvPath) {
		this.csvPath = csvPath;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isSwitchOff() {
		return switchOff;
	}

	public void setSwitchOff(boolean switcOff) {

		this.switchOff = switcOff;

	}

	public int getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(int recordNumber) {

		this.recordNumber = recordNumber;

	}

}
