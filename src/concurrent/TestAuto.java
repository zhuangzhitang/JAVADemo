package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAuto {
	
	public static void main(String[] args) throws InterruptedException {
		Count count = new Count();
		Thread a = new Thread(new Client(count));
		Thread b =new Thread(new Client(count));
	    a.start();
	    b.start();
	    a.join();
	    b.join();
		System.out.println(count.getNum());
	}

	static class Count{
		private AtomicInteger num =new AtomicInteger(0);
		private int b = 0;
		public void add(){
			num.incrementAndGet();
		}
		public int getNum(){
			return num.get();
		}
		
		public int getB(){
			return b;
		}
	}
	
	static class Client implements Runnable{
		private Count count ;
        public Client(Count count){
        	this.count = count;
        }
		@Override
		public void run() {
			for(int i=0; i < 10000;i++){
				count.add();
			}
			System.out.println(count.getNum());
		}
		
	}
}
