package com.v4.frame.component.jpanel.dialogpanel.jlist.factory;

import javax.swing.ListModel;

import com.v4.factory.listmodel.AbsListModelFactory;
import com.v4.model.DefaultModelCell;
import com.v4.model.ListDialogModel;

public class HourModelFactory extends AbsListModelFactory {

	@Override
	public ListModel getListModel() {
		ListDialogModel<DefaultModelCell> model = new ListDialogModel<>();

		for (int i = 0; i <= 23; i++) {
			DefaultModelCell cell = new DefaultModelCell("" + i);
			cell.setValue(i);
			model.addElement(cell);
		}
		return model;
	}

}
