package com.v4.frame.component.frame;

import java.awt.Window;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.exception.FindErrorException;

public class FrameGenerator {
	private final static Set<AbsFrameFactory> factories = new HashSet<>();
	private static Window frame;

	public static void setFactory(AbsFrameFactory factory) {
		factories.add(factory);
	}

	public static Window getFrame(String compName) {
		factories.stream()
				.filter(x -> (frame = x.getFrameInstance(compName)) != null)
				.findAny();
		if (frame == null) {
			throw new FindErrorException("找不到 " + compName + " ,無法創建Frame");
		}
		return frame;
	}
}
