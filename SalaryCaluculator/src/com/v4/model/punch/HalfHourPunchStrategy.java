package com.v4.model.punch;

import java.sql.Timestamp;
import java.time.LocalDateTime;

//手動輸入,並以半小時為一個區間計算
public class HalfHourPunchStrategy implements PunchStrategy {

	@Override
	public Timestamp punchIn(Timestamp defaultPunchIn) {
		LocalDateTime local = defaultPunchIn.toLocalDateTime();
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
	public Timestamp punchOut(Timestamp defaultPunchOut) {
		LocalDateTime local = defaultPunchOut.toLocalDateTime();
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
