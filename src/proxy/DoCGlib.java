package proxy;

import net.sf.cglib.core.DebuggingClassWriter;

public class DoCGlib {
	
	public static void main(String[] args) {
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "c:\\\\code");
		CglibProxy proxy = new CglibProxy();
		SayHello proxyImp = (SayHello) proxy.getProxy(SayHello.class);
		proxyImp.say();
		
	}

}
