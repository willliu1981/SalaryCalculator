package test.test4;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.v4.model.User;
import com.v4.model.punch.Punch;
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
		this.addToHoldingPunches();
	}

	public void punchOut(Timestamp punchOut) {
		Punch punch = getHoldingPunch();
		punch.setPunchOut(punchOut);
		this.addToHoldingPunches();
	}

	private Punch getHoldingPunch() {
		if (this.holdingPunch == null) {
			this.holdingPunch = new Punch();
			this.holdingPunchIsNew = true;
		}
		return this.holdingPunch;
	}

	private void addToHoldingPunches() {
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
		Punch hold = this.getHoldingPunch();
		if (hold.getPunchIn() == null) {
			newHoldingPunch();
			return;
		}

		Optional<Punch> punchOp = this.punches.stream()
				.filter(x -> x.getPunchIn() != null)
				.sorted((t1,
						t2) -> (int) (t1.getPunchIn().getTime()
								- t2.getPunchIn().getTime()))
				.filter(x2 -> Punches.isAfter(x2.getPunchIn(),
						getHoldingPunch().getPunchIn()))
				.findFirst();
		if (punchOp.isPresent()) {
			this.holdingPunch = punchOp.get();
			this.holdingPunchIsNew = false;
		} else {
			newHoldingPunch();
		}
	}

	public void previous() {
		Punch hold = this.getHoldingPunch();
		if (hold.getPunchIn() == null) {
			newHoldingPunch();
			return;
		}

		Optional<Punch> punchOp = this.punches.stream()
				.filter(x -> x.getPunchIn() != null)
				.sorted((t1,
						t2) -> (int) (t2.getPunchIn().getTime()
								- t1.getPunchIn().getTime()))
				.filter(x2 -> Punches.isBefore(x2.getPunchIn(),
						getHoldingPunch().getPunchIn()))
				.findFirst();
		if (punchOp.isPresent()) {
			this.holdingPunch = punchOp.get();
			this.holdingPunchIsNew = false;
		} else {
			newHoldingPunch();
		}
	}

	public List<Punch> getPunches() {
		return this.punches;
	}

	public Punch getHoldingPunchFortest() {
		return this.holdingPunch;
	}

	public void printListForTest() {
		System.out.println("test :" + this.getClass());
		punches.forEach(x -> System.out.println("  " + x));
	}

}
