package com.revature;

// Interest rate interface
// the Interest rate is determined by a third-party source (API or database)
public interface IBaseRate {
	
	default double getBaseRate() {
		return 2.5;
	}
	
	
	
	// here write a method that returns the base rate.
	// there are methods here to extract what the interest rate is
}
