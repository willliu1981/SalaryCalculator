package com.v3.model.punch;

import java.sql.Date;
import java.sql.Timestamp;

public interface PunchStrategy {
	public Timestamp getDefaultPunchInTime();

	public Timestamp getDefaultPunchOutTime();

	public default void defaultPunchIn() {
		this.punchIn(getDefaultPunchInTime());
	}

	public default void defaultPunchOut() {
		this.punchIn(getDefaultPunchOutTime());
	}

	public Timestamp punchIn(Timestamp time);

	public Timestamp punchOut(Timestamp time);
}
