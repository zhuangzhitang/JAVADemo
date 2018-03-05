package noi.noi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 时间同步器  noi实现
 * @author zhuangzhitang-pc
 *
 */
public class TimerService {
	public static void main(String[] args) throws IOException {
		
		//
		int port = 8080;
		MultiplexerTimerServer timeServer = new MultiplexerTimerServer(port);
		System.out.println(timeServer);
		new Thread(timeServer,"noi_mutilpleexerTimer-001").start();
	}
}
