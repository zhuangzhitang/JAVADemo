package designerpattern.stragetegy;

public class StrategyTest {
	public static void main(String[] args) {
		Context context = new Context("A");
		double a = context.contextInface(12);
		System.out.println(a);
	}
}
