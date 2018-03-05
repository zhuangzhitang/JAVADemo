package executor;

public class TestThreadPool {
	public static void main(String[] args) {
		// 创建3个线程的线程池
		/*
		 * ThreadPool t = ThreadPool.getThreadPool(3); t.execute(new Runnable[]
		 * { new Task(), new Task(), new Task() }); t.execute(new Runnable[] {
		 * new Task(), new Task(), new Task() }); System.out.println(t);
		 * t.destory();// 所有线程都执行完成才destory System.out.println(t);
		 */

		String a = "aa";
	    String b = "bb";
	    String c = "xx" + "yy " + a + "zz" + "mm" + b;
	    System.out.println("===========test13============");
	    System.out.println(c);
	}

	// 任务类
	static class Task implements Runnable {
		private static volatile int i = 1;

		@Override
		public void run() {// 执行任务
			System.out.println("任务 " + (i++) + " 完成");
		}
	}	
}
