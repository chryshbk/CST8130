package lab2;

import java.util.Arrays;
import java.util.Random;

public class Numbers {
	private int [] intArray;
	private int arraySize;
	
	public Numbers() {
		this.arraySize = 0;
	}
	
	public Numbers(int arraySize) 
	{ 
		this.arraySize = arraySize;
		intArray = new int[arraySize];
	}
	
	public void generateNumbers() 
	{ 
		Random rnd = new Random();
		for (int i = 0; i<=arraySize-1; i++) {
			intArray[i] = rnd.nextInt(50)+1;
		}
	}
	
	public int count(int o) 
	{
		int count = 0;
		for (int i : intArray) 
		{
			if (i == o) 
				count++;
		}
		return count;
	}

	@Override
	public String toString() { return Arrays.toString(intArray); }
}