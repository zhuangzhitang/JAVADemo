package designerpattern.singleton;

/**
 *双重校验锁
 */
public class Singleton4  {
   private volatile  static Singleton4 instance = null;
   
   private Singleton4(){}
   
   public static Singleton4 getInstance(){
	   if(instance == null){
		   synchronized (Singleton4.class) {
			   if (instance == null) {  
				   instance = new Singleton4();  
               }  
		   }
	   }
	   return instance;
   }
   public static void main(String[] args) throws Exception {
	   System.out.println("hello world");
   }
}
