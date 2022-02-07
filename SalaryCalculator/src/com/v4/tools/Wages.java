package com.v4.tools;

import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import com.v4.model.punch.PunchStrategy;

import test.test4.Wage;

public class Wages {

	public static void punchIn(Wage wage, PunchStrategy punchStrategy) {
		wage.punchIn(punchStrategy.punchIn(wage.getPunchIn()));
	}

	public static void punchOut(Wage wage, PunchStrategy punchStrategy) {
		wage.punchOut(punchStrategy.punchOut(wage.getPunchOut()));
	}

	public static ListModel getListModelForMonth(Wage wage, int month) {
		DefaultListModel model = new DefaultListModel();

		wage.getPunches().forEach(x -> model.addElement(x));

		return model;
	}

	public static void output(Wage wage, File file) {

	}

	public static Wage input(Wage wage, File file) {

		return null;
	}
}
