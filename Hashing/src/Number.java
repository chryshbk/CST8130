package hybrids;

public class Number {
	private int number;
	
	Number(){}
	
	Number(int num){ number = num; }
	
	int hashIndex(int size) { return number % size; }
	
	int collisionsIndex(int size) {	return number > 1 ? number % size : 0; }
	
	void readNumber() { number = (int) (145623 + (Math.random() * 100)); }
	
	int getNumber() { return number; }
	
}
