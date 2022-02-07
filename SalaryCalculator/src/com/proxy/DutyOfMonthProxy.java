package com.proxy;

import java.util.List;

import com.model.DutyOfMonth;

public class DutyOfMonthProxy implements IDutyOfMonth {
	private DutyOfMonth monthDuty;
	private List<IDutyOfDay> dutyOfDayProxyList;

	public DutyOfMonthProxy(DutyOfMonth monthDuty) {
		this.monthDuty = monthDuty;
	}

	public void addAll(List<IDutyOfDay> dutyOfDayProxyList) {
		this.dutyOfDayProxyList = dutyOfDayProxyList;
		dutyOfDayProxyList.forEach(x -> monthDuty.add(x.getRealDutyOfDay()));
	}

	@Override
	public double getTotalHours() {
		double totalHours = dutyOfDayProxyList.stream()
				.mapToDouble(x -> Double.valueOf(x.getTotalHours()))
				.reduce((total, diff) -> total + diff).getAsDouble();
		System.out.println("size: " + monthDuty.getSize());
		return totalHours;
	}

}
