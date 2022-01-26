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
	private Punch holdingPunch;
	private boolean holdedPunchIsNew = true;

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
		Punch punch = getHoldPunch();
		punch.setPunchIn(punchIn);
		this.addHoldedPunch();
	}

	public void punchOut(Timestamp punchOut) {
		Punch punch = getHoldPunch();
		punch.setPunchOut(punchOut);
		this.addHoldedPunch();
	}

	private Punch getHoldPunch() {
		if (this.holdingPunch == null) {
			this.holdingPunch = new Punch();
			this.holdedPunchIsNew = true;
		}
		return this.holdingPunch;
	}

	private void addHoldedPunch() {
		if (this.holdedPunchIsNew == true) {
			this.punchs.add(holdingPunch);
			this.holdedPunchIsNew = false;
		}
	}

	public List<Punch> testGetPunch() {
		return this.punchs;
	}

}
