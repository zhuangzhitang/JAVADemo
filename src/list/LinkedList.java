package list;

import java.util.Collection;
import java.util.NoSuchElementException;
/**
 * 双向循环链表的，且头结点中不存放数据
 * @author zhuangzhitang-pc
 *
 * @param <E>
 */
public class LinkedList<E> {
	
	private Entry<E> header =  new Entry<E>(null, null, null);;
	private int size;
    
	public LinkedList(){
		header.previous = header.next = header;
	}
	
	public boolean addAll(int index,Collection<? extends E> c){
		if(index <0 ||index >size)
			throw new IndexOutOfBoundsException();
		Object[] a = c.toArray();
		int numNew = a.length;
		if(numNew==0)
			return false;
		Entry<E> successor = (index == size? header:entry(index));
		Entry<E> prevessor = successor.previous;
		
		for(int i = 0 ; i <a.length ;i ++)
		{
			Entry<E> e = new Entry<E>((E)a[i], successor, prevessor);
			prevessor.next = e;
			prevessor = e;
		}
		successor.previous = prevessor;
		
		size += numNew;
        return true;
	}
	private Entry<E> entry(int index) {
		if(index <0 ||index >size)
			throw new IndexOutOfBoundsException("Index: "+index+
                    ", Size: "+size);
		 Entry<E> e = header;
		 
		 if(index < (size>>1)){
			 for (int i = 0; i <= index; i++)
	                e = e.next;
		 }else{
			 for(int i = size;i>index; i--)
				 e = e.previous;
		 }
		
		return null;
	}
	private static class Entry<E>{
		private E element;
		private Entry<E> next;
		private Entry<E> previous;
		
		
		
		public Entry(E element,Entry<E> next,Entry<E> previous){
			this.element = element;
			this.next = next;
			this.previous = previous;
		}
		
		private Entry<E> addBefore(E e, Entry<E> entry) {
		   Entry<E> newEntry = new Entry<E>(e, entry, entry.previous);
		   newEntry.previous.next = newEntry;
		   newEntry.next.previous = newEntry;
		   return newEntry;
	    }

	}
	
    private E remove(Entry<E> e) {
    	if (e == header)
	    throw new NoSuchElementException();

        E result = e.element;
	    e.previous.next = e.next;
	    e.next.previous = e.previous;
        e.next = e.previous = null;
        e.element = null;
        return result;
	}
		
}
