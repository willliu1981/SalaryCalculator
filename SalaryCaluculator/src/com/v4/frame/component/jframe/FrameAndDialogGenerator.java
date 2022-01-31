package com.v4.frame.component.jframe;

import java.awt.Window;
import java.util.HashSet;
import java.util.Set;

import com.v4.exception.FindErrorException;
import com.v4.frame.component.jpanel.IPanelFactory;

/*
 * Frame 和 Dialog 產生器
 * 需注入次級 Panel 工廠
 */
public class FrameAndDialogGenerator {
	private final static Set<AbsFrameFactory> factories = new HashSet<>();
	private static Window frame;

	public static void setFactory(AbsFrameFactory factory) {
		factories.add(factory);
	}

	public static Window getFrame(String compName, IPanelFactory factory) {
		factories.stream().filter(x -> {
			try {
				frame = x.getFrameInstance(compName, factory);
			} catch (RuntimeException e) {
				return false;
			}
			return true;
		}).findAny();
		if (frame == null) {
			throw new FindErrorException("找不到 " + compName + " ,無法創建Frame");
		}
		// frame.setVisible(true);
		return frame;
	}
}
