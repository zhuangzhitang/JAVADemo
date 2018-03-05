package designerpattern.decorator;

public class ConcreteDecoreatorB extends Decorator{

	@Override
	public void operation() {
		super.operation();
		addAction();
		
	}
	public void addAction(){
		System.out.println("add Action");
	}
	

}
