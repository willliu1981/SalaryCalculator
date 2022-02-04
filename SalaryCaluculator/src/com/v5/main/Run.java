package com.v5.main;

import java.awt.EventQueue;

import com.v5.main.setting.Setting;
import com.v5.window.jframe.MainFrame;

public class Run {
	public static void main(String[] s) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// 工廠設置
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
