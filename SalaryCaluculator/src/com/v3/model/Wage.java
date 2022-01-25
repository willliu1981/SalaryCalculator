package com.v3.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.v3.model.punch.Punch;
import com.v3.model.punch.PunchStrategy;

public class Wage {
	private User user;
	private List<Punch> punchs = new ArrayList<>();
	private PunchStrategy punchStrategy;

	public Wage() {

	}

	public Wage(User user) {
		this(user, null);
	}

	public Wage(PunchStrategy punchStrategy) {
		this(null, punchStrategy);
	}

	public Wage(User user, PunchStrategy punchStrategy) {
		this.user = user;
		this.punchStrategy = punchStrategy;
	}

	public void punchIn() {
		punchStrategy.punchIn(new Date(new java.util.Date().getTime()));
	}

	public void pubchOut() {
		punchStrategy.punchOut(new Date(new java.util.Date().getTime()));
	}

}
