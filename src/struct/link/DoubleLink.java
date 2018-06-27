package struct.link;

public class DoubleLink {
	
	private class Node{
		public Node pre;
		public Node next;
		public String data;
		public Node(Node pre, Node next, String data) {
			this.pre = pre;
			this.next = next;
			this.data = data;
		}
	}
	
	private int length;
	private Node header;
	private Node tail;
	
	public DoubleLink(){
		length = 0 ;
		header = new Node(null, null, null);
		tail = new Node(null, header, null);
		header.next = tail;
	}
	
	public void add(String item){
		Node aNode = new Node( null, null,item);
		tail.pre.next = aNode;
		aNode.pre = tail.pre;
		aNode.next = tail;
		length++;
	}
	public String getInt(int index) {
		 
        if (index > this.length - 1 || index < 0)
            throw new IndexOutOfBoundsException();
 
        Node current = header.next;
 
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
 
        return current.data;
    }
 
    public void print() {
		//Node<T> current = Header.next;
 
       /* while (current.next != null) {

			System.out.println(current.data.toString());

			current = current.next;
		}*/
 
    }
 
    public static void main(String[] args) {
        DoubleLink dLink = new DoubleLink();
 
        dLink.add("zhb");
        dLink.add("zzb");
        dLink.add("zmy");
        dLink.add("zzj");
 
       // System.out.println("size : " + dLink.size());
       // System.out.println("isEmpty? : " + dLink.isEmpty());
        System.out.println("3 : " + dLink.getInt(2));
        dLink.print();
    }
}

