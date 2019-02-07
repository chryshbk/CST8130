import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/***********************************************************************************
Class:  EmailAddress
Purpose:  This class will model the data and actions needed for an email address data type
Author:   Anu Thomas
Course:   CST8130 - Data Structures
Date: 18/12/2017
Data members:   emailAddress: String - hold the value of a valid email address
Methods: EmailAddress() - default constructor - set empty string field
		 EmailAddress(String) -  sets object to String parameter emailAddress if valid 
         toString(): String - returns the data of the emailAddress field
         readAddress(Scanner) - reads in valid address from Scanner if prompt is 'k' otherwise reads from file
         validateEmail(String) - Sets a regex using java.util.regex.Pattern and java.util.regex.Matcher to see if an email address is valid or not. It uses the compile() static method from the Matcher class to set a regex for the email and puts as Case Insensitive. Returns a boolean either true or false using the Matcher find() method if the email entered by the user matches the regex.   	          
*************************************************************************************/


public class EmailAddress {
	
	private String emailAddress;
	
	public EmailAddress(){ this.emailAddress = new String(); }
	
	public EmailAddress (String email)
	{
		if(validateEmail(email))
			emailAddress = email;
	}
	
	public void readAddress (Scanner in, String prompt)
	{
		if(prompt.charAt(0) == 'k')
			System.out.println("Enter valid email address: ");
		emailAddress = in.next();
		
		while(!validateEmail(emailAddress))
		{
			System.out.println("Enter valid email address.... it should contain @ and . and should be atleast 7 characters long");
			emailAddress = in.next();
		}
	}
	
	public boolean validateEmail(String emailString) 
	{
		Pattern EMAILADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = EMAILADDRESS_REGEX.matcher(emailString);
		return matcher.find();
	}
	
	@Override
	public String toString(){ return emailAddress; }
}
