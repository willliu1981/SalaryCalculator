package test.test14;

public class Test14CreatorDemo2 {

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

	static class AFactory {
		A getA(String name) {
			return new A(name);
		}
	}

	static class BFactory {
		B getB(String name) {
			return new B(name);
		}
	}

	static class ACreator {
		AFactory aF;
		BFactory bF;

		A a;

		ACreator(AFactory aF, BFactory bF) {
			this.aF = aF;
			this.bF = bF;
		}

		ACreator creatA(String aName) {
			a = aF.getA(aName);
			return this;
		}

		ACreator setB(String bName) {
			a.setB(bF.getB(bName));
			return this;
		}

		A getA() {
			return a;
		}
	}

	public static void main(String[] args) {

		ACreator aCreator = new ACreator(new AFactory(), new BFactory());
		A a = aCreator.creatA("aa").setB("bb").getA();

		System.out.println(a);
	}

}
