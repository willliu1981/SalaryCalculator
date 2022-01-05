package com.model;

import java.util.ArrayList;
import java.util.List;

public class DutyOfDay {
	private List<DutyData> dutyDatas;

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
}
