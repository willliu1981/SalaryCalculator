package com.v3.model.punch;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public interface PunchStrategy {
	public Timestamp setDefaultPunchInTime();

	public Timestamp setDefaultPunchOutTime();

	public default Timestamp now() {
		return Timestamp.valueOf(LocalDateTime.now());
	}

	public default Timestamp dateTimeToTimestamp(java.util.Date date) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = format.format(date);
		return Timestamp.valueOf(dateStr);
	}

	public default Timestamp getDefaultPunchIn() {
		return this.setDefaultPunchInTime();
	}

	public default Timestamp getDefaultPunchOut() {
		return this.setDefaultPunchOutTime();
	}

	public default Timestamp punchIn() {
		return this.getDefaultPunchIn();
	}

	public default Timestamp punchOut() {
		return this.getDefaultPunchOut();
	}
}
