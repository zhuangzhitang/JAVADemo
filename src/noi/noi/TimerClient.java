package noi.noi;

public class TimerClient {
   public static void main(String[] args) {
	    int port = 8080;
        new Thread(new TimerClientHolder("localhost",port)).start(); 
   }
}
