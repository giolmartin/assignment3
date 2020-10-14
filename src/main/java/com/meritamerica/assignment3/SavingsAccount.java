package com.meritamerica.assignment3;



public class SavingsAccount extends BankAccount{

	final static double INTEREST_RATE = 1.0/100;
	
	SavingsAccount(double openingBalance) {
		super(MeritBank.getNextAccountNumber(),openingBalance, INTEREST_RATE);
	}
public static SavingsAccount readFromString(String accountData) {
		
		return null;
	}
}
