package test.test1;

import java.sql.Date;
import java.sql.Time;

import com.model.DutyData;
import com.model.DutyOfDay;
import com.model.DutyOfMonth;

public class Test3 {

	public static void main(String[] args) {
		DutyOfMonth monthDuty = new DutyOfMonth();
		
		DutyData dutyDataType_1830 = new DutyData();
		dutyDataType_1830.setStartTime(Time.valueOf("18:30:00"));
		dutyDataType_1830.setEndTime(Time.valueOf("21:00:00"));

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

		
		DutyOfDay dayDuty1 = new DutyOfDay(Date.valueOf("2021-12-3"));
		dayDuty1.add(dutyDataType_1100);
		dayDuty1.add(dutyDataType_1600);
		
		DutyOfDay dayDuty2 = new DutyOfDay(Date.valueOf("2021-12-4"));
		dayDuty2.add(dutyDataType_1100);
		dayDuty2.add(dutyDataType_1630);
		
		DutyOfDay dayDuty3 = new DutyOfDay(Date.valueOf("2021-12-5"));
		dayDuty3.add(dutyDataType_1100);
		dayDuty3.add(dutyDataType_1630);
		
		DutyOfDay dayDuty4 = new DutyOfDay(Date.valueOf("2021-12-8"));
		dayDuty4.add(dutyDataType_1830);
		
		DutyOfDay dayDuty5 = new DutyOfDay(Date.valueOf("2021-12-9"));
		dayDuty5.add(dutyDataType_1100);
		dayDuty5.add(dutyDataType_1630);
		
		DutyOfDay dayDuty6 = new DutyOfDay(Date.valueOf("2021-12-11"));
		dayDuty6.add(dutyDataType_1100);
		dayDuty6.add(dutyDataType_1630);
		
		DutyOfDay dayDuty7 = new DutyOfDay(Date.valueOf("2021-12-12"));
		dayDuty7.add(dutyDataType_1100);
		dayDuty7.add(dutyDataType_1630);
		
		DutyOfDay dayDuty8 = new DutyOfDay(Date.valueOf("2021-12-14"));
		dayDuty8.add(dutyDataType_1030);
		dayDuty8.add(dutyDataType_1600);
		
		DutyOfDay dayDuty9 = new DutyOfDay(Date.valueOf("2021-12-15"));
		dayDuty9.add(dutyDataType_1030);
		dayDuty9.add(dutyDataType_1600);
		
		DutyOfDay dayDuty10 = new DutyOfDay(Date.valueOf("2021-12-16"));
		dayDuty10.add(dutyDataType_1030);
		dayDuty10.add(dutyDataType_1600);
		
		DutyOfDay dayDuty11 = new DutyOfDay(Date.valueOf("2021-12-17"));
		dayDuty11.add(dutyDataType_1030);
		dayDuty11.add(dutyDataType_1600);
		
		DutyOfDay dayDuty12 = new DutyOfDay(Date.valueOf("2021-12-18"));
		dayDuty12.add(dutyDataType_1030);
		dayDuty12.add(dutyDataType_1630);
		
		DutyOfDay dayDuty13 = new DutyOfDay(Date.valueOf("2021-12-19"));
		dayDuty13.add(dutyDataType_1030);
		dayDuty13.add(dutyDataType_1600);
		
		DutyOfDay dayDuty14 = new DutyOfDay(Date.valueOf("2021-12-21"));
		dayDuty14.add(dutyDataType_1030);
		dayDuty14.add(dutyDataType_1600);
		
		DutyOfDay dayDuty15 = new DutyOfDay(Date.valueOf("2021-12-25"));
		dayDuty15.add(dutyDataType_1100);
		dayDuty15.add(dutyDataType_1630);
		
		DutyOfDay dayDuty16 = new DutyOfDay(Date.valueOf("2021-12-26"));
		dayDuty16.add(dutyDataType_1100);
		dayDuty16.add(dutyDataType_1630);
		
		DutyOfDay dayDuty17 = new DutyOfDay(Date.valueOf("2021-12-31"));
		dayDuty17.add(dutyDataType_1100);
		dayDuty17.add(dutyDataType_1630);

		monthDuty.add(dayDuty1);
		monthDuty.add(dayDuty2);
		monthDuty.add(dayDuty3);
		monthDuty.add(dayDuty4);
		monthDuty.add(dayDuty5);
		monthDuty.add(dayDuty6);
		monthDuty.add(dayDuty7);
		monthDuty.add(dayDuty8);
		monthDuty.add(dayDuty9);
		monthDuty.add(dayDuty10);
		monthDuty.add(dayDuty11);
		monthDuty.add(dayDuty12);
		monthDuty.add(dayDuty13);
		monthDuty.add(dayDuty14);
		monthDuty.add(dayDuty15);
		monthDuty.add(dayDuty16);
		monthDuty.add(dayDuty17);
		
		System.out.println("total size: "+monthDuty.getSize());
		System.out.println("total hours: "+monthDuty.getTotalHours());
		


	}

}
