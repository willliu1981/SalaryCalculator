package com.v4.model;

public abstract class AbsModelCell<K, V> {
	private String name;
	private K key;
	private V value;

	public AbsModelCell() {
	}

	public AbsModelCell(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public String toString() {
		return this.name;
	}
}
