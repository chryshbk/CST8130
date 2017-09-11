package Lab1;
import java.io.File;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Lab1 {
	
	private static Scanner in;
	
	private static void openFile() 
	{
		try 
		{
			in = new Scanner(Paths.get("src"+File.separator+"Lab1"+File.separator+"Events.txt"));
		} catch (IOException ie){
			System.err.println("Error opening the file.");
			System.exit(1);
		}
	}
	
	private static void readFile() 
	{
		try
		{
			while (in.hasNext()) 
			{		
				int t;
				System.out.printf("Type: %-7d Month: %-7d Day: %-7d Year: %-7d Hour: %-7d Minute: %-7d"
						+ "Description: %-20s Extra: %-10s%n", 
						t = in.nextInt(), +in.nextInt(), +in.nextInt(), +in.nextInt(), +in.nextInt(), 
						+in.nextInt(), in.next(), (t==1 || t==3) ? in.next(): "");
			}
		} catch (NoSuchElementException nsee)
		{
			System.err.println("Invalid file.");
		} catch (IllegalStateException iise)
		{
			System.err.println("Error reading from the file.");
		}
	}
	
	private static void closeFile() 
	{
		if (in != null)
			in.close();
	}
	public static void main(String[] args) {
		openFile();
		readFile();
		closeFile();
	}
}