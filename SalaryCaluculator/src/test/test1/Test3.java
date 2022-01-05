package test.test1;

import java.sql.Date;
import java.sql.Time;

import com.model.DutyData;
import com.model.DutyOfDay;
import com.model.DutyOfMonth;

public class Test3 {

	public static void main(String[] args) {
		DutyOfMonth monthDuty = new DutyOfMonth();

		DutyOfDay dayDuty1 = new DutyOfDay(Date.valueOf("2021-12-3"));
		DutyOfDay dayDuty2 = new DutyOfDay(Date.valueOf("2021-12-4"));
		DutyOfDay dayDuty3 = new DutyOfDay(Date.valueOf("2021-12-5"));
		DutyOfDay dayDuty4 = new DutyOfDay(Date.valueOf("2021-12-8"));
		DutyOfDay dayDuty5 = new DutyOfDay(Date.valueOf("2021-12-9"));
		DutyOfDay dayDuty6 = new DutyOfDay(Date.valueOf("2021-12-11"));
		DutyOfDay dayDuty7 = new DutyOfDay(Date.valueOf("2021-12-12"));
		DutyOfDay dayDuty8 = new DutyOfDay(Date.valueOf("2021-12-14"));
		DutyOfDay dayDuty9 = new DutyOfDay(Date.valueOf("2021-12-15"));
		DutyOfDay dayDuty10 = new DutyOfDay(Date.valueOf("2021-12-16"));
		DutyOfDay dayDuty11 = new DutyOfDay(Date.valueOf("2021-12-17"));
		DutyOfDay dayDuty12 = new DutyOfDay(Date.valueOf("2021-12-18"));
		DutyOfDay dayDuty13 = new DutyOfDay(Date.valueOf("2021-12-19"));
		DutyOfDay dayDuty14 = new DutyOfDay(Date.valueOf("2021-12-21"));
		DutyOfDay dayDuty15 = new DutyOfDay(Date.valueOf("2021-12-25"));
		DutyOfDay dayDuty16 = new DutyOfDay(Date.valueOf("2021-12-26"));
		DutyOfDay dayDuty17 = new DutyOfDay(Date.valueOf("2021-12-31"));

		DutyData dutyDataType1 = new DutyData();
		dutyDataType1.setStartTime(Time.valueOf("18:30:00"));
		dutyDataType1.setEndTime(Time.valueOf("21:00:00"));

		DutyData dutyDataType_1000 = new DutyData();
		dutyDataType_1000.setStartTime(Time.valueOf("10:00:00"));
		dutyDataType_1000.setEndTime(Time.valueOf("14:00:00"));
		
		DutyData dutyDataType_1030 = new DutyData();
		dutyDataType_1030.setStartTime(Time.valueOf("10:30:00"));
		dutyDataType_1030.setEndTime(Time.valueOf("14:00:00"));

		DutyData dutyDataType_1100 = new DutyData();
		dutyDataType_1100.setStartTime(Time.valueOf("11:00:00"));
		dutyDataType_1100.setEndTime(Time.valueOf("14:00:00"));

		DutyData dutyDataType_1600 = new DutyData();
		dutyDataType_1600.setStartTime(Time.valueOf("16:00:00"));
		dutyDataType_1600.setEndTime(Time.valueOf("21:00:00"));

		DutyData dutyDataType_1630 = new DutyData();
		dutyDataType_1630.setStartTime(Time.valueOf("16:30:00"));
		dutyDataType_1630.setEndTime(Time.valueOf("21:00:00"));


	}

}
