package com.v4.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.v4.model.punch.Punch;
import com.v4.model.punch.PunchStrategy;
import com.v4.tools.Punches;

public class Wage {
	private User user;
	private List<Punch> punches = new ArrayList<>();
	private Timestamp punchIn;
	private Timestamp punchOut;
	private Punch holdingPunch;
	private boolean holdingPunchIsNew = true;
	private List<Punch> foundPunches = new ArrayList<>();

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
		Punch punch = getHoldingPunch();
		punch.setPunchIn(punchIn);
		this.addHoldingPunch();
	}

	public void punchOut(Timestamp punchOut) {
		Punch punch = getHoldingPunch();
		punch.setPunchOut(punchOut);
		this.addHoldingPunch();
	}

	private Punch getHoldingPunch() {
		if (this.holdingPunch == null) {
			this.holdingPunch = new Punch();
			this.holdingPunchIsNew = true;
		}
		return this.holdingPunch;
	}
	

	private void addHoldingPunch() {
		if (this.holdingPunchIsNew == true) {
			this.punches.add(holdingPunch);
			this.holdingPunchIsNew = false;
		}
	}

	public void newHoldingPunch() {
		this.holdingPunch = null;
		this.getHoldingPunch();
	}

	public void next() {
		Punch hold=this.getHoldingPunch();
		if (hold.getPunchIn()==null) {
			newHoldingPunch();
			return;
		}

		Optional<Punch> punchOp = this.punches.stream()
				.sorted((t1,
						t2) -> (int) (t1.getPunchIn().getTime()
								- t2.getPunchIn().getTime()))
				.filter(x -> Punches.isAfter(x.getPunchIn(),
						getHoldingPunch().getPunchIn()))
				.findFirst();
		if (punchOp.isPresent()) {
			this.holdingPunch = punchOp.get();
			this.holdingPunchIsNew=false;
		} else {
			newHoldingPunch();
		}
	}

	public void previous() {
		Punch hold=this.getHoldingPunch();
		if (hold.getPunchIn()==null) {
			newHoldingPunch();
			return;
		}

		Optional<Punch> punchOp = this.punches.stream()
				.sorted((t1,
						t2) -> (int) (t2.getPunchIn().getTime()
								- t1.getPunchIn().getTime()))
				.filter(x -> Punches.isBefore(x.getPunchIn(),
						getHoldingPunch().getPunchIn()))
				.findFirst();
		if (punchOp.isPresent()) {
			this.holdingPunch = punchOp.get();
			this.holdingPunchIsNew=false;
		} else {
			newHoldingPunch();
		}
	}

	public List<Punch> testGetPunches() {
		return this.punches;
	}

	public Punch testGetHoldingPunch() {
		return this.holdingPunch;
	}

}
