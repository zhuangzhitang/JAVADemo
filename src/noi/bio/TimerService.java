package noi.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 时间同步器
 * @author zhuangzhitang-pc
 *
 */
public class TimerService {
	public static void main(String[] args) throws IOException {
		
		//创建socket,绑定相应的端口
		ServerSocket server = new ServerSocket(8080);
		System.out.println("the time server start in port:"+8080);
		Socket socket =null;
		try{
			while(true){
				socket = server.accept();
				new Thread(new TimerServiceHolder(socket)).start();
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
