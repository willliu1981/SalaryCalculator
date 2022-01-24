package com.frame.component.fabricate;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;

/*
 * 用於拆分 Frame 裡數量龐大的組件
 */
public abstract class ComponentFabricator {

	private Map<String, JComponent> comps = new HashMap<>();

	public void add(String name, JComponent comp) {
		this.comps.put(name, comp);
	}

	public void remove(String name, JComponent comp) {
		this.comps.remove(name);
	}

	public JComponent get(String name) {
		return this.comps.get(name);
	}

	protected boolean isExist(String name) {
		return this.comps.containsKey(name);
	}

	public abstract void fabricate();

}
