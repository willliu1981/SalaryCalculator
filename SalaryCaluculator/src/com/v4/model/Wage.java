package com.v4.model;

import java.sql.Timestamp;
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
		this.user = user;
	}

	public void setPunchStrategy(PunchStrategy punchStrategy) {
		this.punchStrategy = punchStrategy;
	}

	public void punchIn() {
		Timestamp time = punchStrategy.punchIn(null);
		Punch punch = new Punch();
		punch.setPunch_in(time);
		this.punchs.add(punch);
	}

	public void pubchOut() {
		punchStrategy.punchOut(null);
	}

	public List<Punch> testGetPunch() {
		return this.punchs;
	}

}
