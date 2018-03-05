package tree;

public class Tree {
   private Node root;
   
   public Node find(int key){
	  Node current = root;
	  while(current.fData !=key){
		  if(key<current.fData){
			  current = current.getLeftChild();
		  }else{
			  current = current.getRightChild();
		  }
		  if(current==null)
			  return null;
	  }
	  return current;
	  
   }
   
   public void insert(int id,int dd){
	   Node newNode = new Node();
	   newNode.fData = id;
	   newNode.key = dd;
	   
	   if(root == null)
		   root = newNode;
	   else{
		   Node current = root;
		   Node parent ;
		   while(true){
			   parent = current;
			   if(id < current.fData){
				   current  = current.getLeftChild();
				   if(current == null){
					   parent.setLeftChild(newNode);
					   return ;
				   }
			   }else{
				   current = current.getRightChild();
				   if(current == null){
					   parent.setRightChild(newNode);
					   return ;
				   }
			   }
		   }
	   }
   }
   
   public void  delete(int id){
	   
   }
}
