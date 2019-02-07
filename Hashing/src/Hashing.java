package hybrids;

public class Hashing 
{
	public static final int NUMBER1 = 145623;
	
	public static void main(String[] args) 
	{
		Numbers numbers = new Numbers();

		for(int i = 0; i < 100; i++) {
			numbers.addNumber();
		}

		numbers.printNumbers();
	}
}
