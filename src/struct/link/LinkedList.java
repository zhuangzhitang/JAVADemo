package struct.link;
/**
 * 实现栈
 * @author zhuangzhitang-pc
 *
 */
public class LinkedList  {
     private class Data{
    	 private Object obj;
    	 private Data next = null;
    	 public Data(Object obj) {
			this.obj = obj;
		}
     }
     
     private Data head =null;
     
     public void insertFirst(Object obj){
    	 Data data = new Data(obj);
    	 data.next = head;
    	 head = data;
     }
     
     public Object deleteFirst() throws Exception{
    	 if(head ==null){
    		 throw new Exception("empty!");
    	 }
    	 Data temp = head;
    	 head = temp.next;
    	 return temp.obj;
     }
     
     public Object find(Object obj){
    	 if(head ==null){
    		 return new Exception("empty");
    	 }
    	 Data cur = head;
    	 while (cur !=null){
    		 if(cur.obj.equals(obj)){
    			 return cur.obj;
    		 }
    		 cur = cur.next;
    	 }
    	 
    	 return null;
     }
     
     public void remove(Object obj) throws Exception{
    	 if(head == null)  
             throw new Exception("LinkedList is empty!"); 
    	 
    	 if(head.obj.equals(obj)){
    		 head = head.next;
    	 }else{
    		 Data pre = head;
    		 Data cur =  head.next;
             while(cur != null){  
               if(cur.obj.equals(obj)){  
                   pre.next = cur.next;  
               }  
               pre = cur;  
               cur = cur.next;  
            }  
    	 }
     }
     
     public boolean isEmpty(){
    	 return (head==null);
     }
     
     public void display(){
    	 if(head == null){
    		 System.out.println("empty");
    	 }
    	 
    	 Data cur = head;
    	 while(cur !=null){
    		 System.out.print(cur.obj.toString()+"->");
    		 cur = cur.next;
    	 }
    	 System.out.println("");
     }
     public static void main(String[] args) throws Exception {  
         LinkedList ll = new LinkedList();  
         ll.insertFirst(4);  
         ll.insertFirst(3);  
         ll.insertFirst(2);  
         ll.insertFirst(1);  
         ll.display();  
         ll.deleteFirst();  
         ll.display();  
         ll.remove(3);  
         ll.display();  
         System.out.println(ll.find(1));  
         System.out.println(ll.find(4));  
     }  
}
