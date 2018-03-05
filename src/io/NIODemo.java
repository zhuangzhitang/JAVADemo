package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

public  class NIODemo {
	
	public static void method2(){
		 InputStream in = null;
		 try{
			 in = new BufferedInputStream(new FileInputStream("c://text.txt"));
			 byte[] buffer = new byte[1024];
			 int index = in.read(buffer);
			 StringBuffer buffer2 = new StringBuffer();
			 while (index !=-1) {
				buffer2.append(buffer.toString());
				index = in.read(buffer);
			}
			 System.out.println(buffer2.toString());
		 }catch(IOException e){
			 e.printStackTrace();
		 }finally {
			try{
				if(in !=null){
					in.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		 }
	}
	
	public static void method1(){
	//	NIODemo demo = new NIODemo() ;
		
        RandomAccessFile aFile = null;
        try{
            aFile = new RandomAccessFile("c://text.txt","rw");
            FileChannel fileChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
 
            int bytesRead = fileChannel.read(buf);
            System.out.println(bytesRead);
 
            while(bytesRead != -1)
            {
                buf.flip();
                while(buf.hasRemaining())
                {
                    System.out.print((char)buf.get());
                }
 
                buf.compact();
                bytesRead = fileChannel.read(buf);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(aFile != null){
                    aFile.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
	public static void main(String[] args) throws Exception {

        IntBuffer buffer = IntBuffer.allocate(10);
        
        for(int i = 0 ; i < buffer.capacity();i++){
        	int j = 2*(i+1);
        	buffer.put(j);
        }
        buffer.flip();
        while(buffer.hasRemaining()){
        	int j = buffer.get();
        	System.out.println(j+" ");
        }
	}

}
