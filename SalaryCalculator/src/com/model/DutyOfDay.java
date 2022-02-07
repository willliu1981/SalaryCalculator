package com.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.proxy.IDutyOfDay;

public class DutyOfDay implements IDutyOfDay{
	private List<DutyData> dutyDatas;
	private Date date;

	public DutyOfDay() {

	}

	public DutyOfDay(Date date) {
		this.setDate(date);
	}

	private List<DutyData> getDutyDataList() {
		if (dutyDatas == null) {
			dutyDatas = new ArrayList<>();
		}
		return this.dutyDatas;
	}

	public void add(DutyData dutyData) {
		this.getDutyDataList().add(dutyData);
	}

	public void remove(DutyData dutyData) {
		this.getDutyDataList().remove(dutyData);
	}

	public double getTotalHours() {
		double totalHours = this.getDutyDataList().stream()
				.mapToDouble(x -> Double.valueOf(x.getDoubleHourDiff()))
				.reduce((total, diff) -> total + diff).getAsDouble();
		return totalHours;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return this.date;
	}

	public int getDayOfDate() {
		if (this.date==null) {
			return -1;
		}
		return this.date.toLocalDate().getDayOfMonth();
	}
}
