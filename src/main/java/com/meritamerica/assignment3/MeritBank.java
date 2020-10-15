package com.meritamerica.assignment3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MeritBank {
	
	private static AccountHolder[] accounts = new AccountHolder[0];
	private static CDOffering[] cdOfferings;
	private static ArrayList<String> values = new ArrayList<String>();
	private static AccountHolder[] sortedAccounts = new AccountHolder[5];
	
	private static int counter = 0;
	private static CDOffering bestCDOffering;
	private static CDOffering secondBestCDOffering;
	private static int counterA = 0;//counter accounts at addAccountHolder()
	private static int counterCD = 0;//counter CD not used
	private static int counterAH = 0;//Counter used for sortedAccounts
	private static double totalBalance = 0;
	
	public static void addAccountHolder(AccountHolder accountHolder) {
		if(counterA == accounts.length) {
			AccountHolder[] newAccounts = new AccountHolder[counterA + 1];
			for(int i = 0; i <counterA ; i++) {
				newAccounts[i] = accounts[i];
			}
			accounts = newAccounts;
		}
			accounts[counterA] = accountHolder;
			counterA ++;
	}
	
	public static AccountHolder[] getAccountHolders() {
		return accounts;
	}
	
	public static CDOffering[] getCDOfferings() {
		return cdOfferings;	
	}
	
	public static CDOffering getBestCDOffering(double depositAmount) {
		return bestCDOffering;
	}
	public static CDOffering getSecondBestCDOfferings(double depositAmount) {
		return secondBestCDOffering;
	}
	
	public static void clearCDOfferings() {
		cdOfferings = null;	
	}
	
	public static void setCDOfferings(CDOffering[] offerings) {
		cdOfferings = offerings;
	}
	
	public static long getNextAccountNumber() {
		
		return 0;
	}
	public static double totalBalances() {
		double tB = 0;
		System.out.println("Method Total Balance" + tB);
		return tB;
	}
	
	public static double futureValue(double presentValue, double interestRate, int term) {
		return 0;
	}
	
	
	public static boolean readFromFile(String fileName) {
		
		File file = new File(fileName);
		
		try (BufferedReader bR = new BufferedReader(new FileReader(file)) ){
		/*
		 * Next bank Account: /unique
		 * +++>CdOfferings: 2 / unique 
		 * -->cdOffering1(term, interest)
		 * -->cdOffering2(term,interest)
		 * +++>Amount count Holders (repeat) 
		 * --->Account holder information(Last, middle, first, ssn)
		 * +++> amount checking account 
		 * ---> checking account(account number, balance, interest rate, date )
		 * +++>Amount savings account
		 * --->savings account(account number, balance, interest rate, date )
		 * +++>Amount CDAccounts 
		 * --->cdAccounts(account number, balance, interest rate, date, term)
		 * 
		 */
			String line;
			while((line = bR.readLine()) != null) {	//Passing down values into list
			    values.add(line);					//Values = ArrayList
			counter++;								//Amount of items on list.
			}
			
			CheckingAccount.readFromString("9,1000,0.1, 10/10/2020"); // used to test readFroMString .. Working, at least the reading. 
			SavingsAccount.readFromString("2,100000,0.3, 1/1/2020");
			CDAccount.readFromString("1,2000,0.3,10/04/1991,5");
			/*
			CDOffering.readFromString(values.get(2));
			
				for(String st:values) {
				System.out.print("Counter # " + counter --+ " ");
				System.out.println(st);
			}
					
			System.out.println(counter);
			*/
			return true;
		
		} catch(IOException e ){
		System.out.println("File not found");
		return false;
			} 
		
	}
	
	public static boolean writeToFile(String fileName) {
		return true;
	}
	
	public static AccountHolder[] sortAccountHolders() {
		int index = 0;
		double balance = 0;
		counterAH = accounts.length;
		int sortedCounter = 0;
		while(counterAH-- > 0) {
			for(int i = 0; i < accounts.length; i++) {
				if((balance = accounts[index].getCombinedBalance()) > accounts[i].getCombinedBalance()) {
					index = i;
				}
				
			}
			sortedAccounts[sortedCounter++] = accounts[index];
			
		}
		return sortedAccounts;
	}
	public static void setNextAccountNumber(long nextAccountNumber) {
		
	}
	
}
