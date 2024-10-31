/*
 * Author @ Sepehr Akbari (Compiler)
 * March 29, 2024
 * Title: "one, two, three, ZUMBA!"
 * Desc:
    * Sam tracks her monthly Zumba session attendance. 
    * She has a number for each month. Ask Sam to provide 
    * these values and save them into the array yearlyValues. 
    * Output all 12 elements, one quarter per line. If the 
    * elements are 11 23 24 5 9 16 10 18 19 10 12 10, the output is:
            11 23 24 5
            9 16 10 18 
            19 10 12 10
        * Think about the end-user experience and write the output as friendly as possible. 
        * Use arrays to solve this problem.
 *
 * Points: [20 points]
*/

// Packages & Imports
package Zumba;
import java.util.Scanner;

public class ZumbaAttendance {
    public static void main(String[] args) {
        // Scanner object to get the input from the user
        Scanner sc = new Scanner(System.in);

        // Printing the title of the program
        System.out.println("\n one, two, three, ZUMBA! \n");

        // Variable to store the yearly sum of the Zumba attendance
        int sum = 0;
        // Size of the time period (in this case, 12 months)
        final int SIZE = 12;
        // Array to store the Zumba attendance for each month
        int[] yearlyValues = new int[SIZE];

        // Giving the user instructions
        System.out.println("Enter 12 integers");
        System.out.print("\n");

        // Getting a valid input from the user (12 integers)
        boolean valid = false;
        while (!valid) {
            try {
                for (int i = 0; i < SIZE; i++) {
                    System.out.print("How many sessions did you attend in month " + (i + 1) + ": ");
                    // Getting the input from the user
                    yearlyValues[i] = sc.nextInt();
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

        // Outputting the Zumba attendance for each quarter
        System.out.println("\nZumba attendance for each quarter:");
        for (int i = 0; i < SIZE; i++) {
            // Calculating the sum of the Zumba attendance
            sum += yearlyValues[i];
            // Outputting the Zumba attendance for each quarter
            System.out.print(yearlyValues[i] + " ");
            // Outputting a new line after each quarter
            if ((i + 1) % 4 == 0) {
                System.out.println();
            }
        }

        // Outputting the total Zumba attendance for the year
        System.out.println("\nTotal Zumba attendance for the year: " + sum + " sessions");
        // Providing feedback based on the year's total
        if (sum >= 100) {
            System.out.println("Great job! Keep it up!");
        } else {
            System.out.println("You can do better! Keep pushing!");
        }

        // Closing the scanner
        sc.close();
    }
}