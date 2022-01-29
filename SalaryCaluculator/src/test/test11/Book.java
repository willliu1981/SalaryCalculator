package test.test11;

import java.util.ArrayList;
import java.util.List;

import com.v4.listener.Dispatchable;
import com.v4.listener.Dispatcher;
import com.v4.model.Result;

public class Book implements Dispatchable<MyResult> {

	List<Dispatcher<MyResult>> disps = new ArrayList<>();

	@Override
	public void addDispatcher(Dispatcher<MyResult> dispatcher) {
		this.getDispatchers().add(dispatcher);

	}

	@Override
	public List<Dispatcher<MyResult>> getDispatchers() {
		return this.disps;
	}
	
	public void m(String name) {
		this.updateDispatcher(new User(name));
	}

}
