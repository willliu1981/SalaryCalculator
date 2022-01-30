package com.v4.model;

public abstract class AbsModelCell {
	private String name;

	public AbsModelCell() {
	}

	public AbsModelCell(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return this.name;
	}
}
