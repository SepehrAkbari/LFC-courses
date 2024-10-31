package DiceApp;
/*
 * Die.java
 * @description Class that represents a die
 * @author Sepehr Akbari (Compiler)
 * @version 1.1, 3/27/24 
 */

import java.util.Random;

public class Die {
	//attributes
	private final int MAX_VALUE = 6;
	private int value;
	
	//methods
	
	//----------------------------------------------
	//Constructor: Sets the initial face value 
	//-----------------------------------------------
	public Die() {
		
		roll(); 
	}
	//-------------------------------
	//Face value getter/accessor
	//--------------------------------
	
	public int getValue() {
		return value;
	}
	
	//-------------------------------
	//Face value setter/mutator
	//--------------------------------
	public int roll() {
		Random generator = new Random();
		value = generator.nextInt(MAX_VALUE) +1;
		return value;
	}
	
	//--------------------------------------------
	//Returns a string representation to this Die
	//-------------------------------------------	
	public String toString() {
		String output = "";
		output = "The face value is: " + value;
		return output;
	}
}
