package com.atm.code;

import org.junit.Test;

public class ATMImplTest {
	
	ATMImpl atmImpl = new ATMImpl();
	
	@Test
	public void givenDenominationAllZeroDepositThenReturnError() {
		atmImpl.deposit(0, 0, 0, 0);
	}
	
	@Test
	public void givenDenomination1NegativeDepositThenReturnError() {
		atmImpl.deposit(-2, 0, 0, 0);
	}
	
	@Test
	public void givenDenomination2NegativeDepositThenReturnError() {
		atmImpl.deposit(0, -2, 0, 0);
	}
	
	@Test
	public void givenDenomination3NegativeDepositThenReturnError() {
		atmImpl.deposit(0, 0, -2, 0);
	}
	
	@Test
	public void givenDenomination4NegativeDepositThenReturnError() {
		atmImpl.deposit(0, 0, 0, -2);
	}
	@Test
	public void givenDenominationThenDepositAmount() {
		atmImpl.deposit(2, 3, 1, 1);
	}
	@Test
	public void givenWithdrawAmountThenReturnTheAmount() {
		atmImpl.deposit(2, 3, 1, 1);
		atmImpl.withdraw(20);
	}
	
	@Test
	public void givenWithdrawAmountThenReturnTheInsufficientFund() {
		atmImpl.deposit(0, 0, 1, 1);
		atmImpl.withdraw(20);
	}
	
	@Test
	public void givenWithdrawAmountNegativeThenReturnTheInsufficientFund() {
		atmImpl.deposit(0, 0, 1, 1);
		atmImpl.withdraw(-20);
	}
	
	@Test
	public void givenWithdrawAmountZeroThenReturnTheInsufficientFund() {
		atmImpl.deposit(0, 0, 1, 1);
		atmImpl.withdraw(0);
	}
}
