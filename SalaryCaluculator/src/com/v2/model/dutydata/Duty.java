package com.v2.model.dutydata;

import java.util.ArrayList;
import java.util.List;

import com.exception.FindErrorException;
import com.v2.model.datetime.DutyDateTime;

public abstract class Duty<T extends DutyDateTime> {
	private String name;
	private DutyDateTime datetime;
	private List<T> dutyList = new ArrayList<>();

	public Duty() {

	}

	public Duty(String name) {
		this.name = name;
		setDateTime(this.name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	private void setDateTime(String datetime) {
		this.datetime = new DutyDateTime(name);
	}

	public DutyDateTime getDateTime() {
		return this.datetime;
	}

	public void add(T datetime) {
		this.dutyList.add(datetime);
	}

	public void add(Duty<?> duty) {
		this.dutyList.add((T) duty.getDateTime());
	}

	public T get(String name) {
		return this.dutyList.stream().filter(x -> x.getName().equals(name))
				.findAny().orElseThrow(FindErrorException::new);
	}

}
