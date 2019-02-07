package labtestpractice;

import java.util.ArrayList;

public class Bank 
{
	private int size;
	private ArrayList<Clients> clientsArray;
	
	public Bank() 
	{
		size = 100;
		clientsArray = new ArrayList<>(size);
		for(int i = 0; i < size; i++)
			clientsArray.add(i, null);
	}
	
	public void addClient(Clients client) 
	{
		int hashIndex = client.hashIndex(size);
		if (clientsArray.get(hashIndex) == null)
			clientsArray.set(hashIndex, client);
		else 
		{
			hashIndex = client.collisionsIndex(size);
			if(clientsArray.get(hashIndex) == null)
				clientsArray.set(hashIndex, client);
			else
				System.out.println("Client could not be added.");
		}
	}
	
	public void displayClients() 
	{
		for (int i = 0; i < size; i++) 
		{
			if(clientsArray.get(i) != null) 
			{
				System.out.println("Index: "+i+"\tAccount Number: "+ clientsArray.get(i).getAccountNumber() +
						" \tClient name: "+ clientsArray.get(i).getName() + 
						"    \tCurrent balance: "+ clientsArray.get(i).getBalance());
			}
		}
	}
}
