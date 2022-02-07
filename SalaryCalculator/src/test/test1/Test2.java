package test.test1;

import java.sql.Date;
import java.sql.Time;

import com.model.DutyData;
import com.model.DutyOfDay;
import com.model.DutyOfMonth;

public class Test2 {

	public static void main(String[] args) {
		DutyData d1=new DutyData();
		d1.setStartTime(Time.valueOf("10:30:00"));
		d1.setEndTime(Time.valueOf("14:00:00"));
		
		DutyData d2=new DutyData();
		d2.setStartTime(Time.valueOf("16:30:00"));
		d2.setEndTime(Time.valueOf("21:00:00"));
		
		DutyData d3=new DutyData();
		d3.setStartTime(Time.valueOf("22:30:00"));
		d3.setEndTime(Time.valueOf("23:30:00"));

		
		System.out.println(d1.getStringDiff());
		System.out.println(d1.getDoubleHourDiff());
		
		System.out.println(d2.getStringDiff());
		System.out.println(d2.getDoubleHourDiff());
		
		
		DutyOfDay dayDuty=new DutyOfDay(Date.valueOf("2021-12-3"));
		dayDuty.add(d1);
		dayDuty.add(d2);
	
		
		DutyOfDay dayDuty2=new DutyOfDay(Date.valueOf("2021-12-6"));
		dayDuty2.add(d1);
		dayDuty2.add(d2);
		dayDuty2.add(d3);
		
		System.out.println(dayDuty.getDayOfDate());
		System.out.println(dayDuty2.getDate());
		
		System.out.println(dayDuty.getTotalHours());
		System.out.println(dayDuty2.getTotalHours());
		
		DutyOfMonth monthDuty=new DutyOfMonth();
		monthDuty.add(dayDuty);
		monthDuty.add(dayDuty2);

		System.out.println(monthDuty.getTotalHours());
		
		
		

	}

}
