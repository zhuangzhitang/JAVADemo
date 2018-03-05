package tree;

public class Node {
	public  int key;
    public double fData;
    private Node leftChild;
    private Node rightChild;
    
	public double getfData() {
		return fData;
	}
	public void setfData(double fData) {
		this.fData = fData;
	}
	public Node getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	public Node getRightChild() {
		return rightChild;
	}
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
   
	public void display(){
		System.out.println("["+key+"-"+fData+"]");
	}
   
}
