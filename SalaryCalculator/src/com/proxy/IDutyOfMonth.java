package com.proxy;

import java.util.List;

public interface IDutyOfMonth {

	public double getTotalHours() ;
	default public void addAll(List<IDutyOfDay> dutyOfDayProxyList) {
		
	}
}
