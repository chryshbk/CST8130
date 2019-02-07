package lab4;

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
		int mid = (low + high) /2;
		int location = -1;
		
		do 
		{
			if (key == intArray[mid])
				location = mid;
			else if (key < intArray[mid])
				high = mid - 1;
			else
				low = mid + 1;
			
			mid = (low + high) / 2;
		} while ((low <= high) && (location == -1));
		return location;
	}
	
	private int recBinSearch(int k, int low, int high) {
		if (low > high) return -1;
		
		int mid = (low + high) / 2;
		
		if (intArray[mid] == k){
			return mid;
		} else if (intArray[mid] < k) {
			return recBinSearch(k, mid + 1, high);
		} else {
			return recBinSearch(k, low, mid - 1);
		}
	}
	
	public int recBinSearch(int k) { return recBinSearch(k, 0, intArray.length-1); }
	
	public void recQuickSort(int left, int right) 
	{
		int index = partition(left, right);
		if (left < index -1) 
			recQuickSort(left, index - 1);
		if (index < right)
			recQuickSort(index, right);
	}
	
	private int partition (int left, int right) 
	{
		int mid = intArray[(left + right) / 2]; // pivot
		while (left <= right) {
			while (intArray[left] < mid) left++;
			
			while (intArray[right] > mid) right--;
			
			if (left <= right) {
				swapElements(left, right);
				left++;
				right--;
			}
		}
		return left;
	}
	
	public void bubbleSort() {

		for (int i = arraySize - 1; i > 1; i--) {
			
			for(int j = 0; j < i; j++) {
				
				if (intArray[j] > intArray[j+1]) {
					swapElements(j, j+1);
				}
			}
		}
	}
	
	public int linearSearch(int key) {
		for (int i = 0; i < intArray.length; i++) {
			if (intArray[i] == key)
				return i;
		}
		return -1;
	}
	
	private void swapElements (int a, int b) 
	{
		int temp = intArray[a];
		intArray[a] = intArray[b];
		intArray[b] = temp;
	}
	
	public void sortArray() {
		System.out.println("Array in sorted order\n");
		Arrays.sort(intArray);
		System.out.println(Arrays.toString(intArray)+"\n");
	}
}
