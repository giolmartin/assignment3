package com.meritamerica.assignment3;

import java.io.File;
import java.util.Arrays;
import java.util.Random;

public class MeritBank {
	
	private static AccountHolder[] accounts = new AccountHolder[0];
	private static CDOffering[] cdOfferings;
	
	private static CDOffering bestCDOffering;
	private static CDOffering secondBestCDOffering;
	private static int counterA = 0;
	private static int counterCD = 0;
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
	
	public static void sortAccountHolders() {
		
	}
	public static void readFromFile(String string) {
		
	}
}
