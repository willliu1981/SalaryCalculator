package com.v4.model.punch;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public interface PunchStrategy {

	public default Timestamp now() {
		return Timestamp.valueOf(LocalDateTime.now());
	}

	public Timestamp punchIn(Timestamp defaultPunchIn);

	public Timestamp punchOut(Timestamp defaultPunchOut);
}
