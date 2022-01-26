package com.v4.model.punch;

import java.sql.Date;
import java.sql.Timestamp;

public class DefaultPunchStrategy implements PunchStrategy {

	@Override
	public Timestamp punchIn(Timestamp defaultPunchIn) {
		return defaultPunchIn;
	}

	@Override
	public Timestamp punchOut(Timestamp defaultPunchOut) {
		return defaultPunchOut;
	}

}
