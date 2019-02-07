package lab5;

public class LList {
	private LLNode head;
	
	public LList() { head = null; }
	
	public void addAtHead (String newData) 
	{
		LLNode newNode = new LLNode (newData);
		newNode.updateNode(head);
		head = newNode;
	}
	
	public void display() 
	{
		LLNode temp = head;
		while (temp != null) 
		{
			System.out.println (temp);
			temp = temp.getNext();
		}
	}
	
	public LLNode deleteAtHead ( ) 
	{
		LLNode removedOne = head;
		head = head.getNext();
		return removedOne;
	}
	
	public void deleteOne(String data) 
	{
		LLNode currentNode = head;
		LLNode previousNode = null;
		
		while (currentNode != null) 
		{
			 if (currentNode.toString().equals(data)) 
			 {
				previousNode.updateNode(currentNode.getNext());
				System.out.println("String removed.\n");
			 }
			 
			 previousNode = currentNode;
			 currentNode = currentNode.getNext();
		}
	}
}
