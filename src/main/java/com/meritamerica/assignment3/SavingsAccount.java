package com.meritamerica.assignment3;

import java.util.Date;

public class SavingsAccount extends BankAccount{
	
	
	
	
	private static Date date;
	private static long accountNumber; 
	private static double balance;
	private static double interestRate ;
	
	SavingsAccount() {
		super(MeritBank.getNextAccountNumber(),balance, interestRate);
	}
	SavingsAccount(double openingBalance) {
		super(MeritBank.getNextAccountNumber(),openingBalance, interestRate);
	}
	SavingsAccount(long accountNumber, double balance, double interestRate, Date date) {
		super(accountNumber,balance, interestRate, date);
	}
	
	public static SavingsAccount readFromString(String accountData) {

		SavingsAccount savings = new SavingsAccount();

		try {

			String[] values = accountData.split(","); //System.out.println("trans: # "+ i + "   "+ trans[i] );

			

			accountNumber =    Long.parseLong(values[0]);
			balance =      Double.parseDouble(values[1]);
			interestRate = Double.parseDouble(values[2]);
			date =  savings.dateAccountOpened(values[3]);
		} catch(NumberFormatException e){ // catch exception
			throw e;					  //throw exception
		}
		savings = new SavingsAccount(accountNumber, balance, interestRate, date);
		/*
		System.out.println("Account: " + accountNumber + "\n" +
				"Balance: " + balance + "\n" + 
				"Interest Rate: " + interestRate + "\n" + 
				"Date: " + date);
		 */
		return savings;

	}
}
