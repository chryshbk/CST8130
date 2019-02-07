
public class Recursion {

	public static void countDown (int n) {
		System.out.println(n);
		if (n > 0)
			countDown(n-1);
	}
	
	public static void countUp (int n) {
		if (n > 0)
			countUp(n-1);
		System.out.println(n);
	}
	
	public static int recurse (int n) {
		if (n > 0)
			return (n * recurse(n - 1));
		return 1;
	}
	
	public static void recursive (int n) {
		if (n >= 0) {
		System.out.println("Before");
		recursive(n - 1);
		System.out.println("After " + (n-1));
		}
	}
	
	public static void main(String[] args) {
		//countUp(3);
		//countDown(3);
		//System.out.println(recurse(5));
		recursive(2);
	}

}
