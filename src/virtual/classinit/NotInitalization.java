package virtual.classinit;

public class NotInitalization {
	static{
		System.out.println("123111");
	}
	public static void main(String[] args) {
		//System.out.println(SubClass.value);
		SuperClass[] sca = new SuperClass[10];
		System.out.println(ConstClass.HELLOWORLD);
	}
}
