package lab3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab3 {
	private static int arraySize;
	private static Scanner input = new Scanner(System.in);
	private static int numberToFind = 0;
	private static Numbers obj = new Numbers();
	
	public static void main(String[] args) {
		int choice = 0;
		int occurrences = 0;
		
			while (choice != 7)
			{
				try 
				{
					System.out.println("1 ... Create array with new size");
					System.out.println("2 ... Generate random numbers and store it in the array");
					System.out.println("3 ... Search and display number of occurrences");
					System.out.println("4 ... Binary search to find whether specific number exists");
					System.out.println("5 ... Recursive binary search to find whether specific number exists");
					System.out.println("6 ... Display Array");
					System.out.println("7 ... Quit");
					choice = input.nextInt();

					switch (choice) 
					{
					case 1: do {
							System.out.println("Enter required array size:");
							arraySize = input.nextInt();
							} while (arraySize <= 0);
							obj = new Numbers (arraySize);
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
					case 4:	obj.sortArray();
							numberToFind();
							System.out.println(numberToFind+" is in the list of numbers at the index of "+obj.binSearch(numberToFind));
							break;
					case 5:	obj.sortArray();
							numberToFind();
							System.out.println(numberToFind+" is in the list of numbers at the index of "+obj.recBinSearch(numberToFind));
							break;
					case 6: System.out.println(obj);
							break;
					case 7: break;
				   default: System.out.println("Invalid choice... try again");
						 	break;
						}
				}catch (InputMismatchException ime) 
				{
					System.out.println("Only numbers are accepted.");
					input.next();
				}catch (NullPointerException npe)
				{
					System.out.println("No arrays entered yet.");
					continue;
				}catch (IllegalArgumentException iae) {
					System.out.println("Can't sort. No arrays entered yet.");
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
	
	public static void numberToFind() {
		System.out.println("Enter number to be searched: ");
		numberToFind = input.nextInt();
		while (numberToFind < 0) {
			System.out.println("Wrong input. Enter a number higher than 0: ");
			numberToFind = input.nextInt();
		}
	}
}