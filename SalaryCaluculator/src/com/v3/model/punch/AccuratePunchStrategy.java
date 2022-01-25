package com.v3.model.punch;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class AccuratePunchStrategy implements PunchStrategy {

	@Override
	public Timestamp getDefaultPunchInTime() {
		return this.getNow();
	}

	@Override
	public Timestamp getDefaultPunchOutTime() {
		return this.getNow();
	}

	@Override
	public Timestamp punchIn(Timestamp time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Timestamp punchOut(Timestamp time) {
		return null;
	}

	private Timestamp getNow() {
		java.util.Date date = new java.util.Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = format.format(date);
		return Timestamp.valueOf(dateStr);
	}

}
