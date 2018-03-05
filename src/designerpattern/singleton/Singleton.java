package designerpattern.singleton;
/**
 * 第一种（懒汉，线程不安全）：
 * @author zhuangzhitang-pc
 *
 */
public class Singleton {
  private static Singleton sing=null;
  private Singleton(){
	  
  }
  
  public static synchronized Singleton getInstance(){
	  if(sing ==null){
		  sing = new Singleton();
	  }
	  return sing;
  }
  
}
