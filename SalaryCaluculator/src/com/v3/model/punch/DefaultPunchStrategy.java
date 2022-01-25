package com.v3.model.punch;

import java.sql.Date;
import java.sql.Timestamp;

public class DefaultPunchStrategy implements PunchStrategy {

	@Override
	public Timestamp getDefaultPunchInTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Timestamp getDefaultPunchOutTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Timestamp punchIn(Timestamp time) {
		return this.getDefaultPunchInTime();
	}

	@Override
	public Timestamp punchOut(Timestamp time) {
		return this.getDefaultPunchOutTime();
	}



}
