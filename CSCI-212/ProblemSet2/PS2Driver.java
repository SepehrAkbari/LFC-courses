/*
 * Author @ Sepehr Akbari (Compiler)
 * March 29, 2024
 * Method 1:
 	* Title: "Totals"
	* Desc: 
		* Implement a method named totals() that takes a two-dimensional 
		* integer array named array as a parameter and returns a one-dimensional 
		* array where each element is the sum of integers in each column of the input array.
	* Points: [10 points]
 * Method 2:
 	* Title: "Vowels"
	* Desc:
		* Implement a method named vowels that accepts a String array named alpha. 
		* The method will return the index of the String that contains the most vowels. 
		* If there is a tie any one will be good.
	* Points: [10 points]
 * Method 3:
 	* Title: "Border"
	* Desc:
		* Implement a method named border that accepts a two-dimensional array of 
		* chars named array as a parameter. It initializes all of the elements of the 
		* array to ‘x’ except for the perimeter (first and last column, and first and last row) 
		* that is initialized to ‘o’. No need to return anything.
	* Points: [10 points]
 *
 * All three methods are included in the PS2Driver.java file and called in the main() method.
 */

// Packages & Imports
import java.util.Scanner;

public class PS2Driver {
	public static void main(String[] args) {
		// this is used for testing each problem
		//one test case is included below - you need to perform thorough testing
		
		//test totals
		System.out.println("Test for the totals method");
		//
		int[][] square2 = {
			{8,1,6,4},
			{3,5,7,6},
			{4,9,2,20}
		};
		for (int total: totals(square2)) {
			System.out.print (total + " ");
		}
		System.out.println("\n");
		
		//test vowels
		System.out.println("Test for the vowels method");
		
		String[] beta = {"test1", "let's try again", "how many vowels?", "12345"};
		System.out.print(vowels(beta));
		
		System.out.println("\n");
		
		//test border method
		System.out.println("Test for the border method");
		
		char[][] test = {{'a','b', 'c', '4'}, {'5','1','2', '3'}, {'a','b','6', 'c'}};
		border(test);
		
		System.out.println("\n");
	}

	public static int[] totals(int[][] array) {
		//include the code to solve the respective problem here
		//change anything you need to - sums below is not declared not instantiated
		//thus the error

		// initialize the array to store the sums of the columns
		int[] sums = new int[array[0].length];

		// iterate through the columns of the array
		for (int i = 0; i < array[0].length; i++) {
			// initialize the sum of the current column
			int sum = 0;
			// iterate through the rows of the array
			for (int j = 0; j < array.length; j++) {
				// add the element to the sum
				sum += array[j][i];
			}
			// store the sum in the sums array
			sums[i] = sum;
		}
		// return the array of sums
		return sums;
	}
	
	public static int vowels(String[] alpha) {
		//include the code to solve the respective problem here
		//change anything you need to

		// initialize the index of the string with the most vowels
		int maxIndex = 0;
		// initialize the number of vowels in the string with the most vowels
		int maxVowels = 0;

		// iterate through the strings in the array
		for (int i = 0; i < alpha.length; i++) {
			// initiale the number of vowels in the current string
			int vowels = 0;
			// iterate through the characters in the current string
			for (int j = 0; j < alpha[i].length(); j++) {
				// check if the character is a vowel
				if (alpha[i].charAt(j) == 'a' || alpha[i].charAt(j) == 'e' || alpha[i].charAt(j) == 'i' || alpha[i].charAt(j) == 'o' || alpha[i].charAt(j) == 'u') {
					// increment the number of vowels
					vowels++;
				}
			}
			// check if the current string has more vowels than the string with the most vowels
			if (vowels > maxVowels) {
				// update the index of the string with the most vowels
				maxIndex = i;
				// update the number of vowels in the string with the most vowels
				maxVowels = vowels;
			}
		}
		// return the index of the string with the most vowels
		return maxIndex;
	}
	
	public static void border(char[][] array) {
		//include the code to solve the respective problem here
		
		// iterate through the elements of the array
		for (int i = 0; i < array.length; i++) {
			// iterate through the elements of the current row
			for (int j = 0; j < array[0].length; j++) {
				// if the element is on the perimeter, set it to 'o', otherwise set it to 'x'
				if (i == 0 || i == array.length - 1 || j == 0 || j == array[0].length - 1) {
					array[i][j] = 'o';
				} else {
					array[i][j] = 'x';
				}
			}
		}

		// print the array
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			// print a new line after each row
			System.out.println();
		}
		// no return statement as the method is void
	}
}
