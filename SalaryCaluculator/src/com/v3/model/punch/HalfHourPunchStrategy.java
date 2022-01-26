package com.v3.model.punch;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class HalfHourPunchStrategy implements PunchStrategy {

	Timestamp defaultPunchIn;
	Timestamp defaultPunchOut;

	public HalfHourPunchStrategy(Timestamp defaultPunchIn,
			Timestamp defaultPunchOut) {
		this.defaultPunchIn = defaultPunchIn;
		this.defaultPunchOut = defaultPunchOut;
	}

	@Override
	public Timestamp setDefaultPunchInTime() {
		LocalDateTime local = this.defaultPunchIn.toLocalDateTime();
		int minu = local.getMinute();
		int sec = local.getSecond();
		local = local.minusMinutes(minu);
		local = local.minusSeconds(sec);

		if (minu > 0 && minu <= 30) {
			local = local.plusMinutes(30);
		} else if (minu > 30) {
			local = local.plusHours(1);
		}

		return Timestamp.valueOf(local);
	}

	@Override
	public Timestamp setDefaultPunchOutTime() {
		LocalDateTime local = this.defaultPunchIn.toLocalDateTime();
		int minu = local.getMinute();
		int sec = local.getSecond();
		local = local.minusMinutes(minu);
		local = local.minusSeconds(sec);

		if (minu >= 30) {
			local = local.plusMinutes(30);
		}

		return Timestamp.valueOf(local);
	}

}
