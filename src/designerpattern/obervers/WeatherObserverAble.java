package designerpattern.obervers;

import java.util.ArrayList;
import java.util.List;

public class WeatherObserverAble implements Observerable{
	 private List<Observer> mObservers;
	 
	 public String weather = "";
	 public  WeatherObserverAble() {
		 mObservers = new ArrayList<>();
	}

	@Override
	public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		mObservers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		// TODO Auto-generated method stub
		mObservers.remove(observer);
	}

	@Override
	public void notifyObserver() {
		for(Observer observer:mObservers){
			observer.update(weather);
		}
	}
    
	public void setWheather(String wheather){
		this.weather = wheather;
		notifyObserver();
	}
}
