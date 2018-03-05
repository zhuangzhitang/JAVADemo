package virtual.memoryover;

public class StackOverByConcurrent {
   public void createThread(){
	   while(true){
		   Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					
				}
			}
		   });
		   thread.start();
	   }
   }
   public static void main(String[] args) {
	   StackOverByConcurrent obj = new StackOverByConcurrent();
		obj.createThread();	   
   }
}
