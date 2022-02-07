package com.v5.model.punch;

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

	public Timestamp getPunchIn() {
		return punch_in;
	}

	public void setPunchIn(Timestamp punch_in) {
		this.punch_in = punch_in;
	}

	public Timestamp getPunchOut() {
		return punch_out;
	}

	public void setPunchOut(Timestamp punch_out) {
		this.punch_out = punch_out;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (this.punch_in == null ? 0 : this.punch_in.hashCode());
		result = prime * result
				+ (this.punch_out == null ? 0 : this.punch_out.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (this.getClass() != obj.getClass()) {
			return false;
		}

		Punch other = (Punch) obj;
		if (this.punch_in == null) {
			if (other.punch_in != null) {
				return false;
			}
		} else if (this.punch_in.getTime() != other.punch_in.getTime()) {
			return false;
		}

		if (this.punch_out == null) {
			if (other.punch_out != null) {
				return false;
			}
		} else if (this.punch_out.getTime() != other.punch_out.getTime()) {
			return false;
		}

		return true;
	}

	public String toString() {
		return String.format("in=%s, out=%s", this.getPunchIn(),
				this.getPunchOut());
	}

}
