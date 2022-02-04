package com.v5.model.punch.tool;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Punches {

	public static boolean isAfter(Timestamp t1, Timestamp t2) {
		LocalDateTime l1 = t1.toLocalDateTime();
		LocalDateTime l2 = t2.toLocalDateTime();

		return l1.isAfter(l2);
	}

	public static boolean isBefore(Timestamp t1, Timestamp t2) {
		LocalDateTime l1 = t1.toLocalDateTime();
		LocalDateTime l2 = t2.toLocalDateTime();

		return l1.isBefore(l2);
	}
}
