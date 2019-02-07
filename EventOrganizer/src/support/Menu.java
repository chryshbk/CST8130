package support;
/**
 * File name: Menu.java
 * Author: Chrystian Rafael Sanches dos Santos, 040862854
 * Course: CST8130 - Data Structures
 * Assignment: 1
 * Date: 17/10/2017
 * Professor: Anu Thomas
 * Purpose: This class has the purpose to open a menu and ask the user for the input for what they want to do. They can add an event from the keyboard, display events
 * of a day, display events of a week, delete an event, add events from a file, display all events or quit. It uses objects from the classes related on the list.
 * 
 * Data Fields:		- ourDate: OurDate - This is an object from the OurDate class.
 * 					- ourTime: OurTime - This is an object from the OurTime class.
 * 					- fileArray: FileArray - This is an object from the FileArray class.
 * 					- in: Scanner - This data member imports the java.util.Scanner and uses it to get the user's input.
 * 					- type: int - This variable stores the type of the activity which can be from 1 to 5.
 * 
 * Methods:   default constructor
 *              openMenu(): void - prompts user to enter values from 1 to 7 depending on what they want to do.
 *              			if they enter 1, it will show 5 more options on which kind of event they want to input.
 *              			if they enter 2, it will prompt the user to enter day, month and year. It shows the activities related to the day entered or not.
 *              			if they enter 3, it will prompt the user to enter day, month and year. It shows the activities related to the week entered or not.
 *              			if they enter 4, it will prompt the user to enter day, month, year, hour and minute. It shows delete the activity that matches the input or not if it does not exist.
 *              			if they enter 5, it will add events from a file Events.txt to an ArrayList of Events and it will show the user the dates they cannot input from keyboard to avoid duplicates.
 *              			if they enter 6, it will display the list of activities calling the displayArray() method from the FileArray.java class.
 *               	        if they enter 7, it will shut the program down.
 *               
 * Class list: Assign1.java, OurDate.java, OurTime.java, Events.java, Gym.java, Meeting.java, School.java, Social.java, Work.java, FileArray.java.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

import date.OurDate;
import date.OurTime;
import events.Events;
import events.Gym;
import events.Meeting;
import events.School;
import events.Social;
import events.Work;
/**
 * 
 * @author Chrystian Rafael Sanches dos Santos, Student number: 040862854
 * @version 1.0.0
 * @see support
 * @since 2017-10-17
 *
 */
public class Menu {
	private OurTime ourTime = new OurTime();
	private OurDate ourDate = new OurDate();
	private FileArray fileArray = new FileArray();
	private Scanner in = new Scanner (System.in);
	private int type;
	
	/**
	 * Default constructor.
	 */
	public Menu() {}
	/**
	 * prompts user to enter values from 1 to 7 depending on what they want to do.
	 * If they enter 1, it will show 5 more options on which kind of event they want to input.
	 * If they enter 2, it will prompt the user to enter day, month and year. It shows the activities related to the day entered or not.
	 * If they enter 3, it will prompt the user to enter day, month and year. It shows the activities related to the week entered or not.
	 * If they enter 4, it will prompt the user to enter day, month, year, hour and minute. It shows delete the activity that matches the input or not if it does not exist.
	 * If they enter 5, it will add events from a file Events.txt to an ArrayList of Events and it will show the user the dates they cannot input from keyboard to avoid duplicates.
	 * If they enter 6, it will display the list of activities calling the displayArray() method from the FileArray.java class.
	 * If they enter 7, it will shut the program down.
	 */
	public void openMenu() 
	{
		int choice = 0;
		
		while (choice != 7) 
		{
		
			try 
			{
				System.out.println(	"1 ... Add an event from keyboard \r\n" + 
									"2 ... Display events of a day \r\n" + 
									"3 ... Display events of a week \r\n" + 
									"4 ... Delete an event \r\n" + 
									"5 ... Add events from a file \r\n" + 
									"6 ... Display all events \r\n" + 
									"7 ... Quit \r\n");
				in = new Scanner(System.in);
				choice = in.nextInt();
			
				switch(choice) 
				{
					case 1: System.out.println("1 ... Meeting event \r\n" + 
							   "2 ... School event \r\n" + 
						       "3 ... Work event \r\n" + 
						       "4 ... Gym event \r\n" + 
						       "5 ... Social event \r\n");
							
							int typeOfEvent = in.nextInt();
							
								switch(typeOfEvent) 
								{
									case 1: 
										Events meeting = new Meeting();
										ourDate.readDate(in, 'k');
										ourTime.readTime(in, 'k');
										
										System.out.println("Enter description: ");
										meeting.setDescription(in.next());
										
										System.out.println("Enter location: ");
										meeting.setLocation(in.next());
										
										meeting = new Meeting(ourDate.getYear(), ourDate.getMonth(), ourDate.getDay(), ourTime.getHour(), ourTime.getMinute(),
													meeting.getDescription(), meeting.getLocation());
										
										if (fileArray.checkDuplicates(meeting)) { fileArray.getEventsArray().add(meeting); fileArray.setEventToFile(true); }
										else { System.out.println("Cannot add this event. It already exists."); }
										break;
									case 2: 
										Events school = new School();
										ourDate.readDate(in, 'k');
										ourTime.readTime(in, 'k');
										
										System.out.println("Enter description: ");
										school.setDescription(in.next());
										
										school = new School(ourDate.getYear(), ourDate.getMonth(), ourDate.getDay(), ourTime.getHour(), ourTime.getMinute(),
													school.getDescription(), "");
										
										if (fileArray.checkDuplicates(school)) { fileArray.getEventsArray().add(school); fileArray.setEventToFile(true); }
										else { System.out.println("Cannot add this event. It already exists."); }
										break;
									case 3: 
										Events work = new Work();
										ourDate.readDate(in, 'k');
										ourTime.readTime(in, 'k');
										
										System.out.println("Enter description: ");
										work.setDescription(in.next());
										
										System.out.println("Enter location: ");
										work.setLocation(in.next());
									
										while (work.getExtra() <= 0) 
										{
											System.out.println("Enter working hours: ");
											work.setExtra(in.nextInt());	
										}
										
										work = new Work(ourDate.getYear(), ourDate.getMonth(), ourDate.getDay(), ourTime.getHour(), ourTime.getMinute(),
													work.getDescription(), work.getLocation(), work.getExtra());
										
										if (fileArray.checkDuplicates(work)) { fileArray.getEventsArray().add(work); fileArray.setEventToFile(true); }
										else { System.out.println("Cannot add this event. It already exists."); }
										break;
									case 4: 
										Events gym = new Gym();
										ourDate.readDate(in, 'k');
										ourTime.readTime(in, 'k');
										
										System.out.println("Enter description: ");
										gym.setDescription(in.next());
	
										gym = new Gym(ourDate.getYear(), ourDate.getMonth(), ourDate.getDay(), ourTime.getHour(), ourTime.getMinute(),
													gym.getDescription(), "");
										
										if (fileArray.checkDuplicates(gym)) { fileArray.getEventsArray().add(gym); fileArray.setEventToFile(true); }
										else { System.out.println("Cannot add this event. It already exists."); }
										break;
									case 5: 
										Events social = new Social();
										ourDate.readDate(in, 'k');
										ourTime.readTime(in, 'k');
										
										System.out.println("Enter description: ");
										social.setDescription(in.next());
										
										social = new Social(ourDate.getYear(), ourDate.getMonth(), ourDate.getDay(), ourTime.getHour(), ourTime.getMinute(),
													social.getDescription(), "");
										
										if (fileArray.checkDuplicates(social)) { fileArray.getEventsArray().add(social); fileArray.setEventToFile(true); }
										else { System.out.println("Cannot add this event. It already exists."); }
										break;
									default: 
										System.out.println("Error, try again.");
										break;
								}	
							break;
					case 2: System.out.println("Enter start date to display:");
							ourDate.readDate(in, 'k');
							System.out.println("Your events on "+ourDate+ " are:");
							fileArray.displayDayActivities(ourDate);
							break;
							
					case 3: System.out.println("Enter start date to display:");
							ourDate.readDate(in, 'k');
							OurDate temp = new OurDate(ourDate.getDay(), ourDate.getMonth(), ourDate.getYear());
							for (int i = 0; i < 6; i++)
								temp.addOne();
							System.out.println("Your activities from "+ourDate+ " until "+temp+ " are:");
							fileArray.displayWeekActivities(ourDate);
							break;
							
					case 4: System.out.println("Enter the type, date and time of the event to be deleted.");
							System.out.println("Enter the type(1 - Meeting, 2 - School, 3 - Work, 4 - Gym, 5 - Social)");
							type = in.nextInt();
							if (type > 5 || type <= 0) 
							{
								System.out.println("Invalid input.");
								continue;
							}
							ourDate.readDate(in, 'k');
							ourTime.readTime(in, 'k');
							fileArray.deleteEvent(ourDate, ourTime, type);
							fileArray.setEventToFile(false);
							break;
					case 5: fileArray.readFile();
							System.out.println("An event already exists for this date & time..... cannot enter");
							fileArray.setEventToFile(false);
							fileArray.displayArray();
							break;
					case 6: System.out.println("LIST OF EVENTS \n ****************");							
							fileArray.displayArray();
							break;
					case 7: break;
					default: System.out.println("Error. This option is not valid.");
				}
			
			} catch(InputMismatchException ime) {
				System.out.println("Please type an integer number.");
				in.next();
			}
		}
		System.out.println("Good bye... have a nice day.");
	}
}