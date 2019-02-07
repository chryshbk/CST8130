package practice;

import java.util.Random;

public class BigONotation {
	private int arraySize;
	private int[] intArray;
	private int itemsInArray = 0;
	static long startTime;
	static long endTime;
	
	public static void main(String[] args) {
		
		BigONotation testAlgo1 = new BigONotation(1000000);
		testAlgo1.generateNumbers();
		
		BigONotation testAlgo2 = new BigONotation(20000);
		testAlgo2.generateNumbers();

		BigONotation testAlgo3 = new BigONotation(30000);
		testAlgo3.generateNumbers();
		
		BigONotation testAlgo4 = new BigONotation(40000);
		testAlgo4.generateNumbers();
		
		//testAlgo1.linearSearchForValue(20);
	//	testAlgo1.bubbleSort();
	//	testAlgo2.bubbleSort();
		
	//	testAlgo1.binarySearchForValue(20);
	//	testAlgo2.binarySearchForValue(20);
		
		startTime = System.currentTimeMillis();
		
		testAlgo1.quickSort(0, testAlgo1.itemsInArray);
		
		endTime = System.currentTimeMillis();
		System.out.println("Quick sort took: " + (endTime - startTime));
		
	}
	
	public BigONotation() {
		arraySize = 0;
	}
	
	public BigONotation(int arraySize) 
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
		itemsInArray = arraySize - 1;
	}
	
	// O(1)
	public void addItemToArray(int item) {
		intArray[itemsInArray++] = item; 
	}
	
	// O(N)
	public void linearSearchForValue(int value) 
	{
		boolean valueInArray = false;
		String indexsWithValue = "";
		
		startTime = System.currentTimeMillis();
		
		for (int i = 0; i < arraySize - 1; i++) 
		{
			
			if (intArray[i] == value) 
			{
				valueInArray = true;
				indexsWithValue += i + " ";
			}
		}
		
		System.out.println("Value found: " + valueInArray + indexsWithValue);
		endTime = System.currentTimeMillis();
		System.out.println("Linear search took " + (endTime - startTime));
	}

	// O(N^2)
	public void bubbleSort() {
		
		startTime = System.currentTimeMillis();
		
		for (int i = arraySize - 1; i > 1; i--) {
			
			for(int j = 0; j < i; j++) {
				
				if (intArray[j] > intArray[j+1]) {
					swap(j, j+1);
				}
			}
		}
		
		endTime = System.currentTimeMillis();
		System.out.println("BubbleSort took: " + (endTime - startTime));
	}
	
	public void insertionSort(int[] arr){
		  for(int x = 1; x < arr.length; x++)
		    for(int y = x; y > 0 && arr[y-1] > arr[y]; y--){
		        swap(y, y-1);
		    }
	}
	
	//O log N
	public void binarySearchForValue(int value) {
		
		startTime = System.currentTimeMillis();
		
		int lowIndex = 0;
		int highIndex = arraySize - 1;
		int timesThrough = 0;
		
		while (lowIndex <= highIndex) {
			
			int middleIndex = (highIndex + lowIndex) / 2;
			
			if (intArray[middleIndex] < value)
				lowIndex = middleIndex + 1;
			
			else if (intArray[middleIndex] > value)
				highIndex = middleIndex - 1;
			
			else {
				System.out.println("Found match in index: " + middleIndex);
				lowIndex = highIndex + 1;
			}
			
			timesThrough++;
		}
		
		endTime = System.currentTimeMillis();
		System.out.println("Binary search took: " + (endTime - startTime));
		System.out.println("Times through: "+timesThrough);
	}
	
	// O(n log n)
	
	public void quickSort(int left, int right) {
		
		if (right - left <= 0)
			return;
		
		else {
			int pivot = intArray[right];
			int pivotLocation = partitionArray(left, right, pivot);
			quickSort(left, pivotLocation - 1);
			quickSort(pivotLocation + 1, right);
		}
		
	}
	
	public int partitionArray(int left, int right, int pivot) {
		
		int leftPointer = left - 1;
		int rightPointer = right;
		
		while(true) {
			
			while(intArray[++leftPointer] < pivot)
				;
			
			while(rightPointer > 0 && intArray[--rightPointer] > pivot)
				;
			
			if (leftPointer >= rightPointer) {
				break;
			} else {
				swap(leftPointer, rightPointer);
			}
		}
		
		swap(leftPointer, right);
		return leftPointer;
	}
	
	public void swap(int indexOne, int indexTwo) 
	{
		int temp = intArray[indexOne];
		intArray[indexOne] = intArray[indexTwo];
		intArray[indexTwo] = temp;
	}
}
