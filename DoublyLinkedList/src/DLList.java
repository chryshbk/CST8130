package doublylinkedlist;
public class DLList {
	private DLLNode head;
	private DLLNode tail;

	public DLList() {
		head = null;
		tail = null;
	}

	public void addAtHead(String newData) {
		DLLNode newNode = new DLLNode(newData);
		if (head != null)
			head.updateNodePrev(newNode);
		newNode.updateNodeNext(head);
		head = newNode;
		if (tail == null)
			tail = newNode;
	}

	public void displayFromHead() {
		DLLNode temp = head;
		while (temp != null) {
			System.out.println(temp);
			temp = temp.getNext();
		}
	}

	public void displayFromTail() {
		DLLNode temp = tail;
		while (temp != null) {
			System.out.println(temp);
			temp = temp.getPrev();
		}
	}

	public boolean searchAndDelete (String oneToDelete) {
		if (head == null)     return false;
		DLLNode current = head;
		// walk through list, compare each node with search value
		while (current!= null &&  !(current.toString().equals(oneToDelete))) {
				current = current.getNext();
		 }
		if (current != null) { // must have found it
			if (head == current && tail == current){ // deleting only item in list
				head = null;                tail = null;
			} else if (current == head)   {   // deleting first item 
				head = current.getNext();
				current.getNext().updateNodePrev(null);
			} else if (current == tail) {  // deleting last item
				tail  = current.getPrev();
				current.getPrev().updateNodeNext(null);
			} else { 	current.getPrev().updateNodeNext(current.getNext());
				current.getNext().updateNodePrev(current.getPrev());
			}
			return true;
		 }   else  return false;    // didn’t find it }
	}

}