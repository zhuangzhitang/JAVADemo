package struct;
/**
 *使用数组模拟栈
 * @author zhuangzhitang-pc
 *
 */
public class StackX {
   private char[] stackArray;
   private int maxSize;
   private int top;
   
   public StackX(int s){
	   maxSize = s;
	   stackArray = new char[maxSize];
	   top= -1;
   }
   
   public void push(char value){
	   stackArray[++top] = value;
   }
   public char pop(){
	   return stackArray[top--];
   }
   
   public char peek(){
	   return stackArray[top];
   }
   
   public boolean isEmpty(){
	   return top==-1;
   }
   
   public boolean isFull(){
	   return top==maxSize-1;
   }
}
