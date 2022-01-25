package com.v3.model.punch;

import java.sql.Date;
import java.sql.Time;

public class Punch {
	private String name;
	private Date date;
	private Time punch_in;
	private Time punch_out;

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

	public Time getPunch_in() {
		return punch_in;
	}

	public void setPunch_in(Time punch_in) {
		this.punch_in = punch_in;
	}

	public Time getPunch_out() {
		return punch_out;
	}

	public void setPunch_out(Time punch_out) {
		this.punch_out = punch_out;
	}

}
