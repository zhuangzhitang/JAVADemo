package proxy;

public class RealSubject implements Subject {

	@Override
	public void buyTicket() {
		System.out.println("------byTicket--------");
	}

}
