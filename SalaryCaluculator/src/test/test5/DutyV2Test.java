package test.test5;

import com.v2.model.dutydata.DutyOfMonth;
import com.v2.model.dutydata.DutyOfYear;

public class DutyV2Test {

	public static void main(String[] args) {
	 	DutyOfYear year=new DutyOfYear("2022");
	 	DutyOfMonth month=new DutyOfMonth("12");
	 	
	 	year.add(month);
	 	
	 	
	}

}
