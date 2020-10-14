package com.meritamerica.assignment3;


public class SavingsAccount extends BankAccount{

	final static double INTEREST_RATE = 1.0/100;
	
	SavingsAccount(double openingBalance) {
		super(openingBalance, INTEREST_RATE);
	}
}
