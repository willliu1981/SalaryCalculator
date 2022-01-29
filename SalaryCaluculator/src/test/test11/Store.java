package test.test11;

import com.v4.listener.Dispatcher;
import com.v4.model.Result;

public class Store {
	Book b = null;

	public Store(Book b) {
		this.b = b;
		b.addDispatcher(new Dispatcher() {

			@Override
			public void receive(Object o) {
				System.out.println(o);
			}

			@Override
			public void receive(Result o) {
				System.out.println(o);
			}

		
			
			

		});

	}

	public void m(String name) {
		b.m(name);
	}
}
