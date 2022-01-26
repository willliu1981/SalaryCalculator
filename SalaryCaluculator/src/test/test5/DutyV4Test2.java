package test.test5;

import java.sql.Timestamp;

import com.v4.tools.Punches;

public class DutyV4Test2 {

	public static void main(String[] args) {
		Timestamp t1 = Timestamp.valueOf("2022-1-27 06:01:00");
		Timestamp t2 = Timestamp.valueOf("2022-1-27 07:08:00");

		System.out.println(Punches.isAfter(t1, t2));
	}

}
