package com.atm.singleclass.code;

import java.io.IOException;
import java.util.Scanner;

public class ATM {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int twentys=0, tens=0, fives=0, ones=0;
	    int balance = 0, withdraw;  
	    @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
	    
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
            		int amount = withdraw;
                    if (withdraw <= 0 || balance < withdraw) {
                    	System.out.print("Incorrect or Insufficient fund.\n\n\n");
                    	break;
                    }
                    if (balance >= withdraw)  {
        
		            	int tw = 0;
		            	if (withdraw > 20) {
		            		tw = (withdraw-(withdraw%20))/20;
		            		if (twentys >= tw) {
		            			twentys-=tw;
		            		} else {
		            			tw = twentys;
		            		}
		            		withdraw -= tw*20;
		            	}
		            	int t=0;
		            	if (withdraw >=10) {
		            		t = withdraw/10;
		            		if (tens >= t) {
		            			tens-=t;
		            		} else {
		            			t = tens;
		            			tens-=t;
		            		}
		            		withdraw -= t*10;
		            	}
		            	int f = 0;
		            	if (withdraw >= 5) {
		            		f = withdraw/5;
		            		if (fives >= f) {
		            			fives-=f;
		            		} else {
		            			f = fives;
		            			fives-=f;
		            		}
		            		withdraw -= f*5;
		            	}
		            	int o = 0;
		            	if (withdraw < 5) {
		            		o = withdraw/1;
		            		if (ones >= o) {
		            			ones-=o;
		            		} else {
		            			o = ones;
		            			ones-=o;
		            		}
		            		withdraw -= o*1;
		            		
		            	}
		            	if (withdraw == 0) {
		        		
			            	System.out.println("Please collect your money");  
			                System.out.println("========================= \n");
			            	System.out.println("Dispensed : 20s= " +tw +", 10s= "+t+", 5s= "+f+", 1s= "+o);
			            	
//			            	int total = twentys * 20 + tens * 10 + fives * 5 + ones *1;
			            	balance = balance - amount;
			            	System.out.println("Balance : 20s= " +(twentys) +", 10s= "+(tens)+", 5s= "+(fives)+", 1s= "+(ones)+", total= "+balance);
		            	} else {
		            		System.out.println("Requested withdraw amount is not dispensable\nNote: At this stage, the ATM has only two 1 dollar bills. So, the withdrawal amount cannot\r\n" + 
		            				"be dispensed.");
		            	}
                    } else { 
                    	System.out.println("Incorrect or Insufficient fund.\n\n\n");  
                    }  
                    System.out.println("");  
                    break;
                case 2:  
                    
                    System.out.print("Enter money to be deposited:\n");  
                    while(true) {             
	                    System.out.print("Enter the denomination 20s:");
	                    int tw = sc.nextInt();
	                    twentys+= tw;  
	                    System.out.print("Enter the denomination 10s:"); 
	                    int t = sc.nextInt();
	                    tens+= t;
	                    System.out.print("Enter the denomination 5s:"); 
	                    int f = sc.nextInt();
	                    fives+= f;  
	                    System.out.print("Enter the denomination 1s:"); 
	                    int o = sc.nextInt();
	                    ones+= o;
	                    System.out.println("Deposit : 20s= " +twentys +", 10s= "+tens+", 5s= "+fives+", 1s= "+ones);
	                    int total = tw * 20 + t * 10 + f * 5 + o *1;
	                    if (total == 0) {
	                    	System.out.print("Deposit amount cannot be zero.\n\n");
	                    } else if (tw < 0 || t < 0 || f < 0 || o < 0) {
	                    	System.out.print("Incorrect deposit amount.\n\n");
	                    } else {
		                    balance += total;
		                    System.out.println("Balance : 20s= " +twentys +", 10s= "+tens+", 5s= "+fives+", 1s= "+ones+", total= "+balance);
		                    System.out.println("Your Money has been successfully deposited.");  
		                    System.out.println("");
	                    }
	                    break; 
                    }
            }
	    }
	  }
}
