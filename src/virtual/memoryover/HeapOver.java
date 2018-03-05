package virtual.memoryover;

import java.util.ArrayList;
import java.util.List;

public class HeapOver {
	
	private int[] obj =new int[1024*1024];
	
	public static void main(String[] args) {
		List<HeapOver> containers = new ArrayList<HeapOver>();
		int i = 0 ;
		while(true){
			containers.add(new HeapOver());
			System.out.println(i++);
		}
	}

}
