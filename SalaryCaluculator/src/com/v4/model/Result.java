package com.v4.model;

import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

import com.v4.exception.FindErrorException;

public class Result {
	private final String DEFAULT = "default-" + this.hashCode();
	private Map<String, Object> results = new HashMap<>();

	private Map<String, Object> getResults() {
		if (results.size() == 0) {
			throw new FindErrorException();
		}
		return this.results;
	}

	private Object getResultWithContainKey(String containKey) {
		System.out.println("xxxx:" + !getResults().containsKey(containKey));
		this.getResults().forEach(
				(x, y) -> System.out.printf("key=%s,value=%s\n", x, y));

		if (!getResults().containsKey(containKey)) {
			throw new FindErrorException();
		}
		return this.results.get(containKey);
	}

	public void add(String name, Object o) {
		this.results.put(name, o);
	}

	public void add(Object o) {
		this.results.put(DEFAULT, o);
	}

	public Object get(String name) {
		return getResultWithContainKey(name);
	}

	public Object get() {
		Object o = null;
		try {
			o = getResultWithContainKey(DEFAULT);
		} catch (RuntimeException e) {
			e.printStackTrace();
			try {
				o = getResults().entrySet().stream().findFirst().get();
			} catch (RuntimeException e2) {
				e.printStackTrace();
			}
		}
		return o;
	}
}
