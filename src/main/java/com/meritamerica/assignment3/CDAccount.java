package com.meritamerica.assignment3;

import java.util.Date;



public class CDAccount extends BankAccount {

	private double balance;
	private Date date;
	private CDOffering offering;

	
	
	CDAccount(CDOffering offering, double balance){
		super(balance,offering.getInterestRate());
		this.offering = offering;
		this.balance = balance;
	}
	

	public double getBalance() {
		return this.balance;
	}
	
	public double getInterestRate() {
		return this.offering.getInterestRate();
	}
	
	public int getTerm() {
		return this.offering.getTerm();
	}

	public Date getStartDate() {
		return this.date;
	}
	
	public long getAccountNumber() {
		return super.getAccountNumber();
	}
	
	public double futureValue() {
		return super.futureValue(this.offering.getTerm());
	}
}

