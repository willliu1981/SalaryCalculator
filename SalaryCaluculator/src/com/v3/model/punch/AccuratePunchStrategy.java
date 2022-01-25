package com.v3.model.punch;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class AccuratePunchStrategy implements PunchStrategy {

	@Override
	public Timestamp setDefaultPunchInTime() {
		return this.now();
	}

	@Override
	public Timestamp setDefaultPunchOutTime() {
		return this.now();
	}

}
