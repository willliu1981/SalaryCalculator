package test.test14;

public class Test14CreatorDemo {

	static class A {
		String name;
		B b;

		A(String name) {
			this.name = name;
		}

		void setB(B b) {
			this.b = b;
		}

		@Override
		public String toString() {
			return "A [name=" + name + ", b=" + b + "]";
		}

	}

	static class B {
		String name;

		B(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "B [name=" + name + "]";
		}

	}

	static class ACreator {

		A a;

		ACreator creatA(String aName) {
			a = new A(aName);
			return this;
		}

		ACreator setB(B b) {
			a.setB(b);
			return this;
		}

		A getA() {
			return a;
		}
	}

	public static void main(String[] args) {
		B b = new B("bb");
		ACreator aCreator = new ACreator();
		A a = aCreator.creatA("aa").setB(b).getA();

		System.out.println(a);
	}

}
