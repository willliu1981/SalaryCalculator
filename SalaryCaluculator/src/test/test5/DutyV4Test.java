package test.test5;

import java.sql.Timestamp;

import com.v4.Wages;
import com.v4.model.Wage;
import com.v4.model.punch.AccuratePunchStrategy;
import com.v4.model.punch.DefaultPunchStrategy;
import com.v4.model.punch.HalfHourPunchStrategy;
import com.v4.model.punch.PunchStrategy;

public class DutyV4Test {

	public static void main(String[] args) {
		PunchStrategy defaultPunchStrategy = new DefaultPunchStrategy();
		PunchStrategy halfHourPunchStrategy = new HalfHourPunchStrategy();
		PunchStrategy accuratePunchStrategy = new AccuratePunchStrategy();

		Wage wage = new Wage();
		wage.setPunchIn(Timestamp.valueOf("2022-1-26 19:22:22"));
		Wages.punchIn(wage, halfHourPunchStrategy);

		wage.testGetPunch().forEach(x -> System.out.println(x.getPunch_in()));

	}

}
