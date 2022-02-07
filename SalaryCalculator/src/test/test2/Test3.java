package test.test2;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class Test3 {

	abstract class  A{
	abstract	B get();
	}
	
	class A1 extends A{

		@Override
		B get() {
			// TODO Auto-generated method stub
			return new B1();
		}
		
	}
	
	class A2 extends A{

		@Override
		B get() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	class B{
		
	}
	
	class B1 extends B{
		
	}
	
	class B2 extends B{
		
	}
	
	public static void main(String[] args) {
		JDialog da=new JDialog();
		JPanel p=new JPanel();
		p=null;
	da.getContentPane().add(p);
		
		
	}

}
