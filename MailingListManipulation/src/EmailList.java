/***********************************************************************************
Class: EmailList.java
Purpose: This class is an EmailList which contains a LinkedList of EmailAddress objects.
Author: Chrystian Rafael Sanches dos Santos 040862854
Course: CST8130 - Data Structures
Date: 18/12/2017
Data fields:  - listName: String - name of the list.
 			  - emailList: LinkedList<EmailAddress> - a LinkedList of EmailAddress objects.      
Methods:  	  + default constructor
 			  + Initial constructor
 			  + Initial constructor
           	  + addEmail(EmailAddress): void - Add an EmailAddress object to the head of the list.
           	  + displayEmailToRemove(Scanner): void - Loops through the LinkedList and shows the list of EmailAddress objects in a certain list and its number in the LL. Then it uses Scanner to ask for a number to delete which has to be above 0 and valid. It calls the method removeOneEmail() which removes one email in the list.              + toString(): Overridden toString method which contains the listName and the LinkedList of EmailAddress objects.
************************************************************************************/
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.lang.IndexOutOfBoundsException;

public class EmailList 
{
	private String listName;
	private LinkedList<EmailAddress> emailList = new LinkedList<>();
	/**
	 * Default constructor
	 */
	public EmailList() {}
	/**
	 * Initial constructor
	 * @param listName Name of the list
	 */
	public EmailList(String listName) { this.listName = listName; }
	/**
	 * Initial constructor
	 * @param listName Name of the list
	 * @param emailAddress EmailAddress object
	 */
	public EmailList(String listName, EmailAddress emailAddress) 
	{
		this.listName = listName;
		addEmail(emailAddress);
	}
	/**
	 * Add an EmailAddress object to the head of the list.
	 * @param newEmail EmailAddress object
	 */
	public void addEmail(EmailAddress newEmail) 
	{
		this.emailList.push(newEmail);
	}
	/**
	 * Loops through the LinkedList and shows the list of EmailAddress objects in a certain list and its number in the LL. Then it uses Scanner to ask for a number to delete which has to be above 0 and valid. It calls the method removeOneEmail() which removes one email in the list.
	 * @param in Scanner object
	 */
	public void displayEmailToRemove(Scanner in) 
	{
		for(int i = 0; i < emailList.size(); i++) {
			System.out.println(i + "... " + emailList.get(i).toString());
		}
		try
		{
			System.out.print("Enter entry number to delete: ");
			int option = in.nextInt();
			if (option >= 0) {
			removeOneEmail(emailList.get(option));
			System.out.println("Email removed!");
			}
			else
				System.out.println("Only positive numbers allowed ");
		} catch(InputMismatchException ime) {
			System.out.println("Only numbers are allowed.");
		} catch(IndexOutOfBoundsException iobe) {
			System.out.println("Number/email not found.");
		}
	}
	/**
	 * Removes one email from the list.
	 * @param email EmailAddress object
	 */
	public void removeOneEmail(EmailAddress email) 
	{
		this.emailList.remove(email);
	}
	/**
	 * Overridden toString method which returns the listName and the LinkedList of EmailAddress objects.
	 */
	@Override
	public String toString() 
	{
		return listName+": "+emailList.toString();
	}
}
