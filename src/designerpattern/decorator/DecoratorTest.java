package designerpattern.decorator;

public class DecoratorTest {
   public static void main(String[] args) {
	ConcreteComponent c = new ConcreteComponent();
	ConcreteDecoratorA a = new ConcreteDecoratorA();
	ConcreteDecoreatorB b = new ConcreteDecoreatorB();
	a.setComponent(c);
	b.setComponent(a);
	b.operation();
  }
}
