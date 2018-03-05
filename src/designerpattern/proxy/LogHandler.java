package designerpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {
	
	Object obj;
	public LogHandler(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object obj1, Method method, Object[] aobj) throws Throwable {
		this.doBefore();
		Object o = method.invoke(obj, aobj);
		this.doAfter();
		return o;
	}

	public  void doBefore() {
		System.out.println("do this before");
	}
	
	public void doAfter(){
		System.out.println("do this after");
	}
	

}
