package sort;
/**
 * 插入排序—希尔排序（Shell`s Sort）
 * @author zhuangzhitang-pc
 *操作方法：
 *选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 *按增量序列个数k，对序列进行k 趟排序；
 *每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 */
public class ShellSort {
 
	  public static void main(String[] args) {  
	        int a[] = {3,1,5,7,2,4,9,6,10,8};    
	        ShellSort  obj=new ShellSort();  
	        System.out.println("初始值：");  
	        obj.print(a);  
	        obj.shellSort(a);  
	        System.out.println("\n排序后：");  
	        obj.print(a);  
	  
	    }  
	  
	  private void shellSort(int[] a) {
		 int dk = a.length/2;
		 while(dk>=1){
			 ShellInsertSort(a,dk);
			 dk =dk/2;
		 }
	  }
    /**
     * //类似插入排序，只是插入排序增量是1，这里增量是dk,把1换成dk就可以了  
     * @param a
     * @param dk
     */
	private void ShellInsertSort(int[] a, int dk) {
		for(int i =dk; i < a.length;i++){
			if(a[i]<a[i-dk]){
				int j ;
				int x = a[i];
			    a[i]=a[i-dk];  
                for(j=i-dk;  j>=0 && x<a[j];j=j-dk){//通过循环，逐个后移一位找到要插入的位置。  
                    a[j+dk]=a[j];  
                }  
                a[j+dk]=x;//插入  
			}
		}
	}

	public void print(int a[]){  
	        for(int i=0;i<a.length;i++){  
	            System.out.print(a[i]+" ");  
	        }  
	    }  
}
