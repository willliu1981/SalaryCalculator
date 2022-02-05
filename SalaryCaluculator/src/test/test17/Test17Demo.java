package test.test17;

import java.sql.Timestamp;

import com.v5.dispatcher.model.Wage;
import com.v5.model.punch.Punch;
import com.v5.tools.Wages;

public class Test17Demo {

	public static void main(String[] args) {

		Wage w = new Wage();
		w.punchIn(Timestamp.valueOf("2022-2-5 2:20:0"));
		w.punchOut(Timestamp.valueOf("2022-2-5 3:50:0"));
		w.newHoldingPunch();
		w.punchIn(Timestamp.valueOf("2022-2-5 12:20:0"));
		w.punchOut(Timestamp.valueOf("2022-2-5 13:20:0"));

		System.out.println(Wages.calculateToHourWithMonth(w, 0));

	}

}
