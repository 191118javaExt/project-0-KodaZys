package com.revature.driver;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.models.User;
import com.revature.service.UserService;
import com.revature.util.Actions;

public class BankingApp {

	static final Logger logger = Logger.getLogger(BankingApp.class);
	static UserService us = new UserService();

	public static void main(String[] args) {
		run();	
	}

	static void run() {		
		Scanner in = new Scanner(System.in);
		String userInput;

		// Welcome message
		System.out.println("Welcome to your online banking application with SophBank!\n"
				+ "\nDo you have an existing user account? [y/n]" );
		while(in.hasNext()) {
			userInput = in.nextLine();
			// LOGIN
			if ( (userInput.equalsIgnoreCase("y")) || (userInput.equalsIgnoreCase("yes")) ) {
				User user = Actions.login();
				Actions.giveOptions(user);
			}

			//CREATE USER
			else if( (userInput.equalsIgnoreCase("n")) || (userInput.equalsIgnoreCase("no")) ) {
				System.out.println("Would you like to create a new user account? [y/n]");
				while(in.hasNext()) {
					userInput = in.next();
					if( (userInput.equalsIgnoreCase("n")) || (userInput.equalsIgnoreCase("no")) ) {
						System.out.println("Okay, Goodbye!");
						System.exit(0);
					}
					else if ( (userInput.equalsIgnoreCase("y")) || (userInput.equalsIgnoreCase("yes")) ) {
						User u = Actions.createUser();
						us.createUser(u);
						logger.info("Created user " + u.getFirst()+ " in Postgres DB");
						System.out.println("Congratulations " + u.getFirst() + "! You created a new user account with username: "
								+ u.getUsername());
						Actions.giveOptions(u);
						break;
					}
					else {
						logger.info("Please enter [y] or [n]");
					}
				}
			}
			else {
				System.out.println("Please enter [y] or [n]");
			}
		}
		in.close();
	}

}
