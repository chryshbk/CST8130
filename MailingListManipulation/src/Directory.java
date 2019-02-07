/***********************************************************************************
Class: Directory.java
Purpose: This class is a directory which contains an ArrayList of EmailList objects.
Author:  Chrystian Rafael Sanches dos Santos 040862854
Date: 18/12/2017 
Data fields:  	- file: Scanner - an object of the java.util.Scanner.
  				- emailListArray: ArrayList<EmailList> - an array of EmailList objects.
                - emailList: EmailList - an EmailList object.
Course: CST8130 - Data Structures                
Methods:  	 	+ default constructor
            	- openFile(String): void - Opens a file using Scanner and file.nio.file.Paths. The parameter is the name of the file.
            	+ readFile(String): void - Reads the file after it is opened and uses the method addEmailListToArray to store the elements from the file in the ArrayList.
            	+ listExists(String): boolean - Loops through the ArrayList of EmailList and checks if any list name matches the list name entered by the user. If it does, it returns true, if doesn't it returns false.
            	+ createList(String): void - Creates a new list name using a constructor from the emailList class.
            	+ addEmail(EmailAddress): void - Uses the method addEmail(EmailAddress) from the class EmailList to add an email to the list.
            	+ addEmailListToArray: void - Adds an EmailList object to the ArrayList. 
            	+ addEmailToList(String, EmailAddress): void - Loops through the ArrayList to find the list name that matches the String entered by the user. If it does find, it adds the email the user typed to the list using the addEmail from the EmailList class.
            	+ removeEmail(Scanner, String): void - Loops through the ArrayList to find the list name that matches the String entered by the user using the Scanner. If it does find, it removes the email from the list using a method called displayEmailToRemove from the EmailList class.
            	+ isEmpty(): boolean - Checks if the list is empty. Returns true if it is.
            	+ displayList(String): void - Displays the specific list entered by the user if the list is in the ArrayList.
            	+ displayAllLists: void - Displays all the lists from the ArrayList.
************************************************************************************/
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Directory 
{
	private Scanner file;
	private ArrayList<EmailList> emailListArray = new ArrayList<>();
	private EmailList emailList = new EmailList();
	
	/**
	 * Default constructor.
	 */
	public Directory() {}
	/**
	 * Opens a file using Scanner and file.nio.file.Paths. The parameter is the name of the file.
	 * @param fileName name of the file
	 */
	private void openFile(String fileName) 
	{
		try
		{
			file = new Scanner(Paths.get(fileName));
		} catch(IOException ioe) {
			System.out.println("Error in the file");
		} 
	}
	/**
	 * Reads the file after it is opened and uses the method addEmailListToArray to store the elements from the file in the ArrayList.
	 * @param fileName Name of the list
	 */
	public void readFile(String fileName)
	{
		openFile(fileName);
		try
		{
			file.nextInt();
			String temp = "";
			EmailAddress email = new EmailAddress();
			while (file.hasNext())
			{
				String listName = temp.equals("") ? file.next() : temp;
				emailList = new EmailList(listName);
				file.nextInt();
				temp = file.next();
				while(email.validateEmail(temp)) 
				{
					email = new EmailAddress(temp);
					emailList.addEmail(email);
					temp = file.hasNext() ? file.next() : "";
				}
				
				addEmailListToArray();
			}
		} catch(NoSuchElementException nsee) { System.out.println("Invalid file."); }
		  catch(NullPointerException npe) { System.out.println("No elements in the file.");}
	}
	/**
	 * Loops through the ArrayList of EmailList and checks if any list name matches the list name entered by the user. If it does, it returns true, if doesn't it returns false.
	 * @param listName Name of the list
	 * @return boolean either true or false
	 */
	public boolean listExists(String listName) 
	{
		for(int i = 0; i < emailListArray.size(); i++) 
		{
			if (emailListArray.get(i).toString().startsWith(listName)) 
			{
				return true;
			}
		}
		return false;
	}
	/**
	 * Creates a new list name using a constructor from the emailList class.
	 * @param listName Name of the list
	 */
	public void createList(String listName) { emailList = new EmailList(listName); }
	/**
	 * Uses the method addEmail(EmailAddress) from the class EmailList to add an email to the list.
	 * @param email EmailAddress object
	 */
	public void addEmail(EmailAddress email) { emailList.addEmail(email); }
	/**
	 * Loops through the ArrayList to find the list name that matches the String entered by the user. If it does find, it adds the email the user typed to the list using the addEmail from the EmailList class.
	 */
	public void addEmailListToArray() { emailListArray.add(emailList); }
	/**
	 * Loops through the ArrayList to find the list name that matches the String entered by the user. If it does find, it adds the email the user typed to the list using the addEmail from the EmailList class.
	 * @param listName Name of the list
	 * @param email EmailAddress object
	 */
	public void addEmailToList(String listName, EmailAddress email) 
	{
		for(int i = 0; i < emailListArray.size();i++) 
		{
			if(emailListArray.get(i).toString().contains(listName)) 
			{
				emailListArray.get(i).addEmail(email);
			}
		}
	}
	/**
	 * Loops through the ArrayList to find the list name that matches the String entered by the user using the Scanner. If it does find, it removes the email from the list using a method called displayEmailToRemove from the EmailList class.
	 * @param in Scanner object
	 * @param listName Name of the list
	 */
	public void removeEmail(Scanner in, String listName) 
	{
		for(int i = 0; i < emailListArray.size(); i++) 
		{
			if(emailListArray.get(i).toString().contains(listName)) 
			{
				emailListArray.get(i).displayEmailToRemove(in);
			}
		}
	}
	/**
	 * Checks if the list is empty.
	 * @return boolean Returns if the list is empty or not
	 */
	public boolean isEmpty() { return emailListArray.isEmpty(); }
	/**
	 * Displays the specific list entered by the user if the list is in the ArrayList.
	 * @param listName Name of the list
	 */
	public void displayList(String listName) 
	{
		for (int i = 0; i < emailListArray.size(); i++) 
		{
			if (emailListArray.get(i).toString().contains(listName)) 
			{
				System.out.println(emailListArray.get(i).toString());
			}
		}
	}
	/**
	 * Displays all the lists from the ArrayList.
	 */
	public void displayAllLists() 
	{
		for (EmailList list : emailListArray)
			System.out.println(list);
	}
}
