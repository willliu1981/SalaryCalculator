package com.v4.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.v4.model.punch.Punch;
import com.v4.model.punch.PunchStrategy;

public class Wage {
	private User user;
	private List<Punch> punchs = new ArrayList<>();
	private Timestamp punchIn;
	private Timestamp punchOut;


	public Wage() {

	}

	public Wage(User user) {
		this.user = user;
	}




	public Timestamp getPunchIn() {
		return punchIn;
	}

	public void setPunchIn(Timestamp punchIn) {
		this.punchIn = punchIn;
	}

	public Timestamp getPunchOut() {
		return punchOut;
	}

	public void setPunchOut(Timestamp punchOut) {
		this.punchOut = punchOut;
	}

	public void punchIn(Timestamp punchIn) {
		Punch punch = new Punch();
		punch.setPunch_in(punchIn);
		this.punchs.add(punch);
	}

	public void pubchOut() {
		
	}

	public List<Punch> testGetPunch() {
		return this.punchs;
	}

}
