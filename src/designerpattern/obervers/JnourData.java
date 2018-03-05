package designerpattern.obervers;

import java.util.Observable;

public class JnourData extends Observable {
	
	private int edition;
	private float cost;
	
	
	public void setInfomation(int edition,float cost){
        this.edition = edition;
        this.cost = cost;
        setChanged();
        //调用无参数的方法，使用拉模型
        notifyObservers();
	}


	public int getEdition() {
		return edition;
	}


	public float getCost() {
		return cost;
	}
	
	
}
