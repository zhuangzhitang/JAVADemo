package designerpattern.obervers;

public class Test {
   public static void main(String[] args) {
	WeatherObserverAble weatherObserverAble = new WeatherObserverAble();
    //创建三个不同的观察者
    Observer customerA = new Customer("A");
    Observer customerB = new Customer("B");
    Observer customerC = new Customer("C");
    
    weatherObserverAble.registerObserver(customerA);
    weatherObserverAble.registerObserver(customerB);
    weatherObserverAble.registerObserver(customerC);
    
    weatherObserverAble.setWheather("冷");
    
   
}
}
