package com.v5.model.punch.tool;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;

import com.v5.model.punch.Punch;

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

	public static double getDiffOfHour(Punch punch) {
		long diff = getDiffOfMinute(punch);

		return diff / 60.0;
	}

	public static long getDiffOfMinute(Punch punch) {
		LocalDateTime in = punch.getPunchIn().toLocalDateTime();
		LocalDateTime out = punch.getPunchOut().toLocalDateTime();

		return Duration.between(in, out).toMinutes();
	}
}
