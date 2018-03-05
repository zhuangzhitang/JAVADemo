package noi.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.concurrent.SynchronousQueue;

/**
 * 时间同步器
 * 增加线程池和消息队列，实现N个线程处理M个请求
 * @author zhuangzhitang-pc
 *
 */
public class TimerServiceWithPool {
	public static void main(String[] args) throws IOException {
		
		//创建socket,绑定相应的端口
		ServerSocket server = new ServerSocket(8080);
		System.out.println("the time server start in port:"+8080);
		Socket socket =null;
		TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50,10000);
		try{
			while(true){
				socket = server.accept();
				/*new Thread(new TimerServiceHolder(socket)).start();*/
				singleExecutor.exceute(new TimerServiceHolder(socket));
			}
		}finally{
			if(server !=null){
				System.out.println("The time server close");
				server.close();
				server = null;
			}
		}
		
	}
}
