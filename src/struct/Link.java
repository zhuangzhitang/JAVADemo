package struct;

public class Link {
  public int iData;
  public double dDtata ;
  public Link next;
  
  public Link(int i,double d){
	  this.iData = i ;
	  this.dDtata = d;
  }
  public void display(){
	  System.out.println("["+iData +" "+dDtata+"]");
  }
}
