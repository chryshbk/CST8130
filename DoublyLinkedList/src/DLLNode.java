package doublylinkedlist;
public class DLLNode {
	private String data;
	private DLLNode next;
	private DLLNode prev;

	public DLLNode(String newData) {
		this.data = newData;
		this.next = null;
		this.prev = null;
	}

	public void updateNodeNext(DLLNode nextOne) {
		this.next = nextOne;
	}

	public void updateNodePrev(DLLNode prevOne) {
		this.prev = prevOne;
	}

	public String toString() {
		return this.data;
	}

	public DLLNode getNext() {
		return this.next;
	}

	public DLLNode getPrev() {
		return this.prev;
	}
}