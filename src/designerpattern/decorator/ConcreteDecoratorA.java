package designerpattern.decorator;

public class ConcreteDecoratorA extends Decorator{
	
	private String addedState;

	@Override
	public void operation() {
		// TODO Auto-generated method stub
		super.operation();
		addedState = "add state";
		System.out.println(addedState);
	}
	

}
