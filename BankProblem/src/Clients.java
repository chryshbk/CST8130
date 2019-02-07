package labtestpractice;

public class Clients 
{
	private String name;
	private float balance;
	private int accountNumber;
	
	public Clients() {}
	
	public Clients(int accountNumber, String name, float balance) 
	{
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}
	
	public int hashIndex(int size) { return accountNumber % size; }
	
	public int collisionsIndex(int size) { return accountNumber > 1 ? accountNumber % size : 0; }
	
	public String getName() { return name; }
	
	public float getBalance() { return balance; }
	
	public int getAccountNumber() { return accountNumber; }
}
