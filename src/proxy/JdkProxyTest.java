package proxy;

public class JdkProxyTest {
	
	public static void main(String[] args) {
		JdkServiceImpl serviceImpl = new JdkServiceImpl();
		JdkProxy handler = new JdkProxy(serviceImpl);
		JdkService service = (JdkService) handler.getProxy();
		service.say();
	    
		
	}

}
