package com.danco.training.properties;

public class PropertiesUtil {
	private boolean switchOff = false;
	private int recordNumber = 0;

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
