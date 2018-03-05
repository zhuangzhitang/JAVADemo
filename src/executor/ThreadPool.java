package executor;
/***
 * 线程池类，线程管理器，创建线程，执行线程，销毁线程，获取线程的基数
 * @author zhuangzhitang-pc
 *
 */

import java.util.LinkedList;
import java.util.List;
public class ThreadPool{
    //默认中线程池的个数为5
	public static int workNum =5;

	private static volatile int finishedTask = 0;
	
	private List<Runnable> taskQueue = new LinkedList<Runnable>();
	
	private static ThreadPool threadPool;
	private WorkdTread[] workdTreads;
	public ThreadPool(){
		this(5);
	}
	//创建线程池，work_num 为线程池中工作线程的个数
	private ThreadPool(int workernum){
		ThreadPool.workNum = workernum;
		workdTreads = new WorkdTread[workernum];
		for(int i = 0 ; i < workernum;i++){
			workdTreads[i] = new WorkdTread();
			new Thread(workdTreads[i]).start();
		}
	}
	
	public static ThreadPool getThreadPool(){
		return getThreadPool();
	}
	
	 // 单态模式，获得一个指定线程个数的线程池,worker_num(>0)为线程池中工作线程的个数  
    // worker_num<=0创建默认的工作线程个数  
    public static ThreadPool getThreadPool(int workernum1) {  
        if (workernum1 <= 0)  
        	workernum1 = ThreadPool.workNum;  
        if (threadPool == null)  
            threadPool = new ThreadPool(workernum1);  
        return threadPool;  
    }  
	
    public void executor(Runnable task){
    	synchronized (taskQueue) {
			taskQueue.add(task);
			taskQueue.notify();
		}
    }
    
    public void execute(Runnable[] task){
    	synchronized (taskQueue) {
		     for (int i = 0; i < task.length; i++) {
				taskQueue.add(task[i]);
			 }	
		     taskQueue.notify();
		}
    }
    
    public void executor(List<Runnable> task){
    	synchronized (taskQueue) {
			for(Runnable t:task){
				taskQueue.add(t);
			}
			taskQueue.notify();
		}
    }
    
    public void destory(){
    	while(!taskQueue.isEmpty()){
    		try{
    	       Thread.sleep(10);
    		}catch(InterruptedException e){
    			e.printStackTrace();
    		}
    	}
    	for(int i=0;i< workNum; i++){
    		workdTreads[i].stopWorker();
    		workdTreads[i]=null;
    	}
    	threadPool = null;
    	taskQueue.clear();
    }
    /**
     * 工作线程的个数
     * @return
     */
    public int getWorkTreadNumber(){
    	return workNum;
    	
    }
    // 返回任务队列的长度，即还没处理的任务个数  
    public int getWaitTasknumber() {  
        return taskQueue.size();  
    }  
    // 覆盖toString方法，返回线程池信息：工作线程个数和已完成任务个数  
    @Override  
    public String toString() {  
        return "WorkThread number:" + workNum + "  finished task number:"  
                + finishedTask + "  wait task number:" + getWaitTasknumber();  
    }  
	private  class WorkdTread implements Runnable{
		private boolean isRunning = true;
		
		public void run() {
			Runnable r = null;
			while(isRunning){
				synchronized (taskQueue) {
				      while(isRunning&& taskQueue.isEmpty()){
				    	  try {
							taskQueue.wait(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				      }
				      if(!taskQueue.isEmpty()){
				    	  r = taskQueue.remove(0);
				      }
				}
				if(r !=null){
					r.run();
				}
				finishedTask++;
				r = null;
			}
		}
		
		public void stopWorker(){
			isRunning = true;
		}
	}
}
