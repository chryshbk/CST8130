package lab7;

import java.util.Scanner;

public class Lab7 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int choice = 0;
		BinaryTree bt = new BinaryTree();
		
		while(choice != 6) {
		System.out.println("Please choose your option \n"
				+ "1 - Insert into the tree\n"
				+ "2 - Pre-order traversal\n"
				+ "3 - In-order traversal\n"
				+ "4 - Post-order traversal\n"
				+ "5 - Height of the tree");
		choice = in.nextInt();
		
		switch(choice) {
			case 1: System.out.print("Enter a value to insert into the tree: ");
					int value = in.nextInt();
					bt.insertInTree(value);
					break;
			case 2: bt.displayPreOrder();
					System.out.println();
					break;
			case 3: bt.displayInOrder();
					System.out.println();
					break;
			case 4: bt.displayPostOrder();
					System.out.println();
					break;
			case 5:	System.out.print(bt.getHeight());
					System.out.println();
					break;
			case 6: break;
			default: System.out.println("Incorrect input.");
					 break;
		}
		}
		in.close();
	}

}
