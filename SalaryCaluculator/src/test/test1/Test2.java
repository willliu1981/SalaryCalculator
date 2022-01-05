package test.test1;

import java.sql.Time;

import com.model.DutyData;

public class Test2 {

	public static void main(String[] args) {
		DutyData d1=new DutyData();
		d1.setStartTime(Time.valueOf("16:30:00"));
		d1.setEndTime(Time.valueOf("21:00:00"));
		
		System.out.println(d1.getStringDiff());
		System.out.println(d1.getDoubleHourDiff());
		

	}

}
