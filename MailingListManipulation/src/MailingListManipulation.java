import java.util.InputMismatchException;
import java.util.Scanner;
/***********************************************************************************
Class: Assignment2.java
Purpose: Main class which displays the menu and performs specific functions depending on the user's choice.
Author:  Chrystian Rafael Sanches dos Santos 040862854
Date: 18/12/2017
Course: CST8130 - Data Structures
Data fields:  - in: Scanner - a java.util.Scanner object.
 			  - choice: char - a variable to contain a single character.
 			  - dir: Directory - a Directory class object.
 			  - listName: String - String which contains the name of the list entered by the user.
Methods: 	  + main(String[]): static void - Standard main method to execute the program. It loops through the menu of options until the user types "q" to quit the program.
   
************************************************************************************/
public class Assignment2 {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		char choice = 'w';
		Directory dir = new Directory();
		String listName = "";
		String listNotFound = "List was not found.";
		
		while (choice != 'q') 
		{
			try 
			{
				System.out.println("Enter c to create a new list \r\n"
						+ "      p to display all the email lists \r\n"
						+ "      a to add an entry to a list \r\n"
						+ "      d to delete an entry from a list \r\n"
						+ "      l to display a list \r\n"
						+ "      f to load lists from file \r\n"
						+ "      q to quit ");
				choice = in.next().toLowerCase().charAt(0);
				
				switch(choice) 
				{
					case 'c': System.out.print("Enter the name of the list: ");
							  listName = in.next();
							  while (dir.listExists(listName)) 
							  {
								  System.out.print("List already exists. Please type another name: ");
								  listName = in.next();
							  }
							  dir.createList(listName);
							  String subChoice = "y";
							  while (!subChoice.equals("n")) 
							  {
								  if(subChoice.equals("y")) 
								  {
									  EmailAddress emailAddress = new EmailAddress();
									  emailAddress.readAddress(in, "k");
									  dir.addEmail(emailAddress);
								  }
								  System.out.print("Another? y/n: ");
								  subChoice = in.next().toLowerCase();
							  }
							  dir.addEmailListToArray();
							  break;
					case 'p': if (dir.isEmpty()) 
							 	{
									System.out.println("List is currently empty.");
								} else 
								{
								  System.out.println("The email lists are: ");
							  	  dir.displayAllLists();
								}
							  break;
					case 'a': System.out.print("Enter name of list to add to: ");
							  listName = in.next();
							  if(dir.listExists(listName)) 
							  {
								  EmailAddress emailAddress = new EmailAddress();
								  emailAddress.readAddress(in, "k");
								  dir.addEmailToList(listName, emailAddress);
								  System.out.println("Email " +emailAddress.toString()+" was added to the list "+listName);
							  } else 
								  System.out.println(listNotFound);
							  break;
					case 'd': System.out.print("Enter name of list to delete from: ");
							  listName = in.next();
							  if(dir.listExists(listName)) {
								  dir.removeEmail(in, listName);
							  }
							  else
								  System.out.println(listNotFound);
							  break;
					case 'l': System.out.print("Enter name of list to display: ");
							  listName = in.next();
							  if(dir.listExists(listName))
								  dir.displayList(listName);
							  else 
								  System.out.println(listNotFound);
							  break;
					case 'f': System.out.print("Enter name of file to process: ");
							  String fileName = in.next();
							  dir.readFile(fileName);
							  break;
					case 'q': break;
					default: System.out.println("Please try again.");
							 break;
				}
			} catch(InputMismatchException ime) {
				System.out.println("Only chars are allowed.");
				in.next();
			}
		}
		
	}

}
