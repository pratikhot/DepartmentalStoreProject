package com;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DepartmentalStoreImpl implements DepartmentalStore
{
	//key->product id & value->product instance
	Map<Integer,Product> db = new LinkedHashMap<Integer,Product>();
	Scanner sc =new Scanner(System.in);
	int totalbill=0;
	int cost;
	@Override
	public void addproduct()
	{
		db.put(1, new Product("chocalate",10,5));
		db.put(2, new Product("biscuit",20,10));
		db.put(3, new Product("icecream",30,20));
	}
	@Override
	public void displayproduct()
	{
		Set<Integer>keys=db.keySet();
		for(int key:keys)
		{
			Product p=db.get(key);
			System.out.println("Enter "+ key+" to order "+p.getName());
			System.out.println("Available quantity "+p.getQuantity());
			System.out.println("Coast Rs. "+p.getCoast());
			System.out.println("--------------------------------------------");
		}

	}
	@Override
	public void buyproduct() 
	{
		System.out.println("Enter a Choice");//choice=>key
		int choice=sc.nextInt();
		
		//get() return null when key (choice) are not present
		
		Product p =db.get(choice);//getting the product based on choice
		if(p!=null)
		{
			//logic for buying product
			System.out.println("Buying "+ p.getName());
			System.out.println("Enter The Quantity");

	int quantity =sc.nextInt();
			if(quantity<=p.getQuantity())
			{
				//calculating  current product cost
				int productcost=quantity*p.getCoast();

				//adding the current product cost to total bill
				totalbill = totalbill+productcost;

				// updating the new quantity

				p.setQuantity(p.getQuantity()-quantity);

				System.out.println("Ordered"+quantity+" "+p.getName());

				System.out.println("Current Product Cost is Rs."+productcost);

				System.out.println("Total Bill As Of Now: Rs."+totalbill);

			}

			else
			{
				try {
					String  message= p.getName()+" not avaialbe";
					throw new InvalidQuantityException(message);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}

			}

		}
		else
		{
			try {
				String message="invalid choice kindly Enter valid choice";
				throw new InvalidChoiceException(message);
			}
			catch(Exception e){
				System.out.println(e.getMessage());	
			}
		}



	}
	@Override
	public void checkout()
	{
		System.out.println("Total bill "+totalbill +"Rs");
		System.out.println(" 👋👋 visit Again 👋👋");

	}
}
