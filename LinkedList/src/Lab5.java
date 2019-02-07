package lab5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab5 {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		LList linkedList = new LList();
		String str;
		int choice = 0;
		
		
		while(choice != 5) 
		{
			try 
			{
			System.out.println("Please choose your option: \n"
					+ "1 - Add a String to the head.\n"
					+ "2 - Remove a String from the head.\n"
					+ "3 - Display a linked list.\n"
					+ "4 - Remove one String from the list.\n"
					+ "5 - Quit");
			choice = scan.nextInt();
			
				switch(choice) 
				{
				case 1: System.out.println("Please type a String to add to the head: ");
						str = scan.next();
						linkedList.addAtHead(str);
						break;
				case 2: linkedList.deleteAtHead();
						break;
				case 3: linkedList.display();
						break;
				case 4: System.out.println("Please type a String to remove from the list: ");
						str = scan.next();
						linkedList.deleteOne(str);
						break;
				case 5: break;
				default: System.out.println("Please try again.");
						 break;
				}
			} catch(InputMismatchException ime) {
				System.out.println("Please type a number.");
				scan.next();
			}
		} 
		scan.close();
	}

}
