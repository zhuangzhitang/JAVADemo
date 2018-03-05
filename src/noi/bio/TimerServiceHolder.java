package noi.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class TimerServiceHolder implements Runnable {
	private Socket socket;

	public TimerServiceHolder(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
		    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(),true);
			String body = null;
			String currentTime = null;
			while(true){
				body = reader.readLine();
				if(body ==null){
					break;
				}
				System.out.println("The time server receive order:"+body);
				currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)? (new Date(System.currentTimeMillis())).toString():"BAD ORDER";
				writer.println(currentTime);
			}
			
		}catch(Exception e){
			if(reader !=null){
				try {
					reader.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			if(writer !=null){
				writer.close();
			}
			if(this.socket!=null){
				try {
					this.socket.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

}
