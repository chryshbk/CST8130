package lab5;

public class LinkedListExample {

	public static void main(String[] args) {
		LList list = new LList();
		
		list.addAtHead("Linda");
		list.addAtHead("George");
		System.out.println("The list is ");
		list.display();
		
		LLNode removedOne = list.deleteAtHead();
		System.out.println("After delete, the list is ");
		list.display();
		System.out.println("The one deleted is..." + removedOne);
		
		

	}

}
