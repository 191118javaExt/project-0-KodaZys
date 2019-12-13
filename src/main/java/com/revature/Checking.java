package com.revature;

public class Checking extends Account {
//list properties specific to checking account
	
	private int debitCardNumber;
	private int debitCardPin;
// call constructor to initialize checking accnt properties	
	
	public Checking(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		// this creates a unique account number based on the ACCOUNT TYPE
		accountNumber = "2-" + accountNumber;
		setDebitCard();
	}
	
	@Override
	public void setRate() {
		rate = getBaseRate() * .15;
	}
	
	private void setDebitCard() {
		debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
		debitCardPin = (int) (Math.random() * Math.pow(10, 4));
	}
	
	// @Override showInfo() so that it prints the actual account type. 
	public void showInfo() {
		super.showInfo();
		System.out.println("Your Checking Account Features" +
		"\n Debit Card Number: " + debitCardNumber +
		"\n Debit Card Pin: " + debitCardPin
		);
	}
// list methods specific to checking account
}
