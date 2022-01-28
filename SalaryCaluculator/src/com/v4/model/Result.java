package com.v4.model;

import java.util.HashMap;
import java.util.Map;

public class Result {
	private Map<String, Object> results = new HashMap<>();

	public void add(String name, Object o) {
		this.results.put(name, o);
	}

	public void add(Object o) {
		this.results.put("default-" + this.hashCode(), o);
	}

	public Object get(String name) {
		return this.results.get(name);
	}

	public Object get() {
		return this.results.get("default-" + this.hashCode());
	}
}
