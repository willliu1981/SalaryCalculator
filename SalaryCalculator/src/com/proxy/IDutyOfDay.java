package com.proxy;

import com.model.DutyOfDay;

public interface IDutyOfDay {
	public double getTotalHours() ;
	
	default public DutyOfDay getRealDutyOfDay() {
		return null;
	}
}
