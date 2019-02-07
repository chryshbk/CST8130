package assign1;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileUtils {
	private Scanner file = new Scanner(System.in);
	private ArrayList<Events> events = new ArrayList<>();
	private SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	public FileUtils() {}
	
    public void openFile() 
    {
    	try {
    		file = new Scanner(Paths.get("Events.txt"));
    	} catch(IOException ioe) {
    		System.out.println("Error in the file");
    		System.exit(1);
    	}
    }
    
	public void readFile() 
	{
		try
		{
			events = new ArrayList<>();
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
				String extra = (t == 3) ? file.next() : "";
		
				switch(t) 
				{
				case 1: Events meeting = new Meeting(year, month, day, hour, minute, description, location, "");
						events.add(meeting);
						break;
				case 2: Events school = new School(year, month, day, hour, minute, description, "", "");
						events.add(school);
						break;
				case 3: Events work = new Work(year, month, day, hour, minute, description, location, extra);
						events.add(work);
						break;
				case 4: Events gym = new Gym(year, month, day, hour, minute, description, "", "");
						events.add(gym);
						break;
				case 5: Events social = new Social(year, month, day, hour, minute, description, "", "");
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
	
	public void closeFile() 
	{
		if (file != null)
			file.close();
	}
	
	public void insertionSort() 
    {
        int i, j;

        for (i = 1; i < events.size(); i++) 
        {
            try 
            {
                Events key = events.get(i);
                
                j = i-1;

                String date1 = String.valueOf(events.get(j).getYear() + "-" + events.get(j).getMonth() + "-" 
                        + events.get(j).getDay() + " " + events.get(j).getHour() + ":" + events.get(j).getMinute());
                
                String date2 = String.valueOf(key.getYear() + "-" + key.getMonth() + "-" 
                        + key.getDay() + " " + key.getHour() + ":" + key.getMinute());

                Date dateTemp1 = simpleFormat.parse(date1);
                Date dateTemp2 = simpleFormat.parse(date2);

                while(j >= 0 && dateTemp1.after(dateTemp2)) 
                {
                    events.set(j+1, events.get(j));

                    j -= 1;
                    i -= 1;
                }
                events.set(j+1,key);
            } catch (ParseException parse) {
            	System.err.println("Error. Shutting down.");
            	System.exit(1);
            }
        }
    }
	
	public void displayArray() 
	{
		insertionSort();
		
		for (Events e : events)
			System.out.println(e.toString());
		
		System.out.println();
	}
	
	public ArrayList<Events> getEventsArray(){
		return events;
	}
}
