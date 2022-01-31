package com.v4.factory.listmodel;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.ListModel;

import com.v4.frame.component.IListModelComponent;

public class ListModelFactory {
	public static class _ListModelFactory {
		private Map<String, AbsListModelFactory> factories = new HashMap<>();

		public _ListModelFactory setFactory(String name,
				AbsListModelFactory factory) {
			factories.put(name, factory);
			return this;
		}

		private ListModel getModel(String model) {
			return this.factories.get(model).getListModel();
		}
	}

	private static ListModelFactory singleton = new ListModelFactory();
	private _ListModelFactory _singleton = new _ListModelFactory();

	public static final String MONTH = "month";
	public static final String Day = "day";

	public static _ListModelFactory setFactory(String name,
			AbsListModelFactory factory) {
		singleton._singleton.factories.put(name, factory);
		return singleton._singleton;
	}

	public static ListModel getListModel(String factoryName) {

		return singleton._singleton.factories.get(factoryName).getListModel();
	}

	public static void setModel(IListModelComponent comp, String model) {
		comp.setModel(singleton._singleton.getModel(model));
	}
}
