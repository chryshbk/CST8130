package support;
/**
 * File name: FileArray.java
 * Author: Chrystian Rafael Sanches dos Santos, 040862854
 * Course: CST8130 - Data Structures
 * Assignment: 1
 * Date: 17/10/2017
 * Professor: Anu Thomas
 * Purpose: This class has the purpose to open, read and close the file Events.txt and import all the data from the file into an ArrayList of Events. 
 * This ArrayList will sort the events by date and time, showing the year, month, day, description, location(if the type is 1 or 3) and extra (if the type is 3). 
 * Type is not shown in the ArrayList. The class also writes in the Events.txt file using PrintWriter. It uses the information from the ArrayList to write in the file.
 * 
 * Data Fields:		- file: Scanner - This Scanner is used to get the data from the file.
 * 					- fileName: String - It contains the name of the file "Events.txt".
 * 					- events: ArrayList of Events - It contains all the events from the file "Events.txt".
 * 
 *  Methods:   		default constructor
 *             		openFile(): void - opens the Events.txt file.
 *             		readFile(): void - reads the Events.txt file.
 *             		closeFile(): void - closes the Events.txt file.
 *             		setEventToFile(boolean): void - takes a boolean as a parameter, uses PrintWriter to write the content from the ArrayList of Events to the file and if the boolean is true, it will write the event at the end of the file. If it is false, it will overwrite the whole file.
 *            	 	insertionSortToFile(): ArrayList of Events - it sorts the events by type and organizes the array according to the file standard starting with type and returns the ArrayList of events.
 *             		insertionSortToArray(): void - it sorts the events by date and time, organizes the array in the ArrayList using Insertion Sort and returns the ArrayList of events.
 *             		checkDatesAndTime(OurDate, OurDate, OurTime, OurTime): boolean - checks if the date is greater than other dates and if time is greater than the time in order to organize the events by date and time.
 *			   		deleteEvent(OurDate, OurTime, int): ArrayList of Events - takes three parameters from OurDate, OurTime and Type, identifies if it matches another date with same time and deletes in case it is a duplicate.
 *			   		checkDuplicates(Events): boolean - takes one event as a parameter and checks if date and time are exactly equals and returns true in case a match happens.             
 *             		displayDayActivities(OurDate): ArrayList of Events - takes an OurDate object and checks if there is an event in the array that matches the parameter. If so, it displays the event.
 *             		displayWeekActivities(OurDate): ArrayList of Events - takes an OurDate object and loops 7 times in the array to check if an event matches the date. It adds one day every time it loops and display the events in the week.
 *             		displayArray(): void - it displays the array, organizing first by date and time using the insertionSortToArray method. Then it loops through the array, check for duplicates using the checkDuplicates method and removes any duplicate. It displays the events at the end.
 *             		getEventArray(): ArrayList of Events - getter for the ArrayList events.
 *             
 * Class list: Assign1.java, OurDate.java, OurTime.java, Events.java, Gym.java, Meeting.java, School.java, Social.java, Work.java, Menu.java.
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
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
public class FileArray
{
	private Scanner file;
	private String fileName = "Events.txt";
	private ArrayList<Events> events = new ArrayList<>();
	
	/**
	 * Default constructor.
	 */
	public FileArray() {}
	
	/**
	 * This class opens the file Events.txt using Scanner.
	 */
    public void openFile() 
    {
    	try 
    	{
    		file = new Scanner(Paths.get(fileName));
    	} catch(IOException ioe) {
    		System.out.println("Error in the file");
    		System.exit(1);
    	}
    }
    
    /**
     * Reads the file and writes it into an ArrayList of Events checking every type of event.
     */
	public void readFile() 
	{
		openFile();
		try
		{	
			while (file.hasNext()) 
			{	
				int t = file.nextInt();
				int day = file.nextInt();
				int month = file.nextInt();
				int year = file.nextInt();
				int hour = file.nextInt();
				int minute = file.nextInt();
				String description = file.next();
				String location = (t == 1 || t == 3) ? file.next() : "";
				int extra = (t == 3) ? file.nextInt() : 0;
		
				switch(t) 
				{
				case 1: Events meeting = new Meeting(year, month, day, hour, minute, description, location);
						if (checkDuplicates(meeting)) // checks if there is a similar event in the ArrayList. If there is, it will not add.
							events.add(meeting);
						break;
				case 2: Events school = new School(year, month, day, hour, minute, description, "");
						if (checkDuplicates(school))
							events.add(school);
						break;
				case 3: Events work = new Work(year, month, day, hour, minute, description, location, extra);
						if (checkDuplicates(work))
							events.add(work);
						break;
				case 4: Events gym = new Gym(year, month, day, hour, minute, description, "");
						if (checkDuplicates(gym))
							events.add(gym);
						break;
				case 5: Events social = new Social(year, month, day, hour, minute, description, "");
						if (checkDuplicates(social))
							events.add(social);
						break;
				default: System.out.println("Not a valid event.");
						 break;
				}
			}
		} catch (NoSuchElementException nsee)
		{
			System.err.println("Invalid file.");
		} catch (IllegalStateException iise)
		{
			System.err.println("Error reading from the file.");
		}
	}
	
	/**
	 * Closes the file if it is not null.
	 */
	public void closeFile() { if (file != null) file.close(); }
	
	/**
	 * Sets the Events from the ArrayList to the file Events.txt using java.io.PrintWriter and it also sorts the file organizing by type.
	 * @param b: boolean - it is either true or false, mostly used for the FileOutputStream.
	 */
	public void setEventToFile(boolean b)
	{
		try 
		{
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, b));
				
			String location = "";
			String extra = "";
			
			insertionSortToFile();
			
			for (int i = 0; i < events.size(); i++) 
			{
				if (checkDuplicates(events.get(i)))
					events.remove(i);
				if (events.get(i).getType() == 1 || events.get(i).getType() == 3)
					location = events.get(i).getLocation();
				if (events.get(i).getType() == 3) 
					extra = String.valueOf(events.get(i).getExtra());
				printWriter.println(events.get(i).getType()+ " "+ events.get(i).getDay()+ " "+ events.get(i).getMonth()+ " "+ events.get(i).getYear()+ " "+ events.get(i).getHour()+ " "+ events.get(i).getMinute()+ " "+ events.get(i).getDescription()+ " "+ location + " "+ extra);
				location = "";
				extra = "";
			}
			printWriter.close();
		} catch (FileNotFoundException fileNotFound) {
			System.out.println("File not found. Sorry");
			System.exit(1);
		}
	}
	/**
	 * It sorts the events by type and organizes the array according to the file standard starting with type and returns the ArrayList of events.
	 * @return events: ArrayList of Events.
	 */
	public ArrayList<Events> insertionSortToFile() 
	{
		int i, j;
		
		for (i = 1; i < events.size(); i++) 
		{
			Events key = events.get(i);
			
			j = i - 1;
			while((j >= 0) && (i >= 0) && (events.get(j).getType() > key.getType()))
			{
				events.set(i, events.get(j));
				j--;
				i--;
			}
			events.set(i, key);
		}
		return events;
	}
	/**
	 * It sorts the events by date and time and organizes the array in the ArrayList using Insertion Sort.
	 */
	public void insertionSortToArray() 
    {
        int i, j;

        for (i = 1; i < events.size(); i++) 
        {
        	Events key = events.get(i);
                
            j = i - 1;

            while((j >= 0) && checkDatesAndTime(events.get(j).getDate(), key.getDate(), events.get(j).getTime(), key.getTime()))
            {
               events.set(i, events.get(j));
               j -= 1;
               i -= 1;
            }
            events.set(i,key);
        }
    }
	/**
	 * Checks if the date is greater than other dates and if time is greater than the time in order to organize the events by date and time. If either, returns false, otherwise it will return true.
	 * @param date1: OurDate
	 * @param date2: OurDate
	 * @param time1: OurTime
	 * @param time2: OurTime
	 * @return boolean.
	 */
	public boolean checkDatesAndTime(OurDate date1, OurDate date2, OurTime time1, OurTime time2) 
	{
		if (date1.isGreater(date2)) { return false; }
		if (date1.isEqual(date2) && time1.isGreater(time2)) { return false; }
		
		return true;
	}
	/**
	 * Takes three parameters from OurDate, OurTime and Type, identifies if it matches another date with same time and deletes in case it is a duplicate.
	 * @param date: OurDate
	 * @param time: OurTime
	 * @param type: int
	 * @return events: ArrayList of Events.
	 */
	public ArrayList<Events> deleteEvent(OurDate date, OurTime time, int type)
	{
		String message = "No events at this date and time";
		for (int i = 0; i < events.size(); i++) 
		{
			if (date.isEqual(events.get(i).getDate()) && time.isEqual(events.get(i).getTime()) && events.get(i).getType() == type) 
			{
				events.remove(i);
				message = "Event removed";
			}
		}
		System.out.println(message);
		return events;
	}
	/**
	 * Takes one event as a parameter and checks if date and time are exactly equals and returns true in case a match happens.
	 * @param e: Events
	 * @return boolean
	 */
	public boolean checkDuplicates(Events e) 
	{
		int counter = 0;
		for(int i = 0; i < events.size(); i++)
		{
			if (events.get(i).getDate().isEqual(e.getDate()) && events.get(i).getTime().isEqual(e.getTime())) 
				counter++;
		}
		if (counter == 0) return true;
		
		return false;
	}
	/**
	 * Takes an OurDate object and checks if there is an event in the array that matches the parameter. If so, it displays the event.
	 * @param date: OurDate
	 * @return events: ArrayList of Events.
	 */
	public ArrayList<Events> displayDayActivities(OurDate date)
	{
		for (Events e : events) 
		{
			if (date.isEqual(e.getDate())) { System.out.println(e); }
		}
		return events;
	}
	/**
	 * Takes an OurDate object and loops 7 times in the array to check if an event matches the date. It adds one day every time it loops and display the events in the week.
	 * @param date: OurDate
	 * @return events: ArrayList of Events.
	 */
	public ArrayList<Events> displayWeekActivities(OurDate date)
	{
		for (int i = 0; i < 6; i++) 
		{
			displayDayActivities(date);
			date.addOne();
		}
		return events;
	}
	/**
	 * It displays the array, organizing first by date and time using the insertionSortToArray method. Then it loops through the array, check for duplicates using the checkDuplicates method and removes any duplicate. It displays the events at the end.
	 */
	public void displayArray() 
	{
		insertionSortToArray();
		for (Events e : events) 
		{
			if (checkDuplicates(e)) 
				events.remove(e);
			System.out.println(e.toString());
		}
		
		System.out.println();
	}
	/**
	 * Getter for the ArrayList events.
	 * @return events: ArrayList of Events.
	 */
	public ArrayList<Events> getEventsArray(){ return events; }
}
