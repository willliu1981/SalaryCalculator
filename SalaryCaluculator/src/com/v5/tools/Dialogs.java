package com.v5.tools;

import com.v5.window.jframe.DialogFrame;

public class Dialogs {
	public static class DialogListTool {
		public static void setListModel() {
			
		}
	}

	private final static DialogListTool dialogListTool = new DialogListTool();

	public static DialogListTool getDialogListTool(DialogFrame dialogFrame) {
		return dialogListTool;
	}
}
