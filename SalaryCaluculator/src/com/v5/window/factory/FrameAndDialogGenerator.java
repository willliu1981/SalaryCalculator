package com.v5.window.factory;

import java.awt.Window;
import java.util.HashSet;
import java.util.Set;

import com.v5.exception.FindErrorException;
import com.v5.window.jpanel.factory.IPanelFactory;

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
		return getFrame(compName, factory, true);
	}

	public static Window getFrame(String compName, IPanelFactory panelFactory,
			boolean visible) {
		factories.stream().filter(x -> {
			try {
				frame = x.getFrameInstance(compName, panelFactory);
				if (frame == null) {
					return false;
				}
			} catch (RuntimeException e) {
				System.out.println(
						FrameAndDialogGenerator.class + ":" + e.getMessage());
				return false;
			}
			return true;
		}).findAny();
		if (frame == null) {
			throw new FindErrorException("找不到 " + compName + " ,無法創建Frame");
		}
		frame.setVisible(visible);
		return frame;
	}
}
