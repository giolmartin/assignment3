package com.meritamerica.assignment3;

public class CDOffering {

	private  int term ;
	private  double interestRate;
	
	CDOffering(){
		
	}
	
	CDOffering(int term, double interestRate){
		this.term = term;
		this.interestRate = interestRate;
	}
	
	public int getTerm() {
		return this.term;
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	
}