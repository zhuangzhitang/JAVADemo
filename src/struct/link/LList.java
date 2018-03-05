package struct.link;
/**
 * 线性表的定义
 * @author zhuangzhitang-pc
 *
 */
public interface LList<T> {
	/**
	 * 判断是否为空
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * 线性表的长度
	 * @return
	 */
	public int length();
	

	/**
	 * 返回第i个元素
	 * @param i
	 * @return
	 */
	public T get(int i);
	
	/**
	 * 设置第i个元素的值为x
	 * @param i
	 * @param x
	 */
	public void set(int i,T x);
	
	/**
	 * 插入x到i位置
	 * @param i
	 * @param x
	 */
	public void insert(int i,T x);
	
	/**
	 * 在线性表中追加x元素
	 */
	public void append(T x);
    /**
     *查找，返回首次出现的关键字为key元素
     */
	public int search(T x);
	
	/**
	 * 删除线性表中的i的值，并返回
	 * @param i
	 * @return
	 */
	public T remove(int i);
	
	/**
	 * 清空线性表
	 */
	public void removeAll();
	
}
