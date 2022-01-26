package com.v4;

import com.v4.model.punch.PunchStrategy;

import test.test4.Wage;

public class Wages {

	public static void punchIn(Wage wage, PunchStrategy punchStrategy) {
		wage.punchIn(punchStrategy.punchIn(wage.getPunchIn()));
	}
	public static void punchOut(Wage wage, PunchStrategy punchStrategy) {
		wage.punchOut(punchStrategy.punchOut(wage.getPunchOut()));
	}
}
