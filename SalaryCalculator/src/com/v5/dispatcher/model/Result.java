package com.v5.dispatcher.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

import com.v4.exception.FindErrorException;

public class Result<T> {
	private final String DEFAULT = "default-" + this.hashCode();
	private Map<String, T> results = new HashMap<>();

	private Map<String, T> getResults() {
		if (results.size() == 0) {
			throw new FindErrorException(this + ":size=0");
		}
		return this.results;
	}

	private Object getResultWithContainKey(String containKey) {
		if (!getResults().containsKey(containKey)) {
			throw new FindErrorException(
					this + ":not contain key=" + containKey);
		}
		return this.results.get(containKey);
	}

	public void add(String name, T o) {
		this.results.put(name, o);
	}

	public void add(T o) {
		this.results.put(DEFAULT, o);
	}

	public Object get(String name) {
		Object o = null;
		try {
			o = getResultWithContainKey(name);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

		return o;
	}

	public Object get() {
		Object o = null;

		try {
			o = getResultWithContainKey(DEFAULT);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			try {
				o = getResults().entrySet().stream().findFirst().get();
			} catch (RuntimeException e2) {
				System.out.println(e.getMessage());
			}
		}
		return o;
	}
}
