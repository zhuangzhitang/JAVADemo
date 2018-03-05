package noi.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.SynchronousQueue;

public class TimerClient {
   public static void main(String[] args) {
	   try {
		Socket socket = new Socket("localhost", 8080);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		out.println("QUERY TIME ORDER");
		System.out.println("Send order");
		String resp = in.readLine();
		System.out.println("Now is "+resp);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		
	}
	   
   }
}
