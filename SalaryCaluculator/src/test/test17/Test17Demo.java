package test.test17;

import java.sql.Timestamp;

import com.v5.model.punch.Punch;
import com.v5.model.punch.tool.Punches;

public class Test17Demo {

	public static void main(String[] args) {

		Punch p = new Punch();
		p.setPunchIn(Timestamp.valueOf("2022-2-5 2:20:0"));
		p.setPunchOut(Timestamp.valueOf("2022-2-5 4:35:0"));
		double diffm = Punches.getDiffOfMinute(p);
		double diffh = Punches.getDiffOfHour(p);
		System.out.println(diffm);
		System.out.println(diffh);

	}

}
