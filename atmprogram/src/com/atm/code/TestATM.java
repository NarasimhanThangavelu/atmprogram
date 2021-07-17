package com.atm.code;

import java.util.Scanner;

public class TestATM {
	
	public static void main(String[] args) {
		int twentys=0, tens=0, fives=0, ones=0;
	    int withdraw; 
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		ATMI atm = new ATMImpl();
		while(true) {
	        System.out.println("Automated Teller Machine");
	        System.out.println("========================");
	        System.out.println("Choose 1 for Withdraw");  
	        System.out.println("Choose 2 for Deposit");  
	        System.out.print("Choose the operation you want to perform:");  
	          
	        int choice = sc.nextInt();  
	        
	        switch(choice) { 
	        
	        	case 1:  
	        		System.out.print("Enter money to be withdrawn:");  
	        		withdraw = sc.nextInt();
	        		atm.withdraw(withdraw);
        		break;
	        	case 2:  
                
	                System.out.print("Enter money to be deposited:\n");  
	                while(true) {             
	                    System.out.print("Enter the denomination 20s:"); 
	                    twentys= sc.nextInt();  
	                    System.out.print("Enter the denomination 10s:"); 
	                    tens= sc.nextInt();
	                    System.out.print("Enter the denomination 5s:"); 
	                    fives= sc.nextInt();  
	                    System.out.print("Enter the denomination 1s:"); 
	                    ones= sc.nextInt();
	                    System.out.println("Deposit : 20s= " +twentys +", 10s= "+tens+", 5s= "+fives+", 1s= "+ones);
	                    atm.deposit(twentys, tens, fives, ones);
	                    break;
	                }
	        }
	    }
	}
}
