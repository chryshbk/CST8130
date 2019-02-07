package lab3;

import java.util.Arrays;
import java.util.Random;

public class Numbers {
	private int arraySize;
	private int[] intArray;
	
	public Numbers() {
		arraySize = 0;
	}
	
	public Numbers(int arraySize) 
	{ 
		this.arraySize = arraySize;
		this.intArray = new int[arraySize];
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
	public String toString() 
	{
		return Arrays.toString(intArray);
	}
	
	public int binSearch(int key) {
		int low = 0;
		int high = intArray.length-1;
		int mid = (low + high +1) /2;
		int location = -1;
		
		do 
		{
			if (key == intArray[mid])
				location = mid;
			else if (key < intArray[mid])
				high = mid - 1;
			else
				low = mid + 1;
			
			mid = (low + high + 1) / 2;
		} while ((low <= high) && (location == -1));
		return location;
	}
	
	public int recBinSearch(int key, int low, int high) {
		if (low > high) return -1;
		
		int mid = (low + high) / 2;
		
		if (intArray[mid] == key){
			return mid;
		} else if (intArray[mid] < key) {
			return recBinSearch(key, mid + 1, high);
		} else {
			return recBinSearch(key, low, mid - 1);
		}
	}
	
	public int recBinSearch(int k) {
		return recBinSearch(k, 0, intArray.length-1);
	}
	
	public void sortArray() {
		System.out.println("Array in sorted order\n");
		Arrays.sort(intArray);
		System.out.println(Arrays.toString(intArray)+"\n");
	}
}