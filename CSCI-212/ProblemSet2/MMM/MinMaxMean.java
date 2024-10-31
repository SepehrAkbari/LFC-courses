/*
 * Author @ Sepehr Akbari (Compiler)
 * March 29, 2024
 * Title: "Societal Classes: Min, Max, Mean"
 * Desc: 
    * Given 10 input integers (negative numbers allowed), 
    * output the minimum, maximum, and average of those 
    * integers. Use an array for the input.
        ** Use a single for loop and update variables minVal, maxVal, 
        * and sumVals on each iteration. (You could use three loops instead).
        ** Initialize variables minVal and maxVal each to the first integer, 
        * NOT to 0. 0 is wrong because integers could be negative. Then update 
        * those values if a smaller or larger integer is seen (respectively).
        ** Don't forget to use floating-point division, not integer division, 
        * when computing the average (use / 10.0, not / 10).  
 *
 * Points: [30 points]
*/

// Packages & Imports
package MMM;
import java.util.Scanner;

public class MinMaxMean {
    public static void main(String[] args) {
        // Scanner object to get the input from the user
        Scanner sc = new Scanner(System.in);

        // Printing the title of the program
        System.out.println("\n Societal Classes: Min, Max, Mean \n");

        // Number of integers
        final int SIZE = 10;
        // Array to store the integers
        int[] arr = new int[SIZE];

        // Giving the user instructions
        System.out.println("Enter 10 integers");
        System.out.print("\n");
        
        // Getting a valid input from the user (10 integers)
        boolean valid = false;
        while (!valid) {
            try {
                for (int i = 0; i < SIZE; i++) {
                    System.out.print("Enter integer " + (i + 1) + ": ");
                    // Getting the input from the user
                    arr[i] = sc.nextInt();
                }
                // Breaking the loop
                valid = true;
            // Catching the exception
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                // Clearing the buffer
                sc.next();
            }
        }

        // Initializing the variables
        int minVal = arr[0];
        int maxVal = arr[0];
        int sumVals = arr[0];

        // Calculating the minimum, maximum, and average of the integers
        for (int i = 1; i < SIZE; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
            }
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
            // Storing the sum of the integers
            sumVals += arr[i];
        }

        System.out.print("\n");
        // Outputting the minimum, maximum, and average of the integers
        System.out.println("Minimum: " + minVal);
        System.out.println("Maximum: " + maxVal);
        // Using floating-point division and the stored sum to calculate the average
        System.out.println("Mean (Average): " + (sumVals / ((float)SIZE)));

        // Closing the scanner
        sc.close();
    }
}
