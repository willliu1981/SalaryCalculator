package test.test11;

public class User {
	String name;

	public User(String name) {
		this.name = name;
	}

	public String toString() {
		return name + " , " + this.getClass();
	}
}
