package com.promineotech;

import java.util.Random;

public class TestDemo { //Junit Test Class

public static int addPositive(int a, int b) { 
	int sum;
	if(a>0 && a>0) { 	//takes two ints that must be greater than zero
		sum = a + b; 
	}
	
	else {
		throw new IllegalArgumentException("Both parameters must be positive!");
	}
	return sum;
}

public int randomNumberSquared () {		
	int randomNumber = getRandomInt (); //gets the random int and returns the square
	return randomNumber*randomNumber;
}

int getRandomInt() {
	Random random = new Random ();
	return random.nextInt(10) + 1; //random in between 1 and 10
}


	
}
