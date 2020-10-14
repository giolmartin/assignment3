package com.meritamerica.assignment3;

public class CheckingAccount extends BankAccount{
	
	final static double INTEREST_RATE = 0.1/100;

	CheckingAccount(double openingBalance) {
		super(openingBalance,INTEREST_RATE);
	}	
}
