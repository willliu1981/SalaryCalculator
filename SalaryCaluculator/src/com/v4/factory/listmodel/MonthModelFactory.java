package com.v4.factory.listmodel;

import javax.swing.ListModel;

import com.v4.model.DefaultModelCell;
import com.v4.model.ListDialogModel;

public class MonthModelFactory extends AbsListModelFactory {

	@Override
	public ListModel getListModel() {
		ListDialogModel<DefaultModelCell> model = new ListDialogModel<>();
		String[] monthArray = { "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月",
				"九月", "十月", "十一月", "十二月" };

		for (int i = 0; i < monthArray.length; i++) {
			DefaultModelCell cell = new DefaultModelCell(monthArray[i]);
			cell.setValue(i + 1);
			model.addElement(cell);
		}
		return model;
	}

}
