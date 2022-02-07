package test.test1;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.model.DutyData;
import com.model.DutyOfDay;
import com.model.DutyOfMonth;
import com.proxy.DutyOfDayProxy;
import com.proxy.DutyOfMonthProxy;
import com.proxy.IDutyOfDay;
import com.proxy.IDutyOfMonth;

public class Test4 {

	public static void main(String[] args) {
		DutyOfMonth monthDuty = new DutyOfMonth();
		IDutyOfMonth monthDutyProxy = new DutyOfMonthProxy(monthDuty);

		//
		DutyData dutyDataType_1830 = new DutyData();
		dutyDataType_1830.setStartTime(Time.valueOf("18:30:00"));
		dutyDataType_1830.setEndTime(Time.valueOf("21:00:00"));

		DutyData dutyDataType_1000 = new DutyData();
		dutyDataType_1000.setStartTime(Time.valueOf("10:00:00"));
		dutyDataType_1000.setEndTime(Time.valueOf("14:00:00"));

		DutyData dutyDataType_1030 = new DutyData();
		dutyDataType_1030.setStartTime(Time.valueOf("10:30:00"));
		dutyDataType_1030.setEndTime(Time.valueOf("14:00:00"));

		DutyData dutyDataType_1100 = new DutyData();
		dutyDataType_1100.setStartTime(Time.valueOf("11:00:00"));
		dutyDataType_1100.setEndTime(Time.valueOf("14:00:00"));

		DutyData dutyDataType_1600 = new DutyData();
		dutyDataType_1600.setStartTime(Time.valueOf("16:00:00"));
		dutyDataType_1600.setEndTime(Time.valueOf("21:00:00"));

		DutyData dutyDataType_1630 = new DutyData();
		dutyDataType_1630.setStartTime(Time.valueOf("16:30:00"));
		dutyDataType_1630.setEndTime(Time.valueOf("21:00:00"));

		//
		List<IDutyOfDay> dayDutyProxyList = new ArrayList<>();

		DutyOfDay dayDuty1 = new DutyOfDay(Date.valueOf("2021-12-3"));
		dayDutyProxyList.add(new DutyOfDayProxy(dayDuty1));
		dayDuty1.add(dutyDataType_1100);
		dayDuty1.add(dutyDataType_1600);

		DutyOfDay dayDuty2 = new DutyOfDay(Date.valueOf("2021-12-4"));
		dayDutyProxyList.add(new DutyOfDayProxy(dayDuty2));
		dayDuty2.add(dutyDataType_1100);
		dayDuty2.add(dutyDataType_1630);

		DutyOfDay dayDuty3 = new DutyOfDay(Date.valueOf("2021-12-5"));
		dayDutyProxyList.add(new DutyOfDayProxy(dayDuty3));
		dayDuty3.add(dutyDataType_1100);
		dayDuty3.add(dutyDataType_1630);

		DutyOfDay dayDuty4 = new DutyOfDay(Date.valueOf("2021-12-8"));
		dayDutyProxyList.add(new DutyOfDayProxy(dayDuty4));
		dayDuty4.add(dutyDataType_1830);

		DutyOfDay dayDuty5 = new DutyOfDay(Date.valueOf("2021-12-9"));
		dayDutyProxyList.add(new DutyOfDayProxy(dayDuty5));
		dayDuty5.add(dutyDataType_1100);
		dayDuty5.add(dutyDataType_1630);

		DutyOfDay dayDuty6 = new DutyOfDay(Date.valueOf("2021-12-11"));
		dayDutyProxyList.add(new DutyOfDayProxy(dayDuty6));
		dayDuty6.add(dutyDataType_1100);
		dayDuty6.add(dutyDataType_1630);

		DutyOfDay dayDuty7 = new DutyOfDay(Date.valueOf("2021-12-12"));
		dayDutyProxyList.add(new DutyOfDayProxy(dayDuty7));
		dayDuty7.add(dutyDataType_1100);
		dayDuty7.add(dutyDataType_1630);

		DutyOfDay dayDuty8 = new DutyOfDay(Date.valueOf("2021-12-14"));
		dayDutyProxyList.add(new DutyOfDayProxy(dayDuty8));
		dayDuty8.add(dutyDataType_1030);
		dayDuty8.add(dutyDataType_1600);

		DutyOfDay dayDuty9 = new DutyOfDay(Date.valueOf("2021-12-15"));
		dayDutyProxyList.add(new DutyOfDayProxy(dayDuty9));
		dayDuty9.add(dutyDataType_1030);
		dayDuty9.add(dutyDataType_1600);

		DutyOfDay dayDuty10 = new DutyOfDay(Date.valueOf("2021-12-16"));
		dayDutyProxyList.add(new DutyOfDayProxy(dayDuty10));
		dayDuty10.add(dutyDataType_1030);
		dayDuty10.add(dutyDataType_1600);

		DutyOfDay dayDuty11 = new DutyOfDay(Date.valueOf("2021-12-17"));
		dayDutyProxyList.add(new DutyOfDayProxy(dayDuty11));
		dayDuty11.add(dutyDataType_1030);
		dayDuty11.add(dutyDataType_1600);

		DutyOfDay dayDuty12 = new DutyOfDay(Date.valueOf("2021-12-18"));
		dayDutyProxyList.add(new DutyOfDayProxy(dayDuty12));
		dayDuty12.add(dutyDataType_1030);
		dayDuty12.add(dutyDataType_1630);

		DutyOfDay dayDuty13 = new DutyOfDay(Date.valueOf("2021-12-19"));
		dayDutyProxyList.add(new DutyOfDayProxy(dayDuty13));
		dayDuty13.add(dutyDataType_1030);
		dayDuty13.add(dutyDataType_1600);

		DutyOfDay dayDuty14 = new DutyOfDay(Date.valueOf("2021-12-21"));
		dayDutyProxyList.add(new DutyOfDayProxy(dayDuty14));
		dayDuty14.add(dutyDataType_1030);
		dayDuty14.add(dutyDataType_1600);

		DutyOfDay dayDuty15 = new DutyOfDay(Date.valueOf("2021-12-25"));
		dayDutyProxyList.add(new DutyOfDayProxy(dayDuty15));
		dayDuty15.add(dutyDataType_1100);
		dayDuty15.add(dutyDataType_1630);

		DutyOfDay dayDuty16 = new DutyOfDay(Date.valueOf("2021-12-26"));
		dayDutyProxyList.add(new DutyOfDayProxy(dayDuty16));
		dayDuty16.add(dutyDataType_1100);
		dayDuty16.add(dutyDataType_1630);

		DutyOfDay dayDuty17 = new DutyOfDay(Date.valueOf("2021-12-31"));
		dayDutyProxyList.add(new DutyOfDayProxy(dayDuty17));
		dayDuty17.add(dutyDataType_1100);
		dayDuty17.add(dutyDataType_1630);

		monthDutyProxy.addAll(dayDutyProxyList);

		System.out.println(
				"call monthDuty...\ntotal hours: " + monthDuty.getTotalHours());
		System.out.println("\n=====================");
		System.out.println("\ncall monthDutyProxy...");
		System.out.println("\ntotal hours: " + monthDutyProxy.getTotalHours());

	}

}
