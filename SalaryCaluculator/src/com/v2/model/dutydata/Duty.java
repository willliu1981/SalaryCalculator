package com.v2.model.dutydata;

import java.util.ArrayList;
import java.util.List;

import com.exception.FindErrorException;
import com.v2.model.datetime.WageDateTime;

public abstract class Duty<T extends WageDateTime> {
	private String name;
	private WageDateTime datetime;
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
		this.datetime = new WageDateTime(name);
	}

	public WageDateTime getDateTime() {
		return this.datetime;
	}

	private void add(T datetime) {
		this.dutyList.add(datetime);
	}

	public void add(Duty<?> duty) {
		add((T) duty.getDateTime());
	}

	public T get(String name) {
		return this.dutyList.stream().filter(x -> x.getName().equals(name))
				.findAny().orElseThrow(FindErrorException::new);
	}

}
