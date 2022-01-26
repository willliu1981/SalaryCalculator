package test.test5;

import java.sql.Timestamp;

import com.v4.model.Wage;
import com.v4.model.punch.AccuratePunchStrategy;
import com.v4.model.punch.DefaultPunchStrategy;
import com.v4.model.punch.HalfHourPunchStrategy;
import com.v4.model.punch.PunchStrategy;
import com.v4.tools.Wages;

public class DutyV4Test {

	public static void main(String[] args) {
		PunchStrategy defaultPunchStrategy = new DefaultPunchStrategy();
		PunchStrategy halfHourPunchStrategy = new HalfHourPunchStrategy();
		PunchStrategy accuratePunchStrategy = new AccuratePunchStrategy();

		Wage wage = new Wage();
		wage.setPunchIn(Timestamp.valueOf("2022-1-26 19:22:22"));
		wage.setPunchOut(Timestamp.valueOf("2022-1-26 21:42:22"));
		Wages.punchIn(wage, halfHourPunchStrategy);
		Wages.punchOut(wage, halfHourPunchStrategy);

		wage.newHoldingPunch();
		wage.setPunchIn(Timestamp.valueOf("2022-1-27 8:42:22"));
		Wages.punchIn(wage, halfHourPunchStrategy);
		
		wage.newHoldingPunch();
		wage.setPunchIn(Timestamp.valueOf("2022-1-20 18:02:22"));
		Wages.punchIn(wage, halfHourPunchStrategy);

		wage.testGetPunches().forEach(x -> System.out.printf("in=%s  out=%s\n",
				x.getPunchIn(), x.getPunchOut()));
		System.out.println("size : " + wage.testGetPunches().size());
		wage.next();
		System.out.println("hold : " + wage.testGetHoldingPunch().getPunchIn());
		wage.next();
		System.out.println("hold : " + wage.testGetHoldingPunch().getPunchIn());
		wage.next();
		System.out.println("hold : " + wage.testGetHoldingPunch().getPunchIn());
		wage.next();
		System.out.println("hold : " + wage.testGetHoldingPunch().getPunchIn());
		
		

	}

}
