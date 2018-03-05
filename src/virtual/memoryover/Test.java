package virtual.memoryover;

import java.util.ArrayList;
import java.util.List;

public class Test {
	static class OOmObject{
		public byte[] placehold = new byte[64*1024];
	}
    public static void fillHeap(int num) throws Exception{
    	List<OOmObject> list = new ArrayList<OOmObject>();
    	for(int i = 0 ; i < num;i++){
    		Thread.sleep(50);
    		list.add(new OOmObject());
    	}
    	System.gc();
    }
    
    public static void main(String[] args) throws Exception {
		fillHeap(1000);
	}
}
