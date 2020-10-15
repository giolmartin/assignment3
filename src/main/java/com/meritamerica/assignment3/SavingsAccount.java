package com.meritamerica.assignment3;

import java.util.Date;

public class SavingsAccount extends BankAccount{
	
	
	
	private static String[] array = new String[4];
	private static Date date;
	private static long accountNumber; 
	private static double balance;
	private static double interestRate= 0;
	
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
	
		String[] trans = new String[4] ;
		double[] values = new double[4];
		
		try {
		for(int i = 0; i < 4 ; i++) {
			trans = accountData.split(","); //System.out.println("trans: # "+ i + "   "+ trans[i] );
			array[i] = trans[i];
		} 
		for (int i = 0; i < 3 ; i ++) {//<----separate strings
			values[i] = Double.parseDouble(array[i]);
		} //---> strings converted to doubles.	
		} catch(NumberFormatException e){ // catch exception
			throw e;					  //throw exception
		}
		SavingsAccount s = new SavingsAccount();
		
		// created instance to be able to call .dateAccountOpened 
		date = s.dateAccountOpened(trans[3]);
		//System.out.println("Savings DAte: " + date);
		accountNumber = (long)values[0];
		balance = values[1];
		interestRate = values[2];
		
		s = new SavingsAccount(accountNumber, balance, interestRate, date);
		/*
		System.out.println("Account: " + accountNumber + "\n" +
				"Balance: " + balance + "\n" + 
				"Interest Rate: " + interestRate + "\n" + 
				"Date: " + date);
		*/
		return s;
	
		/*BankAccount b  ;
		b = new BankAccount((long) values[0], values[1], values[2]);
		System.out.println(b.dateAccountOpened(trans[3]));


		System.out.println(b.getBalance());
		System.out.println(b.getInterestRate());
		*/
		
	}
}
