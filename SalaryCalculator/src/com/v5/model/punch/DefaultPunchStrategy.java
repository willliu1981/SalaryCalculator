package com.v5.model.punch;

import java.sql.Timestamp;

//手動輸入
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
