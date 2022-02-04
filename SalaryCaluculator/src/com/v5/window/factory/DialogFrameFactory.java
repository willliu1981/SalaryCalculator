package com.v5.window.factory;

import java.awt.Window;

import javax.swing.JDialog;

import com.v5.window.jframe.DialogFrame;
import com.v5.window.jpanel.factory.IPanelFactory;

/*
 * 設定資料型窗口工廠
 */
public class DialogFrameFactory extends AbsFrameFactory {
	public static final String MONTHDIALOG = "monthdialog";
	public static final String DAYDIALOG = "daydialog";
	public static final String HOURDIALOG = "hourdialog";
	public static final String MINUTEDIALOG = "minutedialog";
	public static final String DATEDIALOG = "datedialog";
	public static final String TIMEDIALOG = "timedialog";
	public static final String LISTDIALOG = "listdialog";

	public Window getFrameInstance(String contentPanelName,
			IPanelFactory panelFactory) {
		DialogFrame frame = new DialogFrame();

		frame.setContentComponent(contentPanelName, panelFactory);

		return frame;
	}

}
