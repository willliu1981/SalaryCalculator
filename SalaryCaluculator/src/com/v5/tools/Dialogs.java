package com.v5.tools;

import javax.swing.JComponent;

import com.v5.window.factory.jlist.ListModelFactory;
import com.v5.window.interfaces.IListModelComponent;
import com.v5.window.jframe.DialogFrame;

public abstract class Dialogs<T> {
	public static class DialogListTool {
		public void setListModel(JComponent component, String type) {
			ListModelFactory.setModel((IListModelComponent) component, type);
		}
	}

	private final static DialogListTool dialogListTool = new DialogListTool();

	public static DialogListTool getDialogListTool() {
		return dialogListTool;
	}
}
