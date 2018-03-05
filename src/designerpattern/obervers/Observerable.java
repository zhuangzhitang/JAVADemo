package designerpattern.obervers;
/**
 * 被观察者
 * @author zhuangzhitang-pc
 *
 */
public interface Observerable {
   public void registerObserver(Observer observer);
   public void removeObserver(Observer observer);
   public void notifyObserver();
}
