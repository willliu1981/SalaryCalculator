package test.test2;

public class Test2 {

	Car car=new Car();

	public static void main(String[] args) {
		Test2 t = new Test2();
		t.car.name="y";
		System.out.println(t.car.name);
		System.out.println(t.car.hashCode());
		t.m(t);
		System.out.println(t.car.name);
		System.out.println(t.car.hashCode());
		
	}
	
	void m(Test2 t) {
		t.car=new Car();
		t.car.name="xx1";
		System.out.println("m: "+t.car.hashCode());
	}

}
