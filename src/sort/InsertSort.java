package sort;
/**
 * 将一条记录插入到已经排好序的记录中，从而得到一个新的记录，记录数增加1 的有序表。
 * 即：先将序列的第一个数当做有序序列，然后从第二个数记录中逐个插入到，知道整个序列有序为止
 * 要点：设置哨兵：
 * @author zhuangzhitang
 *
 */
public class InsertSort {
	/**
	 * 
	 * @param a
	 * @return
	 */
	public static int[] sort1(int a[]){
		/**
		 * 默认
		 * 外层：要插入的记录 ，用 temp表示
		 * 内层：表示已经有序的记录，比较 temp与前面的值，如果小于前面的数，则交换值，继续遍历
		 *      直到temp等于或则大于前面值时，停止遍历，
		 *      如果碰见一个和插入元素相等的，那么插入的元素放在相等元素后面，所以相等元素的前后顺序是没有改变的
		 *      所以直接插入顺序是稳定的
		 *      效率为 O(n^2)
		 */
		for(int i = 1 ; i < a.length;i++){
			int temp = a[i];//为待插入的元素
			int j ;
			for(j=i;j>0&&a[j-1]>temp;j--){
				   a[j] = a[j-1];
			}
			a[j]=temp;
		}
		return a;
	}
	/**
	 *外层 for循环从1 向右移动
	 *in 层从out变量，向左移动，直到它不能够移动位置
	 * 以左边为已经排序好的序列，从没有排序的右边中向右移动，直到最后一个值
	 */
	public static int[] sort(int[] arr){
		for(int out=1;out<arr.length;out++){
			int temp =arr[out];
			int in = out;
			while(in>0&&arr[in-1]>=temp){
				arr[in]=arr[in-1];
				--in;
			}
			arr[in] = temp;
		}
		return arr;
	}
	
	public static int[] sort2(int[] arr){
		for(int out = 1 ; out < arr.length ; out++){
			int temp = arr[out];
			int in = out ;
		
		}
		return arr;
	}
   public static void main(String[] args) {
	   {
	    	int[] arr={4,3,4,2,5,6,2};
			arr = InsertSort.sort1(arr);
			for(int a:arr){
				System.out.print(a+" ");
			}
			System.out.println(" ");
		}
   }
}
