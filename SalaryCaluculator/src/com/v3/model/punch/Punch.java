package com.v3.model.punch;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Punch {
	private String name;
	private Date date;
	private Timestamp punch_in;
	private Timestamp punch_out;

	public Punch() {

	}

	public Punch(Date date) {
		this(null, date);
	}

	public Punch(String name) {
		this(name, null);
	}

	public Punch(String name, Date date) {
		this.name = name;
		this.date = date;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Timestamp getPunch_in() {
		return punch_in;
	}

	public void setPunch_in(Timestamp punch_in) {
		this.punch_in = punch_in;
	}

	public Timestamp getPunch_out() {
		return punch_out;
	}

	public void setPunch_out(Timestamp punch_out) {
		this.punch_out = punch_out;
	}

}
