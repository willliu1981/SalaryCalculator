package test.test7;

public class TestDemo {

	public static void main(String[] args) {

		//*
		MyBook book = new MyBook();
		book.m();
		
		System.out.println("========================");
		AbsAuthority absAuthority = new AbsAuthority();
		absAuthority.m();
		
		System.out.println("========================");
		AbsAuthority authority1 = new MyAuthority();
		authority1.m();

		System.out.println("========================");
		AbsAuthority authority2 = new SubMyAuthority();
		authority2.m();

		//*/

		/*
		System.out.println("user1:");
		User user1 = new User();
		user1.m();

		System.out.println();
		System.out.println("user2:");
		User user2 = new User() {
			String name="x2";
			
		};
		user2.m();
		
		System.out.println(user1.getSuperName());
		System.out.println(user2.getSuperName());
		//*/
	}

}
