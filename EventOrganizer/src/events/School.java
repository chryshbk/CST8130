package events;
/**
 * File name: School.java
 * Author: Chrystian Rafael Sanches dos Santos, 040862854
 * Course: CST8130 - Data Structures
 * Assignment: 1
 * Date: 17/10/2017
 * Professor: Anu Thomas
 * 
 * Data Fields:		type: int - value of type for School is 2.
 * 
 * Methods: 		Default constructor.
 * 					Copy constructor(int, int, int, int, int, String, String) - Has to have one of the constructors of the abstract class.
 * 					getType() - returns its type, which is 2.
 * 
 * Class list: FileArray.java, OurDate.java, OurTime.java, Events.java, Assign1.java, Meeting.java, Gym.java, Social.java, Work.java, Menu.java.
 */

public class School extends Events{
	private final int type = 2;
	
	public School() {}
	
	public School(int year, int month, int day, int hour, int minute, String description, String location) {
		super(year, month, day, hour, minute, description, location);
	}

	@Override
	public int getType() { return type; }
}
