package com.model;

import java.sql.Time;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class DutyData {
	private Time startTime;// 值班時間-開始
	private Time endTime;// 值班時間-開始
	private LocalTime diffTime;// 值班時間-分鐘

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
		doDiff();
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
		doDiff();
	}

	private void doDiff() {
		if (startTime != null && endTime != null) {
			LocalTime local1 = startTime.toLocalTime();
			LocalTime local2 = endTime.toLocalTime();

			if (local2.isAfter(local1)) {
				this.diffTime = LocalTime.ofSecondOfDay(
						local1.until(local2, ChronoUnit.SECONDS));
			} else {
				this.diffTime = null;
			}
		}
	}

	public String getStringDiff() {
		if (this.diffTime == null) {
			return "資料不完整";
		}

		return this.diffTime.toString();
	}

	public double getDoubleHourDiff() {
		if (this.diffTime == null) {
			throw new RuntimeException("資料不完整");
		}

		int minuteDiff = this.diffTime.get(ChronoField.MINUTE_OF_DAY);
		double hourDiff = minuteDiff / 60.0;
		return hourDiff;
	}

}
