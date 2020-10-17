package com.meritamerica.assignment3;

import java.text.DateFormat;
import java.lang.NumberFormatException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckingAccount extends BankAccount{
	
	private static double interestRate = 0.0001;
	
	private static Date date ;
	private static long accountNumber;
	private static double balance;
	

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
		double balance;
		double interestRate;
		
		CheckingAccount checking = new CheckingAccount();
		String[] values = accountData.split(",");
		try {
		
				accountNumber = Long.parseLong(values[0]);
				 balance = Double.parseDouble(values[1]);
				 interestRate = Double.parseDouble(values[2]);
				date = checking.dateAccountOpened(values[3]);
											
		} catch (NumberFormatException e) {
			
			throw e;
			
		}
		checking = new CheckingAccount(accountNumber, balance, 
				interestRate, date);

		// created instance to be able to call .dateAccountOpened 
		 
		
	
		 //created a checking account with the inserted string variables -- pases test
		
		/*
		System.out.println("Checking Account: " + accountNumber + "\n" +
							"Balance: " + balance + "\n" + 
							"Interest Rate: " + interestRate + "\n" + 
							"Date: " + date);
	
		*/
		//if() {}
		return checking;
		
		
		//BankAccount b  ;
		//b = new BankAccount((long) values[0], values[1], values[2]);
		//System.out.println("Account Number:  " + b.getAccountNumber());
		//System.out.println("       Balance: $" + b.getBalance());
		//System.out.println(" Interest rate:  " + b.getInterestRate());
		//System.out.println("   Date Opened:  " + b.dateAccountOpened(trans[3]));
		
	}
}

