package test.test5;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.v3.model.punch.HalfHourPunchStrategy;
import com.v3.model.punch.PunchStrategy;

public class DutyV3Test {

	public static void main(String[] args) {

		Timestamp stamp = new PunchStrategy() {

			@Override
			public Timestamp setDefaultPunchInTime() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Timestamp setDefaultPunchOutTime() {
				// TODO Auto-generated method stub
				return null;
			}
		}.now();

		LocalDateTime time = stamp.toLocalDateTime();
		time = time.plusMinutes(5);
		LocalDateTime time2 = time.minusMinutes(time.getMinute());
		if (time.getMinute() > 30) {
			time2 = time2.plusHours(1);
		}
		System.out.println(time);
		System.out.println("t2=" + time2);

		stamp = Timestamp.valueOf("2022-1-26 5:30:22");
		HalfHourPunchStrategy strategy = new HalfHourPunchStrategy(stamp,
				stamp);
		Timestamp s2 = strategy.punchOut();
		System.out.println("xxx1=" + stamp);
		System.out.println("xxx2=" + s2);
	}

}
