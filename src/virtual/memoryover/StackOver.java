package virtual.memoryover;

public class StackOver {
	private int stackLength = 1;
	public void reCall(){
		stackLength++;
		reCall();
	}
    public static void main(String[] args) {
		StackOver obj = new StackOver();
		try{
			obj.reCall();
		}catch(Throwable e){
			System.out.println("stack length:"+obj.stackLength);
			throw e;
		}
	}
}
