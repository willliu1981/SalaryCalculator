package com.v5.model.punch;

import java.sql.Timestamp;

//以現在時間登記
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
