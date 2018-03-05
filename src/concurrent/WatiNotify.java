package concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WatiNotify {
	static boolean flag = true;
	static Object lock = new Object();
	public static void main(String[] args) throws Exception {
		Thread waitThread = new Thread(new Wait(), "WaitThread");
		waitThread.start();
		Thread.currentThread().sleep(1000);
		Thread notifyThread = new Thread(new Notify(), "NotifyThread");
		notifyThread.start();
		System.out.println("--------");
	}
    
	static class Wait implements Runnable{

		@Override
		public void run() {
			synchronized (lock) {
				while(flag){
					try{
						System.out.println(
								Thread.currentThread()+"flag is "
										+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
						lock.wait();
					}catch(InterruptedException e){
						
					}
				}
			}
		}
		
	}
	
	static class Notify implements Runnable{

		@Override
		public void run() {
			synchronized (lock) {
				System.out.println(Thread.currentThread() + " hold lock. notify @ " +
						new SimpleDateFormat("HH:mm:ss").format(new Date()));
						lock.notifyAll();
						flag = false;
					   try {
						Thread.currentThread().sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
			// 再次加锁
			synchronized (lock) {
			System.out.println(Thread.currentThread() + " hold lock again. sleep@ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
			  try {
					Thread.currentThread().sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
