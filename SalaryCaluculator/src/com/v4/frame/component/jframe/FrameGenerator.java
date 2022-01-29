package com.v4.frame.component.jframe;

import java.awt.Window;
import java.util.HashSet;
import java.util.Set;

import com.v4.exception.FindErrorException;
import com.v4.frame.component.jpanel.IPanelFactory;


public class FrameGenerator {
	private final static Set<AbsFrameFactory> factories = new HashSet<>();
	private static Window frame;

	public static void setFactory(AbsFrameFactory factory) {
		factories.add(factory);
	}

	public static Window getFrame(String compName,IPanelFactory factory) {
		factories.stream()
				.filter(x -> (frame = x.getFrameInstance(compName,factory)) != null)
				.findAny();
		if (frame == null) {
			throw new FindErrorException("找不到 " + compName + " ,無法創建Frame");
		}
		frame.setVisible(true);
		return frame;
	}
}
