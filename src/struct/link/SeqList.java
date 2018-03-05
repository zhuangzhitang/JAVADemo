package struct.link;
/**
 * 顺序表（线性表中的顺序存储结构）
 * @author zhuangzhitang-pc
 *
 * @param <T>
 */
public class SeqList<T> implements LList<T> {
	private  Object[] element;
    private int len;
    
    public SeqList() {
		this(64);
	}
    
    public SeqList(int size){
    	this.element = new Object[size];
    	this.len = 0;
    }
	@Override
	public boolean isEmpty() {
		return this.len==0;
	}

	@Override
	public int length() {
		
		return this.len;
	}

	@SuppressWarnings("unchecked")
	public T get(int i) {
		if(i>=0&&i<this.len)
		{
		  return (T) element[i];
		}
		return null;
	}

	/**
	 * 设置第i（≥0）个元素值为x。若i<0或大于表长则抛出序号越界异常；若x==null，不操作
	 * @param i
	 * @param x
	 */
	@Override
	public void set(int i, T x) {
		if(x == null){
			return ;
		}
		if(i>=0&&i<this.len){
			this.element[i] = x;
		}else{
			throw new IndexOutOfBoundsException(i + ""); // 抛出序号越界异常
		}
	}

	@Override
	public void insert(int i, T x) {
		if(x == null)
			return ;
		// 若数组满，则扩充顺序表容量
		if(this.len == this.element.length){
			Object[] temp = this.element;
			this.element = new Object[temp.length*2];
			// 重新申请一个容量更大的数组
			for(int j=0; j < temp.length;j++){
				this.element[j] = temp[j];
			}
		}
		
		if(i<0)
		{
			i=0;
		}
		
		if(i>this.len){
			i = this.len;
		}
		for(int j = this.len -1 ;j>=i;j--){
			this.element[j+1]=this.element[j];
		}
		this.element[i] = x;
		this.len++;
	}

	@Override
	public void append(T x) {
		insert(this.len,x);
	}

	

	@Override
	public T remove(int i) {
		if(this.len ==0||i<0||i>=this.len){
			return null;
		}
		T old = (T) this.element[i];
		for(int j=i;j<this.len-1;j++){
			this.element[j]=this.element[j+1];
		}
		this.element[this.len -1]=null;
		this.len--;
		return old;
	}

	@Override
	public void removeAll() {
		this.len=0;
	}

	@Override
	public int search(T key) {
		 int find = this.indexOf(key);
	     return find;
	}
	
    /**
     * 顺序查找关键字为key元素，返回首次出现的元素，若查找不成功返回-1
     * @param key
     * @return
     */
	public int indexOf(T key){
		if(key !=null){
			for(int i = 0 ; i < this.len ; i++){
				if(this.get(i).equals(key)){
					return i;
				}
			}
		}
		
		return -1;
	}
	
	 /**
     * 顺序表比较相等 比较两个顺序表是否相等 ，覆盖Object类的equals(obj)方法，O(n)
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj instanceof SeqList) {
            SeqList<T> list = (SeqList<T>) obj;
            // 比较实际长度的元素，而非数组容量
            for (int i = 0; i < this.length(); i++) {
                if (!this.get(i).equals(list.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
	// 返回顺序表所有元素的描述字符串，形式为“(,)”，覆盖Object类的toString()方法
    public String toString() {
        String str = "(";
        if (this.len > 0)
            str += this.element[0].toString();
        for (int i = 1; i < this.len; i++)
            str += ", " + this.element[i].toString();
        return str + ") "; // 空表返回()
    }
	
}
