package com.v4.model.punch;

import java.sql.Date;
import java.sql.Timestamp;

public class DefaultPunchStrategy implements PunchStrategy {
	Timestamp defaultPunchIn;
	Timestamp defaultPunchOut;

	public DefaultPunchStrategy(Timestamp defaultPunchIn,
			Timestamp defaultPunchOut) {
		this.defaultPunchIn = defaultPunchIn;
		this.defaultPunchOut = defaultPunchOut;
	}

	@Override
	public Timestamp setDefaultPunchInTime() {
		return this.defaultPunchIn;
	}

	@Override
	public Timestamp setDefaultPunchOutTime() {
		return this.defaultPunchOut;
	}

}
