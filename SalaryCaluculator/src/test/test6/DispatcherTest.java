package test.test6;

import java.util.ArrayList;
import java.util.List;

import com.v4.listener.Dispatchable;
import com.v4.listener.Dispatcher;
import com.v4.model.Result;



public class DispatcherTest {

	static class BookStore {

		public void buyBook(String name) {
			BookOrder order = new BookOrder();
			order.addDispatcher(new Dispatcher<Result>() {

				@Override
				public void receive(Object o) {
					System.out.println("order: " + o);
				}

				@Override
				public void receive(Result o) {
					System.out.println("order(result): " + o);
				}

			});

			order.order(name);

		}

	}

	static class BookOrder implements Dispatchable<Result> {
		List<Dispatcher<Result>> disps = new ArrayList<>();

		@Override
		public void addDispatcher(Dispatcher<Result> dispatcher) {
			this.disps.add(dispatcher);
		}

		@Override
		public List<Dispatcher<Result>> getDispatchers() {
			return this.disps;
		}

		public void order(String name) {
			this.updateDispatcher(name);
		}

	}

	public static void main(String[] args) {
		BookStore b = new BookStore();
		b.buyBook("Java");

	

	}

}
