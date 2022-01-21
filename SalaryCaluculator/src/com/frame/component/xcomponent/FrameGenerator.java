package com.frame.component.xcomponent;

import java.awt.Window;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.exception.FindErrorException;

public class FrameGenerator {
	private final static Set<FrameFactory> factories = new HashSet<>();
	private static Window frame;

	public static void setFactory(FrameFactory factory) {
		factories.add(factory);
	}

	public static Window getFrame(String name) {
		Optional<FrameFactory> opFactory = factories.stream()
				.filter(x -> (frame = x.getFrameInstance(name)) != null)
				.findAny();
		if (frame == null) {
			throw new FindErrorException("找不到 " + name + " ,無法創建Frame");
		}
		return frame;
	}
}
