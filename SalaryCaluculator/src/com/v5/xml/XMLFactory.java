package com.v5.xml;

import java.util.HashMap;
import java.util.Map;

import com.v5.exception.FindErrorException;

public class XMLFactory {
	public static final String ID = "id";
	public static final String CLASS = "class";

	private static Map<String, XMLClass> classes = new HashMap<>();
	private static XMLClass tempClass;
	private static String tempName;

	public static void creatNew(String name) {
		tempName = name;
		tempClass = new XMLClass();
	}

	public static void creating(String name, String value) {
		switch (name) {
		case "id":
			tempClass.setId(value);
			break;
		case "class":
			tempClass.setClassName(value);
			break;
		default:
			break;
		}
	}

	public static void creatFinish() {
		classes.put(tempName, tempClass);
	}

	public static Object getXMLClassInstance(String name) {
		String className = classes.entrySet().stream()
				.filter(x -> x.getKey().equalsIgnoreCase(name)).findFirst()
				.orElseThrow(FindErrorException::new).getValue().getClassName();
		Object o = null;
		try {
			Class<?> clazz = Class.forName(className);
			o = clazz.newInstance();
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			e.printStackTrace();
		}

		return o;
	}

	public static void print() {
		classes.forEach((x, y) -> System.out.println("  " + y.getClassName()));
	}
}
