package test.test18;

public class Publisher {
String name;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@Override
public String toString() {
	return "Publisher [name=" + name + "]";
}

}
