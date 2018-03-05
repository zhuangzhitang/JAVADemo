package base;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public abstract class DataOnly {
	private int a;
	private double b;
	private boolean c;
	private static int d=8;
	static{
		System.out.println(d);
	}
	public DataOnly(){
		System.out.println(this.a);
	}
	public static void main(String[] args) {
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
		for(ThreadInfo info :threadInfos){
			System.out.println(info.getThreadId()+":"+ info.getThreadName());
		}
	}

}
