package com.meritamerica.assignment3;

import java.io.FileNotFoundException;

public class MeritAmericaBankApp {
	public static void main(String[] args) {
		
		MeritBank.readFromFile("src/test/testMeritBank_good.txt");
		
		  //System.out.println("Balance: " + accountHolder.getCheckingBalance());
		 
	/*	
	 *  AccountHolder accountHolder = new AccountHolder(
		        	"Sadiq",
		        	"",
		        	"Manji",
		        	"123456789");
		        	new CDAccount();
		new CheckingAccount();
	
		CDAccount cd = CDAccount.readFromString("1,1000,0.1,10/10/2020,5");
		System.out.println(cd.getTerm());
		 
		 CheckingAccount c = CheckingAccount.readFromString("1,100,0.2,10/10/1011");
		 
		 System.out.println(accountHolder.getNumberOfCDAccounts());
		 System.out.println(accountHolder.getNumberOfCheckingAccounts());
		 System.out.println(accountHolder.getNumberOfSavingsAccounts());
		 
		AccountHolder account = new AccountHolder();
		CheckingAccount c = new CheckingAccount(100);
		
	
		CDAccount ac = account.addCDAccount(new CDOffering(5,0.03), 10000);
		
		System.out.println(ac.futureValue());
		*/
		
	}
}