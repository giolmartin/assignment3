package com.meritamerica.assignment3;



public class SavingsAccount extends BankAccount{
	
	
	final static double INTEREST_RATE = 1.0/100;
	private static String[] array = new String[4];
	private static String date = " ";
	
	SavingsAccount(double openingBalance) {
		super(MeritBank.getNextAccountNumber(),openingBalance, INTEREST_RATE, date);
	}
	
	public static SavingsAccount readFromString(String accountData) {
		
		BankAccount b  ;
		String[] trans = new String[4] ;
		double[] values = new double[4];
		for(int i = 0; i < 4 ; i++) {
			trans = accountData.split(",");
			//System.out.println("trans: # "+ i + "   "+ trans[i] );
			array[i] = trans[i];
		} 
		for (int i = 0; i < 3 ; i ++) {//<----separate strings
			values[i] = Double.parseDouble(array[i]);

		} //---> strings converted to doubles.

		b = new BankAccount((long) values[0], values[1], values[2],
				trans[3]);


		System.out.println(b.getBalance());
		System.out.println(b.getInterestRate());
		return null;
	}
}
