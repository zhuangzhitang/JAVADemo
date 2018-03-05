package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
* @ClassName: JdkProxy1 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author (TangGoooo)  
* @date 2018年2月24日 下午4:20:39 
* @version V1.0
 */
public class JdkProxy1  implements InvocationHandler{
	
	private Object subject;
	
    public JdkProxy1(Object subject) {
		this.subject = subject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("--统一处理前--");
		Object result = method.invoke(subject, args);
		System.out.println("---统一处理后-----");
		return result;
	}
	
	public Object getProxy(){
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		return Proxy.newProxyInstance(loader, subject.getClass().getInterfaces(),this);
	}
	
	public static void main(String[] args) {
		RealSubject subject = new RealSubject();
		JdkProxy1 proxy1 = new JdkProxy1(subject);
	    Subject subject1 = (Subject) proxy1.getProxy();
	    subject1.buyTicket();
	    Integer a = new Integer(1);
	    int b = 1;
	    System.out.println(a==b);
	}

}
