package com.v4;

import java.awt.EventQueue;

import com.v4.frame.main.MainFrame;
import com.v4.setting.Setting;

public class Run {
	public static void main(String[] s) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//工廠設置
					Setting.initialize();
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
