package com.atm.code;

public class ATMImpl implements ATMI {
	
	private static final String EMPTY_STR = "";
	private static final String AMOUNT_NOT_DISPENSABLE = "Requested withdraw amount is not dispensable\nNote: At this stage, the ATM has only two 1 dollar bills. So, the withdrawal amount cannot\r\n" + 
			"be dispensed.";
	private static final String PLEASE_COLLECT_YOUR_MONEY = "Please collect your money";
	private static final String INCORRECT_OR_INSUFFICIENT_FUND = "Incorrect or Insufficient fund.\n\n\n";
	private static final String YOUR_MONEY_HAS_BEEN_SUCCESSFULLY_DEPOSITED = "Your Money has been successfully deposited.";
	private static final String INCORRECT_DEPOSIT_AMOUNT = "Incorrect deposit amount.\n\n";
	private static final String DEPOSIT_AMOUNT_CANNOT_BE_ZERO = "Deposit amount cannot be zero.\n\n";
	private static final int DENO_20 = 20;
	private static final int DENO_10 = 10;
	private static final int DENO_5 = 5;
	private static final int DENO_1 = 1;
	private int twentys=0, tens=0, fives=0, ones=0;
    private int balance = 0, withdraw;
    
    /**
     * deposit the money to ATM based on the denomination
     */
	@Override
	public void deposit(int deno1, int deno2, int deno3, int deno4) {
		// TODO Auto-generated method stub
		int currentTotal = DENO_20 * deno1 + DENO_10*deno2 + DENO_5*deno3 + DENO_1*deno4;
		if (currentTotal == 0) {
        	System.out.print(DEPOSIT_AMOUNT_CANNOT_BE_ZERO);
        } else if (deno1 < 0 || deno2 < 0 || deno3 < 0 || deno4 < 0) {
        	System.out.print(INCORRECT_DEPOSIT_AMOUNT);
        } else {
        	this.twentys+= deno1;
    		this.tens+= deno2;
    		this.fives+= deno3;
    		this.ones+= deno4;
//        	int total = (twentys * DENO_20) + (tens * DENO_10) + (fives * DENO_5) + (ones *DENO_1);
            balance += currentTotal;
            System.out.println("Balance : 20s= " +twentys +", 10s= "+tens+", 5s= "+fives+", 1s= "+ones+", total= "+balance);
            System.out.println(YOUR_MONEY_HAS_BEEN_SUCCESSFULLY_DEPOSITED);  
            System.out.println(EMPTY_STR);
        }
		
	}
	
	/**
	 * withdraw the money from the ATM
	 */
	@Override
	public void withdraw(int amount) {
		// TODO Auto-generated method stub
		this.withdraw = amount;
		if (withdraw <= 0 || balance < withdraw) {
        	System.out.print(INCORRECT_OR_INSUFFICIENT_FUND);
        	return;
        }
		
		 if (balance >= withdraw)  {
		        
         	int tw = 0;
         	if (withdraw > DENO_20) {
         		tw = (withdraw-(withdraw%DENO_20))/DENO_20;
         		if (twentys >= tw) {
         			twentys-=tw;
         		} else {
         			tw = twentys;
         		}
         		withdraw -= tw*DENO_20;
         	}
         	int t=0;
         	if (withdraw >=DENO_10) {
         		t = withdraw/DENO_10;
         		if (tens >= t) {
         			tens-=t;
         		} else {
         			t = tens;
         			tens-=t;
         		}
         		withdraw -= t*DENO_10;
         	}
         	int f = 0;
         	if (withdraw >= DENO_5) {
         		f = withdraw/DENO_5;
         		if (fives >= f) {
         			fives-=f;
         		} else {
         			f = fives;
         			fives-=f;
         		}
         		withdraw -= f*DENO_5;
         	}
         	int o = 0;
         	if (withdraw < DENO_5) {
         		o = withdraw/DENO_1;
         		if (ones >= o) {
         			ones-=o;
         		} else {
         			o = ones;
         			ones-=o;
         		}
         		withdraw -= o*DENO_1;
         		
         	}
         	if (withdraw == 0) {
            	System.out.println(PLEASE_COLLECT_YOUR_MONEY);  
                System.out.println("========================= \n");
            	System.out.println("Dispensed : 20s= " +tw +", 10s= "+t+", 5s= "+f+", 1s= "+o);
            	
//            	int total = twentys * DENO_20 + tens * DENO_10 + fives * DENO_5 + ones *DENO_1;
            	balance = balance - amount;
            	System.out.println("Balance : 20s= " +(twentys) +", 10s= "+(tens)+", 5s= "+(fives)+", 1s= "+(ones)+", total= "+balance);
         	} else {
         		System.out.println(AMOUNT_NOT_DISPENSABLE);
         	}
         } else { 
         	System.out.println(INCORRECT_OR_INSUFFICIENT_FUND);  
         }  
         System.out.println(EMPTY_STR);  
		
	}

}
