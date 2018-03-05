package designerpattern.even;

public class MainTest {

	/** 
     * @param args 
     */  
    public static void main(String[] args) {  
        EventSourceObject object = new EventSourceObject();  
        //注册监听器  
        object.addCusListener(new CustEvenListener(){  
            @Override  
            public void fireCusEvent(CustEvent e) {  
                super.fireCusEvent(e);  
            }  
        });  
        //触发事件  
        object.setName("eric");  
    }  
}
