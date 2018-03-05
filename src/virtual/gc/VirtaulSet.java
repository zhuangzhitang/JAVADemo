package virtual.gc;
/**
 * 查看虚拟机的参数
 * @author zhuangzhitang-pc
 *
 */
public class VirtaulSet {
  public static void main(String[] args) {
	System.out.println(Runtime.getRuntime().maxMemory());
	System.out.println(Runtime.getRuntime().freeMemory());
	System.out.println(Runtime.getRuntime().totalMemory());
	
}
}
