package test.test17;

import java.sql.Timestamp;

import com.v5.model.Wage;
import com.v5.model.punch.Punch;
import com.v5.tools.Wages;

public class Test17Demo {

	public static void main(String[] args) {

		Wage w = new Wage();
		w.punchIn(Timestamp.valueOf("2022-1-1 11:00:0"));
		w.punchOut(Timestamp.valueOf("2022-1-1 14:30:0"));
		w.newHoldingPunch();
		w.punchIn(Timestamp.valueOf("2022-1-1 16:30:0"));
		w.punchOut(Timestamp.valueOf("2022-1-1 21:30:0"));
		w.newHoldingPunch();

		w.punchIn(Timestamp.valueOf("2022-1-2 11:00:0"));
		w.punchOut(Timestamp.valueOf("2022-1-2 13:30:0"));
		w.newHoldingPunch();
		w.punchIn(Timestamp.valueOf("2022-1-2 16:30:0"));
		w.punchOut(Timestamp.valueOf("2022-1-2 21:00:0"));
		w.newHoldingPunch();

		w.punchIn(Timestamp.valueOf("2022-1-6 10:30:0"));
		w.punchOut(Timestamp.valueOf("2022-1-6 14:00:0"));
		w.newHoldingPunch();
		w.punchIn(Timestamp.valueOf("2022-1-6 16:30:0"));
		w.punchOut(Timestamp.valueOf("2022-1-6 21:00:0"));
		w.newHoldingPunch();

		w.punchIn(Timestamp.valueOf("2022-1-8 11:00:0"));
		w.punchOut(Timestamp.valueOf("2022-1-8 14:00:0"));
		w.newHoldingPunch();
		w.punchIn(Timestamp.valueOf("2022-1-8 16:30:0"));
		w.punchOut(Timestamp.valueOf("2022-1-8 21:00:0"));
		w.newHoldingPunch();

		w.punchIn(Timestamp.valueOf("2022-1-9 11:00:0"));
		w.punchOut(Timestamp.valueOf("2022-1-9 14:00:0"));
		w.newHoldingPunch();
		w.punchIn(Timestamp.valueOf("2022-1-9 16:30:0"));
		w.punchOut(Timestamp.valueOf("2022-1-9 21:00:0"));
		w.newHoldingPunch();

		w.punchIn(Timestamp.valueOf("2022-1-13 16:30:0"));
		w.punchOut(Timestamp.valueOf("2022-1-13 20:30:0"));
		w.newHoldingPunch();

		w.punchIn(Timestamp.valueOf("2022-1-15 11:00:0"));
		w.punchOut(Timestamp.valueOf("2022-1-15 14:00:0"));
		w.newHoldingPunch();
		w.punchIn(Timestamp.valueOf("2022-1-15 16:30:0"));
		w.punchOut(Timestamp.valueOf("2022-1-15 21:00:0"));
		w.newHoldingPunch();

		w.punchIn(Timestamp.valueOf("2022-1-16 11:00:0"));
		w.punchOut(Timestamp.valueOf("2022-1-16 14:00:0"));
		w.newHoldingPunch();
		w.punchIn(Timestamp.valueOf("2022-1-16 16:30:0"));
		w.punchOut(Timestamp.valueOf("2022-1-16 20:30:0"));
		w.newHoldingPunch();

		w.punchIn(Timestamp.valueOf("2022-1-22 11:00:0"));
		w.punchOut(Timestamp.valueOf("2022-1-22 14:00:0"));
		w.newHoldingPunch();
		w.punchIn(Timestamp.valueOf("2022-1-22 16:30:0"));
		w.punchOut(Timestamp.valueOf("2022-1-22 21:00:0"));
		w.newHoldingPunch();

		w.punchIn(Timestamp.valueOf("2022-1-23 11:00:0"));
		w.punchOut(Timestamp.valueOf("2022-1-23 14:00:0"));
		w.newHoldingPunch();
		w.punchIn(Timestamp.valueOf("2022-1-23 16:30:0"));
		w.punchOut(Timestamp.valueOf("2022-1-23 21:00:0"));
		w.newHoldingPunch();

		w.punchIn(Timestamp.valueOf("2022-1-30 16:30:0"));
		w.punchOut(Timestamp.valueOf("2022-1-30 21:00:0"));
		w.newHoldingPunch();

		System.out.println(Wages.calculateToHourWithMonth(w, 0));

	}

}
