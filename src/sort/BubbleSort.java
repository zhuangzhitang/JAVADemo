package sort;

public class BubbleSort {
	private long[] arr;
	private int nElemts;
	public BubbleSort(int max){
		arr = new long[max];
		nElemts = 0;
	}
	
	public void insert(long value){
		arr[nElemts] = value;
		nElemts++;
	}
	
	public void display(){
		for(int i =0 ; i <nElemts;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println(" ");
	}
	public void swap(int one,int two){
		long temp = arr[one];
		arr[one] = arr[two];
		arr[two] = temp;
	}
	public void bubbleSort(){
		for(int i = nElemts-1;i>1;i-- )
		for(int j =0;j< i;j++){
			if(arr[j]>arr[j+1]){
				swap(j, j+1);
			}
		}
	}
	/**
	 * 从数组的一端两两比较，大的往后排，比较n-1 这样一轮下去后，最大的就到最后一个位置
	 * 以此类推从 第一位置开始，比较n-2次，就可以冒泡出第二个大的
	 * 执行时间（O（n2）） 交换次数 n*n,执行次数n*n
	 * 最外层控制不变的
	 * @param arr
	 * @return
	 */
    public static int[] sort(int[] arr){
    	for(int i =arr.length-1 ; i>1;i--){
    		for(int j = 0;j< i-1;j++){
    			if(arr[j]>arr[j+1]){
    				int temp = arr[j];
    				 arr[j] = arr[j+1];
    				 arr[j+1] = temp;
    			}
    		}
    	}
    	return arr;
    }
  public static void  bubble_2 ( int r[], int n){  
        int low = 0;   
        int high= n -1; //设置变量的初始值  
        int tmp,j;  
        while (low < high) {  
            for (j= low; j< high; ++j) //正向冒泡,找到最大者  
                if (r[j]> r[j+1]) {  
                    tmp = r[j]; r[j]=r[j+1];r[j+1]=tmp;  
                }   
            --high;                 //修改high值, 前移一位  
            for ( j=high; j>low; --j) //反向冒泡,找到最小者  
                if (r[j]<r[j-1]) {  
                    tmp = r[j]; r[j]=r[j-1];r[j-1]=tmp;  
                }  
            ++low;                  //修改low值,后移一位  
        }   
        
       
    }  
  
	//快速排序  
	public static void quick_sort(int s[], int l, int r)  
	{  
	    if (l < r)  
	    {  
	        //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1  
	        int i = l, j = r, x = s[l];  
	        while (i < j)  
	        {  
	            while(i < j && s[j] >= x) // 从右向左找第一个小于x的数  
	                j--;    
	            if(i < j)   
	                s[i++] = s[j];  
	              
	            while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数  
	                i++;    
	            if(i < j)   
	                s[j--] = s[i];  
	        }  
	        s[i] = x;  
	        quick_sort(s, l, i - 1); // 递归调用   
	        quick_sort(s, i + 1, r);  
	    }  
	}  
    public static void main(String[] args) {
		int[] arr={1,3,4,2,5,6,8,7,4};
		//arr = BubbleSort.sort(arr);
		 BubbleSort.quick_sort(arr,0,arr.length-1);
		
		 for(int a:arr){
		     System.out.print(a+" ");
	     }
	     System.out.println(" ");
       
		
	}
}
