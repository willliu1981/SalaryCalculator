package com.proxy;

import com.model.DutyOfDay;

public class DutyOfDayProxy implements IDutyOfDay {
	private DutyOfDay dayDuty;

	public DutyOfDayProxy(DutyOfDay dayDuty) {
		this.dayDuty = dayDuty;
	}
	
	public DutyOfDay getRealDutyOfDay() {
		return this.dayDuty;
	}

	@Override
	public double getTotalHours() {
		double total = dayDuty.getTotalHours();
		System.out.println(dayDuty.getDate() + " : " + total);
		return total;
	}

}
