package eventorganizer;
/**
 * File name: EventOrganizer.java
 * Author: Chrystian Rafael Sanches dos Santos, 040862854
 * Course: CST8130 - Data Structures
 * Assignment: 1
 * Date: 17/10/2017
 * Professor: Anu Thomas
 * Purpose: This is the main class which instantiates an object from the Menu class and the FileArray class.
 * 
 * Methods:		main(String []): static void
 * 
 * Class list: FileArray.java, OurDate.java, OurTime.java, Events.java, Gym.java, Meeting.java, School.java, Social.java, Work.java, Menu.java.
 */

import support.FileArray;
import support.Menu;
/**
 * @author Chrystian Rafael Sanches dos Santos, Student number: 040862854
 * @version 1.0.0
 * @see assign1
 * @since 2017-10-17
 *
 */
public class EventOrganizer {
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		FileArray file = new FileArray();
		
		menu.openMenu();
		file.closeFile();

    }
}
