package test.test19;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.v5.exception.FindErrorException;
import com.v5.model.punch.Punch;

public class Test19Demo {

	public static void main(String[] args) {
		Punch p1 = new Punch();
		p1.setPunchIn(Timestamp.valueOf("2022-2-7 1:1:1"));
		//p1.setPunchOut(Timestamp.valueOf("2022-2-7 1:1:3"));
		Punch p2 = new Punch();
		p2.setPunchIn(Timestamp.valueOf("2022-2-7 1:1:1"));

		List<Punch> lst = new ArrayList<>();
		add(lst, p1);
		add(lst, p2);
		System.out.println(lst);
	}

	public static void add(List<Punch> lst, Punch punch) {
		if (!lst.contains(punch)) {
			lst.add(punch);
		} else {
			throw new FindErrorException("element repeat!");
		}
	}

}
