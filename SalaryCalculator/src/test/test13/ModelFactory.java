package test.test13;

import java.util.ArrayList;
import java.util.List;

public class ModelFactory {
	static List<User> users = new ArrayList<>();
	static User tempUser = null;

	public static void add(User u) {
		users.add(u);
	}

	public static void creatNewModel() {
		tempUser = new User();
	}

	public static void creatingModel(String str, String value) {

		switch (str) {
		case "id":
			tempUser.setId(value);
			break;
		case "fn":
			tempUser.setFname(value);
			break;
		case "ln":
			tempUser.setLname(value);
			break;
		case "nn":
			tempUser.setNname(value);
			break;
		case "mk":
			tempUser.setMark(value);
			break;
		}

	}

	public static void creatFinishModel() {
		users.add(tempUser);
	}

}
