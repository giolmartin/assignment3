package com.meritamerica.assignment3;

import java.util.Date;

public class CDAccount extends BankAccount {

	private static double balance;
	private CDOffering offering;
	private static int term;
	private static double interestRate;
	private static String[] array = new String[5];
	private static Date date;
	private  static long accountNumber;
	 
	
	
	
	CDAccount(){
		super(accountNumber, balance, interestRate, date);
	}
	CDAccount(CDOffering offering, double balance){
		super(MeritBank.getNextAccountNumber(),balance,offering.getInterestRate());
		
		this.offering = offering;
		this.term= this.offering.getTerm();
		this.interestRate = this.offering.getInterestRate();
		this.balance = balance;
	}
	
	//Need to override deposit and withdraw.
	
	public static CDAccount readFromString(String accountData) {
		String[] trans = new String[5];
		double[] values = new double[5];
		
		try {
			for(int i = 0; i <= 4 ; i++) {
				trans = accountData.split(",");
				//System.out.println("trans: # "+ i + "   "+ trans[i] );
				array[i] = trans[i];
			}								//		 -->separate strings
			for (int i = 0; i < 3 ; i ++) {					//<----separate strings
				values[i] = Double.parseDouble(array[i]);
			} //---> strings converted to doubles.
			values[4] = Integer.parseInt(array[4]); //term
		} catch (NumberFormatException e) {
			throw e;
		}
		CDAccount cd = new CDAccount();
		date = cd.dateAccountOpened(trans[3]);
		System.out.println(date);
		accountNumber = (long) values[0];
		balance = values[1];
		interestRate = values[2];
		term = (int) values[4];
		
		/*
		System.out.println("Account: " + accountNumber + "\n" +
				"Balance: " + balance + "\n" + 
				"Interest Rate: " + interestRate + "\n" + 
				"Date: " + date + "\n" + 
				"Term: " + term);
		*/
		return null;
	}
	
	public  int getTerm() {
		return offering.getTerm();
	}
	
	@Override
	public boolean deposit(double amount) {
		return false;
	}
	public boolean withdraw (double amount) {
		return false;
	}
	
	public double futureValue() { //overriding term because could not figure out how to pass the term from offering to my variables in bankAccount
		double fV  = balance * Math.pow((1+ interestRate ), term);
		return fV;
	}
	@Override
	public String toString() {
		return "CDAccount [balance=" + balance + ", Offering Term =" + offering.getTerm() + "]";
	}

	
}

