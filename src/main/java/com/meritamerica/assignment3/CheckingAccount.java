package com.meritamerica.assignment3;



public class CheckingAccount extends BankAccount{
	
	final static double INTEREST_RATE = 0.1/100;

	CheckingAccount(double openingBalance) {
		super(MeritBank.getNextAccountNumber(),openingBalance,INTEREST_RATE);
	}	
	
	public static CheckingAccount readFromString(String accountData) {
		
		return null;
	}
}

