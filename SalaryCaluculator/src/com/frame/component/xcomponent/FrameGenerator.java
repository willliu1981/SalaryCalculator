package com.frame.component.xcomponent;

import java.awt.Window;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.exception.FindErrorException;

public class FrameGenerator {
	private final static Set<FrameFactory> factories = new HashSet<>();

	public static void setFactory(FrameFactory factory) {
		factories.add(factory);
	}

	public static Window getFrame(String name) {
		Optional<FrameFactory> opFactory = factories.stream()
				.filter(x -> x.getFrameInstance(name) != null).findAny();
		if (opFactory.isPresent()) {
			return opFactory.get().getFrameInstance(name);
		}
		throw new FindErrorException("找不到 " + name + " ,無法創建Frame");
	}
}
