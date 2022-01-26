package com.v4.model.punch;

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

	public default Timestamp getDefaultPunchIn() {
		return this.setDefaultPunchInTime();
	}

	public default Timestamp getDefaultPunchOut() {
		return this.setDefaultPunchOutTime();
	}

	public default Timestamp punchIn(Timestamp defaultPunchIn) {
		return this.getDefaultPunchIn();
	}

	public default Timestamp punchOut(Timestamp defaultPunchOut) {
		return this.getDefaultPunchOut();
	}
}
