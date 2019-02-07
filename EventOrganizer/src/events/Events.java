package events;
/**
 * File name: Events.java
 * Author: Chrystian Rafael Sanches dos Santos, 040862854
 * Course: CST8130 - Data Structures
 * Assignment: 1
 * Date: 17/10/2017
 * Professor: Anu Thomas
 * Purpose: This is the abstract class Events which instantiates objects from OurDate and OurTime.
 * 
 * Data Fields:		- ourDate: OurDate - This is an object from the OurDate class.
 * 					- ourTime: OurTime - This is an object from the OurTime class.
 * 					- description: String - Variable that stores the value of the description field.
 * 					- location: String - Variable that stores the value of the location field.
 * 					- extra: int - Variable that stores the value of the extra field. It is only used by the Work class.
 * 
 * Methods: 		Default constructor
 * 					Copy constructor (int, int, int, int, int, String, String, int) - constructor that stores the information of all the fields from the file, including an extra field.
 * 					Copy constructor (int, int, int, int, int, String, String) - constructor that stores the information of all the fields from the file, except extra.
 *          		getType(): int - it is an abstract method that returns the type of the activity.
 * 					getDate(): OurDate - returns ourDate object.
 *          		getTime(): OurTime - returns ourTime object.
 *          		setYear(int): void - sets the year for the ourDate object.
 *          		getYear(): int - returns the year from the OurDate object.
 *          		setMonth(int): void - sets the month for the ourDate object.
 *          		getMonth(): int - returns ourDate month object.
 *          		setDay(int): void - sets the day for the ourDate object.
 *          		getDay(): int - returns the day for the ourDate object.
 *          		setHour(int): void - sets the hour for the ourTime object.
 *          		getHour(): int - returns the ourTime hour object.
 *          		setMinute(int): void - sets the minute.
 *          		getMinute(): int - returns minute.
 *          		getDescription(): String - returns description.
 *          		setDescription(String): void - sets the description.
 *          		getLocation(): String - returns the location.
 *          		setLocation(String): void - sets the location.
 *          		getExtra(): int - returns extra.
 *          		setExtra(int): void - sets extra.
 * 					toString(): String - returns a String containing the date, time and description which is standard for most of the classes that extends from Events.
 * 			
 * Class list: FileArray.java, OurDate.java, OurTime.java, Gym.java, Assign1.java, Meeting.java, School.java, Social.java, Work.java, Menu.java.
 */

import date.OurDate;
import date.OurTime;

public abstract class Events {
	private OurDate ourDate = new OurDate();
	private OurTime ourTime = new OurTime();
	private String description, location;
	private int extra;
	
	/**
	 * Default constructor.
	 */
	public Events() {}
	/**
	 * Copy constructor.
	 * @param year: int
	 * @param month: int
	 * @param day: int
	 * @param hour: int
	 * @param minute: int
	 * @param description: String
	 * @param location: String
	 * @param extra: int
	 */
	public Events(int year, int month, int day, int hour, int minute, String description, String location, int extra) 
	{
		setYear(year);
		setMonth(month);
		setDay(day);
		setHour(hour);
		setMinute(minute);
		setDescription(description);
		setLocation(location);
		setExtra(extra);
	}
	/**
	 * Copy constructor.
	 * @param year: int
	 * @param month: int
	 * @param day: int
	 * @param hour: int
	 * @param minute: int
	 * @param description: String
	 * @param location: String
	 */
	public Events(int year, int month, int day, int hour, int minute, String description, String location) 
	{
		setYear(year);
		setMonth(month);
		setDay(day);
		setHour(hour);
		setMinute(minute);
		setDescription(description);
		setLocation(location);
	}
	/**
	 * Abstract method to get the type of the activity.
	 * @return int
	 */
	public abstract int getType();
	/**
	 * Returns an OurDate object.
	 * @return ourDate: OurDate object.
	 */
	public OurDate getDate() { return ourDate; }
	/**
	 * Returns an OurTime object.
	 * @return OurTime: ourTime object.
	 */
	public OurTime getTime() { return ourTime; }
	/**
	 * Sets the year for the OurDate object.
	 * @param year: int
	 */
	public void setYear(int year) {ourDate.setYear(year);}
	/**
	 * Returns the year from the OurDate object.
	 * @return int
	 */
	public int getYear() {return ourDate.getYear();}
	/**
	 * Sets the month for the OurDate object.
	 * @param month: int
	 */
	public void setMonth(int month) {ourDate.setMonth(month);}
	/**
	 * Returns the month from the OurDate object.
	 * @return int
	 */
	public int getMonth() {return ourDate.getMonth();}
	/**
	 * Sets the day for the OurDate object.
	 * @param day: int
	 */
	public void setDay(int day) {ourDate.setDay(day);}
	/**
	 * Returns the day from the OurDate object.
	 * @return int
	 */
	public int getDay() {return ourDate.getDay();}
	/**
	 * Sets the hour for the OurTime object.
	 * @param hour: int
	 */
	public void setHour(int hour) {ourTime.setHour(hour);}
	/**
	 * Returns the hour from the OurTime object.
	 * @return int
	 */
	public int getHour() {return ourTime.getHour();}
	/**
	 * Sets the minute for the OurTime object.
	 * @param minute: int
	 */
	public void setMinute(int minute) {ourTime.setMinute(minute);}
	/**
	 * Returns the minute from the OurTime object.
	 * @return int
	 */
	public int getMinute() {return ourTime.getMinute();}
	/**
	 * Returns the description of the activity.
	 * @return String
	 */
	public String getDescription() { return description;};
	/**
	 * Sets the description.
	 * @param description: String
	 */
	public void setDescription(String description) { this.description = description; }
	/**
	 * Returns the location of the activity.
	 * @return String
	 */
	public String getLocation() { return location; };
	/**
	 * Sets the location.
	 * @param location: String
	 */
	public void setLocation(String location) { this.location = location; }
	/**
	 * Returns the extra field of the activity.
	 * @return int
	 */
	public int getExtra() { return extra;}
	/**
	 * Sets the extra field.
	 * @param extra: int
	 */
	public void setExtra(int extra) { this.extra = extra;}

	@Override
	public String toString() { 
		return "\t"+ getDate()+ " "+ getTime() + " "+ getDescription(); }
	
}
