package designerpattern.proxy;

import java.lang.reflect.Proxy;

public class TestProxy {
  public static void main(String[] args) {
	
	   Calculator calculator = new CalculatorImpl();
	   LogHandler logHandler = new LogHandler(calculator);
	   Calculator proxy = (Calculator) Proxy.newProxyInstance(calculator.getClass().getClassLoader(), calculator.getClass().getInterfaces(), logHandler);
       proxy.add(1, 2);
   }
}
