package com.v4.model.punch;

import java.sql.Timestamp;

public class AccuratePunchStrategy implements PunchStrategy {

	@Override
	public Timestamp punchIn(Timestamp defaultPunchIn) {
		return this.now();
	}

	@Override
	public Timestamp punchOut(Timestamp defaultPunchOut) {
		return this.now();
	}

}
