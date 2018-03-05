package designerpattern.interator;

public interface Iterator {
   public Object first();
   public Object next();
   public boolean isDone();
   public Object currentItem();
}
