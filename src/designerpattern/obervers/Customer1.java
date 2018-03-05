package designerpattern.obervers;

import java.util.Observable;
import java.util.Observer;

public class Customer1 implements Observer {

	private String name;
    private int edition;
    private float cost;
    
    public void Consumer(String name){
        this.name = name;
    }
	@Override
	public void update(Observable observable, Object obj) {
		 //判断o是否是JournalData的一个实例
        if(observable instanceof JnourData){
            //强制转化为JournalData类型
        	JnourData journalData = (JnourData) observable;
            //拉取数据
            this.edition = journalData.getEdition();
            this.cost = journalData.getCost();
            buy();
        }
	}
	private void buy() {
		 System.out.println(name+"购买了第"+edition+"期的杂志，花费了"+cost+"元。");
		
	}

}
