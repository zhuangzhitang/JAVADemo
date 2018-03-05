package struct;

public class LinkList {
	
	private Link first ;
	public LinkList(){
		first = null;
	}
    
	public boolean isEmpty(){
		return first==null;
	}
	
	public void insertFirst(int id,double dd){
		Link newLink = new Link(id,dd);
		newLink.next = first ;
		first = newLink;
	}
	
	public Link deleteFirst(){
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	public void dispalyList()
	{
		System.out.println("List(first--->last)");
		Link current = first;
		while(current !=null){
			current.display();
			current = current.next;
		}
	}
	
}
