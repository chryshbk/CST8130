package assign1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	private OurTime ourTime = new OurTime();
	private OurDate ourDate = new OurDate();
	private FileUtils fileUtils = new FileUtils();
	private Scanner in = new Scanner (System.in);
	private String description;
	
	public void menu() 
	{
		int choice = 0;
		
		while (choice != 7) {
		
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
									description = in.next();
									meeting.setDescription(description);
									
									System.out.println("Enter location: ");
									meeting.setLocation(in.next());
									
									meeting = new Meeting(ourDate.getYear(), ourDate.getMonth(), ourDate.getDay(), ourTime.getHour(), ourTime.getMinute(),
												meeting.getDescription(), meeting.getLocation(), "");
									
									fileUtils.getEventsArray().add(meeting);
									break;
								case 2: 
									Events school = new School();
									ourDate.readDate(in, 'k');
									ourTime.readTime(in, 'k');
									
									System.out.println("Enter description: ");
									school.setDescription(in.next());
									
									school = new School(ourDate.getYear(), ourDate.getMonth(), ourDate.getDay(), ourTime.getHour(), ourTime.getMinute(),
												school.getDescription(), "", "");
									
									fileUtils.getEventsArray().add(school);
									break;
								case 3: 
									Events work = new Work();
									ourDate.readDate(in, 'k');
									ourTime.readTime(in, 'k');
									
									System.out.println("Enter description: ");
									work.setDescription(in.next());
									
									System.out.println("Enter location: ");
									work.setLocation(in.next());
									
									System.out.print("Enter working hours: ");
									work.setExtra(in.next());
									
									work = new Work(ourDate.getYear(), ourDate.getMonth(), ourDate.getDay(), ourTime.getHour(), ourTime.getMinute(),
												work.getDescription(), work.getLocation(), work.getExtra());
									
									fileUtils.getEventsArray().add(work);
									break;
								case 4: 
									Events gym = new Gym();
									ourDate.readDate(in, 'k');
									ourTime.readTime(in, 'k');
									
									System.out.println("Enter description: ");
									gym.setDescription(in.next());
									
									gym = new Gym(ourDate.getYear(), ourDate.getMonth(), ourDate.getDay(), ourTime.getHour(), ourTime.getMinute(),
												gym.getDescription(), "", "");
									
									fileUtils.getEventsArray().add(gym);
									break;
								case 5: 
									Events social = new Social();
									ourDate.readDate(in, 'k');
									ourTime.readTime(in, 'k');
									
									System.out.println("Enter description: ");
									social.setDescription(in.next());
									
									social = new Social(ourDate.getYear(), ourDate.getMonth(), ourDate.getDay(), ourTime.getHour(), ourTime.getMinute(),
												social.getDescription(), "", "");
									
									fileUtils.getEventsArray().add(social);
									break;
								default: 
									System.out.println("Error, try again.");
									break;
							}
											
							break;
					case 2: System.out.println("Enter start date to display:");
							ourDate.readDate(in, 'k');
							break;
					case 3: break;
					case 4: break;
					case 5: fileUtils.readFile();
							break;
					case 6: System.out.println("LIST OF EVENTS \n ****************");
							fileUtils.displayArray();
							break;
					case 7: break;
					default: System.out.println("Error. This option is not valid. Try again.");
				}
			
			} catch(InputMismatchException ime) {
				System.out.println("Please type an integer number.");
				in.next();
			}
		}
		System.out.println("Good bye... have a nice day.");
	}
}
