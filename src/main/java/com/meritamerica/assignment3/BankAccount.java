package com.meritamerica.assignment3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BankAccount {
	
	private double  balance ;
	private static double interestRate;
	private long accountNumber;
	private double futureValue;
	private double accountTotal;
	private Date date;
	
	
	 BankAccount(double balance, double interestRate){
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	BankAccount(long accountNumber, double balance, double interestRate, String date){
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
		this.date = dateAccountOpened(date);
	}
	

	public long getAccountNumber() {
		System.out.println("AccountNumber");
		return this.accountNumber;
	}
	
	public double getBalance() {
		return this.balance;
	}
	public double getInterestRate() {
		return this.interestRate;
	}
	
	public boolean withdraw(double amount) {
	/*	this.balance = this.client.getCombinedBalance();//create in account Balance
		if((this.balance - amount) >= 0) {
			this.balance = this.balance - amount;
			return true;
		} else
	*/		return false;
	}
	
	public boolean deposit(double amount) {
		if((this.balance + amount) <= 250000) {
			System.out.println("Deposit bank: "+ amount);
			this.balance = this.balance + amount;
			return true;
		} else 
			System.out.println(" more than 250000");
			return false;	
	}
	
	
	public double futureValue(int years) {
		this.futureValue = balance * Math.pow((1+ interestRate ), years);
		return this.futureValue;
	}

	
	//public date
	
	public  Date dateAccountOpened(String string) {
			DateFormat startDate = new SimpleDateFormat("yyyy/MM/dd");
	        Date date = new Date(string);
	        System.out.println(startDate.format(date));
	        return date;
	}
	
	public  Date getOpenedOn() {
		return this.date;
	}
	
	public static BankAccount readFromString() {
		
		return null;
	}
	
	public String writeToString() {
		return"";
	}
	public String toString() {
		return "";
	}
}

