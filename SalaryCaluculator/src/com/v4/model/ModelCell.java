package com.v4.model;

public class ModelCell {
	private String name;

	public ModelCell() {
	}

	public ModelCell(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return this.name;
	}
}
