package test.test1;

import java.sql.Time;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import javax.swing.JFrame;

public class Test extends JFrame {
	String name;

	public Test() {
	}

	public static void main(String[] args) {

		Time time = Time.valueOf("16:30:00");
		Time time2 = Time.valueOf("21:00:00");
		
		LocalTime lT1=time.toLocalTime();
		LocalTime lT2=time2.toLocalTime();

		long diff =lT1.until(lT2, ChronoUnit.SECONDS);
		
		LocalTime duration=LocalTime.ofSecondOfDay(diff);
		duration.getHour();

		System.out.println("test :" + time);
		System.out.println("test :" + time2);
		System.out.println("test :" + diff);
		System.out.println("test :" + duration);
		System.out.println("test :" + duration.get(ChronoField.HOUR_OF_DAY));
		
		Double d1=Double.valueOf(0.5);
		System.out.println("test :" + d1.toString());

		
		

	}

}
