package lab2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab2 {
	private static int arraySize = 0;
	private static Scanner input = new Scanner(System.in);
	private static Numbers obj = new Numbers();
	
	public static void main(String[] args) {
		int choice = 0;
		int occurrences = 0;
		
			while (choice != 5)
			{
				try 
				{
				System.out.println("1 ... Create array with new size");
				System.out.println("2 ... Generate random numbers and store it in the array");
				System.out.println("3 ... Search and display number of occurrences");
				System.out.println("4 ... Display array");
				System.out.println("5 ... Quit");
				choice = input.nextInt();
				
				switch (choice) 
					{
					case 1: System.out.println("Enter required size:");
							arraySize = input.nextInt();
							while (arraySize <= 0) {
								System.out.println("Please enter a positive number: ");
								arraySize = input.nextInt();
							}
							obj = new Numbers(arraySize);
							break;
					case 2:	if (checkSize() == false) break;
							obj.generateNumbers();
							break;
					case 3: System.out.println("Enter the number to be searched:");
							occurrences = input.nextInt();
							while (occurrences <= 0) {
								System.out.println("Wrong input. Enter a number higher than 0: ");
								occurrences = input.nextInt();
							}
							System.out.println("Number of occurrences of "+occurrences+ " in the array is "+obj.count(occurrences));
							break;
					case 4: System.out.println(obj.toString());
							break;
					case 5:	break;
				   default: System.out.println("Invalid choice... try again");
						 	break;
					}
				}catch (InputMismatchException ime) 
				{
					System.out.println("Only numbers are accepted.");
					input.next();
				}catch (NullPointerException npe) {
					System.out.println("No arrays entered yet.");
					continue;
				}
			}
		System.out.println("Bye... See you again");
		input.close();
	}
	
	public static boolean checkSize() {
		if (arraySize <= 0) 
			System.out.println("Array size not entered. ");
		return true;
	}
}