package thread;

public class PCData {
   private final int iniData;
   
   public PCData(int d){
	   iniData = d;
   }
   
   public PCData(String d){
	   iniData = Integer.valueOf(d);
   }
   public int getData(){
       return iniData;
   }
   @Override
   public String toString(){
       return "data:"+iniData;
   }
}
