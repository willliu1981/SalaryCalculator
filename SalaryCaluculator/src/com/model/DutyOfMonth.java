package com.model;

import java.util.ArrayList;
import java.util.List;

public class DutyOfMonth {
	private List<DutyOfDay> dayDutys = new ArrayList<>();

	public void add(DutyOfDay dayDuty) {
		this.dayDutys.add(dayDuty);
	}

	public void remove(DutyOfDay dayDuty) {
		this.dayDutys.remove(dayDuty);
	}

	public double getTotalHours() {
		double totalHours = this.dayDutys.stream()
				.mapToDouble(x -> Double.valueOf(x.getTotalHours()))
				.reduce((total, diff) -> total + diff).getAsDouble();
		return totalHours;
	}
	
	

}
