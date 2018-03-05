package designerpattern.even;

import java.util.EventObject;
/**
 *  事件类,用于封装事件源及一些与事件相关的参数. 
 * @author zhuangzhitang-pc
 *
 */
public class CustEvent extends EventObject {
	
	private Object source ;

	public CustEvent(Object obj) {
		super(obj);
		this.source = obj;
	}

	public Object getSource() {
		return source;
	}

	public void setSource(Object source) {
		this.source = source;
	}
    
}
