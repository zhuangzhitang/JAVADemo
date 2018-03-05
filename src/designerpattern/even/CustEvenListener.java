package designerpattern.even;

import java.util.EventListener;

public class CustEvenListener implements EventListener {

	//事件发生后的回调方法  
    public void fireCusEvent(CustEvent e){  
        EventSourceObject eObject = (EventSourceObject)e.getSource();  
        System.out.println("My name has been changed!");  
        System.out.println("I got a new name,named \""+eObject.getName()+"\"");  
    }  
}
