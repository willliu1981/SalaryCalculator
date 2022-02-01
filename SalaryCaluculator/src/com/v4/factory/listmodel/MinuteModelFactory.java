package com.v4.factory.listmodel;

import javax.swing.ListModel;

import com.v4.model.DefaultModelCell;
import com.v4.model.ListDialogModel;

public class MinuteModelFactory extends AbsListModelFactory {

	@Override
	public ListModel getListModel() {
		ListDialogModel<DefaultModelCell> model = new ListDialogModel<>();

		for (int i = 0; i <= 59; i++) {
			DefaultModelCell cell = new DefaultModelCell("" + i);
			cell.setValue(i);
			model.addElement(cell);
		}
		return model;
	}

}
