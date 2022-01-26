package test.test5;

import java.util.List;

import com.v3.model.User;
import com.v3.model.Wage;
import com.v3.model.punch.AccuratePunchStrategy;
import com.v3.model.punch.DefaultPunchStrategy;
import com.v3.model.punch.HalfHourPunchStrategy;
import com.v3.model.punch.Punch;
import com.v3.model.punch.PunchStrategy;

public class DutyV3Test2 {
	public static void main(String[] s) {

		User u = new User();
		u.setName("Wu");

		Wage wage = new Wage();
		PunchStrategy defaultPunchStrategy = new DefaultPunchStrategy(null,
				null);
		PunchStrategy halfHourPunchStrategy = new HalfHourPunchStrategy(null,
				null);
		PunchStrategy accuratePunchStrategy = new AccuratePunchStrategy();
		
		wage.setPunchStrategy(accuratePunchStrategy);
		wage.punchIn();
		wage.setPunchStrategy(defaultPunchStrategy);
		wage.punchIn();

		List<Punch> list = wage.testGetPunch();
		list.forEach(x -> System.out.println(x.getPunch_in()));

	}
}
