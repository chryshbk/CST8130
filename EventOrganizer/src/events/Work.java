package events;
/**
 * File name: Work.java
 * Author: Chrystian Rafael Sanches dos Santos, 040862854
 * Course: CST8130 - Data Structures
 * Assignment: 1
 * Date: 17/10/2017
 * Professor: Anu Thomas
 * 
 * Data Fields:		type: int - value for work type is 3.
 * 
 * Methods: 		Default constructor.
 * 					Copy constructor (int, int, int, int, int, String, String, int) - Has to have one of the constructors of the abstract class.
 * 					getType(): int - returns its type, which is 3.
 * 
 * Class list: FileArray.java, OurDate.java, OurTime.java, Events.java, Assign1.java, Meeting.java, School.java, Gym.java, Social.java, Menu.java.
 */

public class Work extends Events{
	private final int type = 3;
	
	public Work() {}
	
	public Work(int year, int month, int day, int hour, int minute, String description, String location, int extra) {
		super(year, month, day, hour, minute, description, location, extra);
	}
	
	@Override
	public int getType() { return type; }
	
	@Override
	public String toString() { 
		return "\t"+ getDate()+ " "+ getTime() + " "+ getDescription()+ " at "+ getLocation() + " for "+ getExtra()+ " hours"; 
	}

}
