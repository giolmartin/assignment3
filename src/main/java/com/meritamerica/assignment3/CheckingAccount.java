package com.meritamerica.assignment3;

import java.text.DateFormat;
import java.lang.NumberFormatException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckingAccount extends BankAccount{
	
	private static double interestRate = 0;
	private static String[] array = new String[4];
	private static Date date ;
	private static long accountNumber;
	private static double balance;
	private static CheckingAccount checking;

	CheckingAccount() {
		super(MeritBank.getNextAccountNumber(),balance,interestRate, date);
	}
	CheckingAccount(double openingBalance) {
		super(MeritBank.getNextAccountNumber(),openingBalance,interestRate  );
	}	
	CheckingAccount(long accountNumber, double balance, double interestRate, Date date){
		super(accountNumber,balance,interestRate, date);
	}
	public CheckingAccount(double balance, double interestRate) {
		super(balance,interestRate);
	}
	
	
	
	public static CheckingAccount readFromString(String accountData) {
		
		String[] trans = new String[4] ;
		double[] values = new double[4];
		
		try {
			for(int i = 0; i < 4 ; i++) {
				trans = accountData.split(",");
				//System.out.println("trans: # "+ i + "   "+ trans[i] );
				array[i] = trans[i];
			}								//		 -->separate strings
			for (int i = 0; i < 3 ; i ++) {					//<----separate strings
				values[i] = Double.parseDouble(array[i]);
			} //---> strings converted to doubles.
		} catch (NumberFormatException e) {
			
			throw e;
			
		}
		// created instance to be able to call .dateAccountOpened 
		CheckingAccount ch = new CheckingAccount(); 
		date = ch.dateAccountOpened(trans[3]);
		//System.out.println(date);
		accountNumber = (long) values[0];
		balance = values[1];
		interestRate = values[2];
		 //created a checking account with the inserted string variables -- pases test
		ch = new CheckingAccount(accountNumber, balance, 
				interestRate, date);
		
		System.out.println("Account: " + accountNumber + "\n" +
							"Balance: " + balance + "\n" + 
							"Interest Rate: " + interestRate + "\n" + 
							"Date: " + date);
		
		return ch;
		
		//BankAccount b  ;
		//b = new BankAccount((long) values[0], values[1], values[2]);
		//System.out.println("Account Number:  " + b.getAccountNumber());
		//System.out.println("       Balance: $" + b.getBalance());
		//System.out.println(" Interest rate:  " + b.getInterestRate());
		//System.out.println("   Date Opened:  " + b.dateAccountOpened(trans[3]));
		
	}
}

