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
	private static long accountNumber;
	private static int index = 0;
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
		 * +++>Amount account Holders (repeat) 
		 * 		--->Account holder information(Last, middle, first, ssn)//unique
		 * 		+++> amount checking account 
		 * 		---> checking account(account number, balance, interest rate, date )
		 * 		+++>Amount savings account
		 * 		--->savings account(account number, balance, interest rate, date )
		 * 		+++>Amount CDAccounts 
		 * 		--->cdAccounts(account number, balance, interest rate, date, term)
		 * 
		 */
			int cdofferingsCounter; 
			int accountInfo;
			int checkingCounter;
			int accountHolderCounter;
			int savingsCounter;
			int cdAccountCounter;
			
			String line;
			while((line = bR.readLine()) != null) {	//Passing down values into list
			    values.add(line);					//Values = ArrayList
			//counter++;								//Amount of items on list.
			}
			int actualSize = values.size();
			actualSize = actualSize + 1;
			// position 0 in my values list is always the amount of account holders.
			//System.out.println("Array size: " + actualSize );
			//while(index != values.size()) {
				
				
					accountNumber = Long.parseLong(values.get(index));
					//System.out.println("Account: " + accountNumber);
					index++;         // <----------------------------global index of the array.
					cdofferingsCounter = Integer.parseInt(values.get(index)); //amount of cdofferings
					//System.out.println("CDOfferings: " + cdofferingsCounter);
					index++;
					//System.out.println(index);
					for(int i = index ; i < cdofferingsCounter + index; i ++) { //runs the amount of cd offerings
						CDOffering.readFromString(values.get(i));      //<--------------------sends offerings to be created
					//	System.out.println("Counter: " + index + "Offering: " + values.get(i));
					} 
					index += cdofferingsCounter ;
					accountHolderCounter = Integer.parseInt(values.get(index));
					index++;
					//System.out.println("Counter: " + accountHolderCounter);
					//while(index < (actualSize - 1)) {
					for(int i = index; i < accountHolderCounter + index; i++) {
						if (index == values.size())return true;; //checks to see if the index is at the end of the array.
						AccountHolder.readFromString(values.get(index));
					//	System.out.println("Account Info: " + values.get(index));
						index++; 
						checkingCounter = Integer.parseInt(values.get(index));
					//	System.out.println("Checking: " + checkingCounter);
						index++;
						if(checkingCounter != 0) {
							for (int j = index ; j < checkingCounter + index ; j++) {	
								CheckingAccount.readFromString(values.get(j));
								System.out.println("Checking Info: " + values.get(j));
							}
						} 
						index += checkingCounter;
						savingsCounter = Integer.parseInt(values.get(index));
						index++;
					//	System.out.println("Savings: " + savingsCounter);
						if(savingsCounter != 0) {
							for(int k = index; k < savingsCounter + index; k++) {
					//			System.out.println("Savings Info: " + values.get(k));
								SavingsAccount.readFromString(values.get(k));
							}
						}
						index += savingsCounter;
						cdAccountCounter = Integer.parseInt(values.get(index));
					//	System.out.println("CD Counter: " + cdAccountCounter);
						index++;
						if(cdAccountCounter != 0) {
							for(int x = index; x < cdAccountCounter + index; x++) {
					//			System.out.println("CdAccount: " + values.get(x));
								CDAccount.readFromString(values.get(x));
							}
						}
						index += cdAccountCounter;
					//	System.out.println("Index: " + index);
					
					}
					System.out.println("Index: " + index);
					
					//for(int)
					//}	
					System.out.println("True");
					
				}catch(NumberFormatException e) {
					
					return false;
					//throw e;
				} 
		 catch(IOException e ){
			e.getStackTrace();
		System.out.println("File not found");
			}
		return true; 
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
