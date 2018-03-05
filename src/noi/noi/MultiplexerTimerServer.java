package noi.noi;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
public class MultiplexerTimerServer implements Runnable{

	private Selector selector;
	private ServerSocketChannel servChannel;
	private volatile boolean stop=false;
	public MultiplexerTimerServer(int port) {
		try{
			selector = Selector.open();
			servChannel = ServerSocketChannel.open();
			servChannel.configureBlocking(false);
			servChannel.socket().bind(new InetSocketAddress(port),1024);
			SelectionKey key = servChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("The time srver is start in port:"+port);
			System.out.println(selector.selectedKeys().size());
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void stop(){
		this.stop = true;
	}

	@Override
	public void run() {
		while(!stop){
			try{
				System.out.println("this:"+this);
				selector.select();
			    Set<SelectionKey> selectionKeys = selector.selectedKeys();
			    System.out.println("size:"+selectionKeys.size());
				Iterator<SelectionKey> it = selectionKeys.iterator();
				SelectionKey key = null;
				while(it.hasNext()){
			    	key = it.next();
			     	it.remove();
			    	try{
			    		handlerInput(key);
			    	}catch(Exception e){
			    		if(key!=null){
			    			key.cancel();
			    		}
			    	}
			    }
			}catch(Throwable t){
				t.printStackTrace();
			}
		}
	}

	private void handlerInput(SelectionKey key) throws IOException {
		if(key.isValid()){
			if(key.isAcceptable()){
				ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
				SocketChannel sc = ssc.accept();
				sc.configureBlocking(false);
				sc.register(selector, SelectionKey.OP_READ);
			}
			if(key.isReadable()){
				SocketChannel sc = (SocketChannel) key.channel();
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				int readBytes = sc.read(readBuffer);
				if(readBytes > 0){
					readBuffer.flip();
					byte[] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String body = new String(bytes,"UTF-8");
					String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)? (new Date(System.currentTimeMillis())).toString():"BAD ORDER";
					doWriter(sc,currentTime);
				}else if(readBytes < 0){
					key.cancel();
					sc.close();
				}else{
					
				}
			}
		}
	}

	private void doWriter(SocketChannel channel, String response) throws IOException {
		if(response !=null&&response.trim().length()>0){
			byte[] bytes = response.getBytes();
			ByteBuffer writerBuffer = ByteBuffer.allocate(bytes.length);
			writerBuffer.put(bytes);
			writerBuffer.flip();
			channel.write(writerBuffer);
		}
	}

}
