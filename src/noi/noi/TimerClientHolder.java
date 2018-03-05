package noi.noi;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TimerClientHolder implements Runnable {
    private SocketChannel socketChannel;
    private Selector selector;
    private volatile boolean stop;
    private String host;
    private int port;
    
	public TimerClientHolder(String host, int port) {
		this.host = host;
		this.port = port;
		try {
			selector = Selector.open();
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		try {
			doConnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(!stop){
			try{
				selector.select(1000);
				Set<SelectionKey> selectionKeys = selector.selectedKeys();
				System.out.println("client size:"+selectionKeys.size());
				Iterator<SelectionKey> it = selectionKeys.iterator();
				SelectionKey key = null;
				while(it.hasNext()){
					key = it.next();
					it.remove();
					try{
						handlerInput(key);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		if(selector!=null){
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
    
	private void handlerInput(SelectionKey key) throws IOException {
		if(key.isValid()){
			SocketChannel sc = (SocketChannel) key.channel();
		    if(key.isConnectable()){
		    	if(sc.finishConnect()){
		    		sc.register(selector, SelectionKey.OP_READ);
		    		doWrite(sc);
		    	}
		    }
		    if(key.isReadable()){
		    	ByteBuffer readBuffer = ByteBuffer.allocate(1024);
		    	int readBytes = sc.read(readBuffer);
		    	if(readBytes > 0){
		    		readBuffer.flip();
		    		byte[] bytes = new byte[readBuffer.remaining()];
		    		readBuffer.get(bytes);
		    		String body = new String(bytes,"UTF-8");
		    		System.out.println("Now is"+ body);
		    		this.stop = true;
		    	}else if(readBytes <0){
		    		key.cancel();
		    		sc.close();
		    	}else{
		    		;
		    	}
		    }
		}
		
	}

	private void doWrite(SocketChannel sc) throws IOException {
		byte[] req = "QUERY TIME ORDER".getBytes();
		ByteBuffer wrtieBuffer = ByteBuffer.allocate(req.length);
		wrtieBuffer.put(req);
		wrtieBuffer.flip();
		sc.write(wrtieBuffer);
		if(!wrtieBuffer.hasRemaining()){
			System.out.println("Send order 2 server Succes");
		}
				
	}

	public void stop(){
		stop = true;
	}
	private void doConnect() throws IOException {
		if(socketChannel.connect(new InetSocketAddress(host, port))){
			socketChannel.register(selector, SelectionKey.OP_READ);
		}else{
			socketChannel.register(selector,SelectionKey.OP_CONNECT);
		}
	}

}
