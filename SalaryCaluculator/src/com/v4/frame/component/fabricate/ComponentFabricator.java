package com.v4.frame.component.fabricate;

import java.awt.Window;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;

import com.v4.frame.component.panel.IPanelFactory;

/*
 * 用於拆分 Frame 裡數量龐大的組件
 */
public abstract class ComponentFabricator {

	private Map<String, JComponent> comps = new HashMap<>();
	private Window frameFather;

	protected ComponentFabricator(Window frameFather) {
		setFrameFather(frameFather);
	}

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

	protected Window getFrameFather() {
		return frameFather;
	}

	private void setFrameFather(Window frameFather) {
		this.frameFather = frameFather;
	}

	public abstract void fabricate(IPanelFactory factory);

}
