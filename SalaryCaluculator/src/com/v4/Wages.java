package com.v4;

import com.v4.model.Wage;
import com.v4.model.punch.PunchStrategy;

public class Wages {

	public static void punchIn(Wage wage, PunchStrategy punchStrategy) {
		wage.punchIn(punchStrategy.punchIn(wage.getPunchIn()));
	}
}
