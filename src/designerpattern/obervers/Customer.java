package designerpattern.obervers;

public class Customer implements Observer {
	private String name;

	public Customer() {
		// TODO Auto-generated constructor stub
	}
    public Customer(String name) {
		this.name = name;
	}
	@Override
	public void update(String weather) {
      System.out.println(this.name+"：你好，天气："+weather);   		
	}

}
