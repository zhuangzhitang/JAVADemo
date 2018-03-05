package virtual.gc;

public class ReferenceCountingGC {
    public Object instance = null;
    private static final int MB = 1024*1024;
    
    private byte[] bigSize = new byte[2*MB];
    
    public static void main(String[] args) {
    	ReferenceCountingGC objA = new ReferenceCountingGC();
    	ReferenceCountingGC objB = new ReferenceCountingGC();
    	objA.instance = objB;
    	objB.instance = objA;
    	
    	objA = null;
    	objB = null;
    	
    	System.gc();
    	System.out.println("--");
	}
}
