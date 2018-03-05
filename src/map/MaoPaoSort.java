package map;

public class MaoPaoSort {
	
	public static int[] sort(int[] orgarr){
		for(int i= 0 ; i < orgarr.length;i++){
			for(int j =0 ; j< orgarr.length-1;j++){
				if(orgarr[j+1]<orgarr[j]){
					int temp = orgarr[j];
					orgarr[j] = orgarr[j+1];
					orgarr[j+1] = temp;
				}
			}
		}
		return orgarr;
	}
	public static void main(String[] args) {
		int[] orgarr =new int[]{6,3,4,6,3,2};
		
        int[] desarr = MaoPaoSort.sort(orgarr);
        for(int i :desarr){
        	System.out.println(i+" ");
        }
	}
	
     
}
