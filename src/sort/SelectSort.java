package sort;
/**
 * 在要排序的序列中，选择最小的一个数与第一个数位置的数交换，然后在剩下的数当中再找最小的数与第二个数交换
 * 依次类推，直到第n-1个元素（倒数第二个数）和第n个元素（最后一个数）比较为止
 * @author zhuangzhitang-pc
 *
 */
public class SelectSort {
	
	public static int[]  sort1(int[] a){
		for(int i=0;i<a.length;i++){
			int index  = i;
			for(int j=i+1;j<a.length;j++){
				if(a[j]<a[index]){
					index = j;
				}
			}
			int temp = a[i];
			a[i] = a[index];
			a[index] = temp;
		}
		
		return a ;
	}
	/**
	 * 从左到右选择出最小的值，跟最左边的替换，
	 * 每次不可变的就是最左的数字是有序的，不需要重复排序
	 * 次数 O（N*N） ，交换次数 为N次
	 * 最外层控制不变的
	 * @param arr
	 * @return
	 */
	public static int[] sort(int[] arr){
		for(int i =0 ; i <arr.length-1;i++){
			int index = i;
			for(int j = i+1;j<arr.length;j++){
				if(arr[j]<arr[index]){
					index = j;
				}
			}
		    int temp = arr[i];
		    arr[i] = arr[index];
		    arr[index]= temp;
		}
		return arr;
	}
   public static void main(String[] args) {
	   {
	    	int[] arr={1,3,4,2,5,6};
			arr = SelectSort.sort1(arr);
			for(int a:arr){
				System.out.print(a+" ");
			}
			System.out.println(" ");
		}
} 
}
