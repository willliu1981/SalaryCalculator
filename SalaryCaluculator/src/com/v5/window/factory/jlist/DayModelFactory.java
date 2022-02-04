package com.v5.window.factory.jlist;

import javax.swing.ListModel;

import com.v5.model.DefaultModelCell;
import com.v5.model.ListDialogModel;



public class DayModelFactory extends AbsListModelFactory {

	@Override
	public ListModel getListModel() {
		ListDialogModel<DefaultModelCell> model = new ListDialogModel<>();

		for (int i = 1; i <= 31; i++) {
			DefaultModelCell cell = new DefaultModelCell("" + i);
			cell.setValue(i);
			model.addElement(cell);
		}
		return model;
	}

}
