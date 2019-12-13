package com.revature;

// this is the parent class
public abstract class Account implements IBaseRate {
	
	// list common properties for savings and checking accounts
		// i.e SSN, name, accountType, etc.
	private String name;
	private String sSN;
	private double balance;
	
	private static int index = 1000;
	
	protected String accountNumber;
	protected double rate;
	
	// Constructor to set base properties and initialize the account
	
	public Account(String name, String sSN, double initDeposit) {
		this.name = name;
		this.sSN = sSN;
		this.balance = initDeposit;
		
		// Set account number
		index++;
		this.accountNumber = setAccountNumber();
		
		setRate();
	}
	
	// both checkings and savings must implement this method
		//(with their own adjustments to the rate).
	public abstract void setRate();
	
	private String setAccountNumber() {
		// the Account Number consists of the last 2 digits of the customer's SSN,
		// and a 5 digit unique number (this is created by INDEX).
		// ...and  a random Number generated with the Math Class.
		// also, there is a "1-" or a "2-" showing whether it's checking or savings TYPE
		String lastTwoOfSSN = sSN.substring(sSN.length()-2, sSN.length());
		int uniqueID = index;
		int randomNumber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoOfSSN + uniqueID + randomNumber;
	}
	
	public void showInfo() {
		System.out.println(
				"NAME: " + name +
				"\nACCOUNT NUMBER: " + accountNumber +
				"\nBALANCE: $" + balance +
				"\nINTEREST RATE: " + rate + "%"
				);
	}
	
	public void compound() {
		double accruedInterest = balance * (rate/100);
		balance += accruedInterest;
		System.out.println("Accrued Interest: $" + accruedInterest);
		printBalance();
	}
	
	// Transaction Methods
	
	public void deposit(double amount) {
		balance += amount;
		System.out.println("Depositing $" + amount + "...");
		printBalance();
	}
	
	public void withdraw(double amount) {
		if(balance - amount < 0) {
			System.out.println("Insufficient funds. Your current balance is $"+balance);
		} else {
			balance -= amount;
			System.out.println("Withdrawing $" + amount + "...");
			printBalance();
		}
	}
	
	public void transfer(String toWhere, double amount) {
		if(balance - amount < 0) {
			System.out.println("Insufficient funds. Your current balance is $"+balance);
		} else {
			balance -= amount;
			System.out.println("Transferring $" + amount + " to " + toWhere + "...");
			printBalance();
		}
	}
	
	public void printBalance() {
		System.out.println("Your balance is now $"+balance);
	}
	
	
	// common methods (withdraw(), deposit(), transfer(), etc..)
}
