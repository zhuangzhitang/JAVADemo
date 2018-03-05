package concurrent;

public class ConcurrentTest {
	
	private static final long count = 100000000L;
	
	public static void main(String[] args) throws InterruptedException {
		concurrency();
		serical();
	}

	private static void serical() {
		   long start = System.currentTimeMillis();
		   int a = 0 ;
		   for(long i = 0 ; i<count;i++){
			   a+=5;
		   }
		   int b = 0 ;
		   for(int i = 0 ; i <count;i++){
			   b--;
		   }
		   long time = System.currentTimeMillis()-start;
		   System.out.println("concurrency:"+time+"ms,b="+b+",a="+a);
		
	}

	private static void concurrency() throws InterruptedException {
	   long start = System.currentTimeMillis();
	   
	   Thread thread = new Thread(new Runnable() {
		
			@Override
			public void run() {
				int a = 0;
				for(long i = 0;i<count ;i ++){
					a+=5;
				}
				
			}
	   });
	   thread.start();
	   int b = 0 ;
	   for(int i = 0 ; i <count;i++){
		   b--;
	   }
	   long time = System.currentTimeMillis()-start;
	   thread.join();
	   System.out.println("concurrency:"+time+"ms,b="+b);
	}

}
