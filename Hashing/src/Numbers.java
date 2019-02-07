package hybrids;

import java.util.ArrayList;

public class Numbers 
{
	private int size;
	private ArrayList<Number> numbers;
	
	Numbers()
	{
		size = 100;
		numbers = new ArrayList<Number>(size);
		for(int i = 0; i < size; i++)
			numbers.add(i, null);
	}
	
	Numbers(int s)
	{
		size = s;
		numbers = new ArrayList<Number>(s);
		for(int i = 0; i < size; i++)
			numbers.add(i, null);
	}
	
	void addNumber() 
	{
		Number num = new Number();
		num.readNumber();
		int hashIndex = num.hashIndex(size);
		if(numbers.get(hashIndex) == null)
			numbers.set(hashIndex, num);
		else 
		{
			hashIndex = num.collisionsIndex(size);
			if(numbers.get(hashIndex) == null)
				numbers.set(hashIndex, num);
		}
	}
	
	void printNumbers() 
	{
		System.out.println("**********************************************************************\n"
				+          "Number    last two digits   middle two digits   last digits of sum");
		for(int i = 0; i < size; i++) 
		{
			if(numbers.get(i) != null )
			{
				System.out.println(numbers.get(i).getNumber() + "          " 
						+ getDigits(numbers.get(i).getNumber(), 4, 6) + "              " 
						+ getDigits(numbers.get(i).getNumber(), 2, 4) + "              "
						+ sumNumbers(numbers.get(i).getNumber())); 
			}
		}
		System.out.println("**********************************************************************");
	}

	int getDigits(int i, int firstNum, int secondNum)
	{
		String s = String.valueOf(i);
		return Integer.parseInt(s.substring(firstNum,secondNum));
	}

	int sumNumbers(int i)
	{
		String s = String.valueOf(i);
		int total = 0;
		
		for (int j = 0; j < s.length(); j++)
		{
			total = total + Integer.parseInt(s.substring(j, j+1));
		}
		
		return total;
	}
}
