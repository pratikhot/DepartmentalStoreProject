package com;

import java.util.Scanner;

public class Solution 
{
	public static void main(String[] args) {


		System.out.println("Welcom to Departmental Store");
		System.out.println("========================================");

		Scanner sc= new Scanner(System.in);
		//upcasting to achieve abstraction
		DepartmentalStore	store =new DepartmentalStoreImpl();

		store.addproduct();//add only once
		int choice=1;
		while(choice==1)
		{
			store.displayproduct();
			store.buyproduct();
			System.out.println("press 1 to Continue or any other number to checkout");
			choice=sc.nextInt();
		}
		store.checkout();//checkout only once
	}

}
