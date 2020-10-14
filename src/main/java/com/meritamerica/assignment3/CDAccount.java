package com.meritamerica.assignment3;

public class CDAccount extends BankAccount {

	private double balance;
	private CDOffering offering;
	
	
	
	CDAccount(CDOffering offering, double balance){
		super(MeritBank.getNextAccountNumber(),balance,offering.getInterestRate());
		this.offering = offering;
		this.balance = balance;
	}
	
	//Need to override deposit and withdraw.
	
	public static CDAccount readFromString(String accountData) {
		
		return null;
	}
	
	public int getTerm() {
		return this.offering.getTerm();
	}
	
	public boolean deposit(Date date, int term) {
		
	}
	@Override
	public String toString() {
		return "CDAccount [balance=" + balance + ", Offering Term =" + offering.getTerm() + "]";
	}

	
}

