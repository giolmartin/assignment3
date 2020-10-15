package com.meritamerica.assignment3;

public class CDOffering {

	private  static int term ;
	private  static double interestRate;
	
	
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
	
	public static CDOffering readFromString(String cdOfferingDataString) {
		int t = 0;
		double	iR = 0; 
		term = t;
		interestRate = iR;
		//CDOffering offering = new CDOffering(t,iR);
		//MeritBank.setCDOfferings(offering);
		//System.out.println("Inside readFromString");
		
		return null;
	}
	
	

	public String writeToString() {
		String offering = getTerm() + "," + getInterestRate()+"\n";
		return offering;
	}
}