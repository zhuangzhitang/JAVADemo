package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {
	
	private Object object;
	public JdkProxy(Object object) {
		this.object  = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("-----执行前");
		method.invoke(object, args);
		System.out.println("-----执行hou");
		return null;
	}
    
	public Object getProxy(){
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
	}
}
