/*
 * Author @ Sepehr Akbari (Compiler)
 * March 29, 2024
 * Title: "You talk; I complile!"
 * Desc:
    * Write a program called IntegerConversion that performs binary to 
    * decimal conversion. The user is asked to provide  8-bit binary number 
    * (1's and 0's; leading 0 is allowed) and compute and output the decimal equivalent.  
    * A binary number's digits are only 0's and 1's, with each digit's weight being 
    * an increasing power of 2 
    * (binary110 is 1*2^2 + 1*2^1 + 0*2^0 = 1*4 + 1*2 + 0*1 = 4 + 2 + 0 = 6 in decimal) 
        * Ex: For input 00000110, the output is: 6.
        * Use arrays to solve this problem.
 *
 * Points: [20 points]
*/

// Packages & Imports
package IntegerConversion;
import java.util.Scanner;

public class IntegerConversion {
    public static void main(String[] args) {
        // Scanner object to get the input from the user
        Scanner sc = new Scanner(System.in);

        // Printing the title of the program
        System.out.println("\n You talk; I complile! \n");

        // Size of the binary number
        final int SIZE = 8;
        // Array to store the binary number
        int[] binary = new int[SIZE];

        // Getting a valid input from the user (8-bit binary number)
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Enter an 8-bit binary number: ");
                // Getting the input from the user
                String binaryInput = sc.nextLine();
                // Checking if the input is a valid binary number
                if (isBinary(binaryInput, SIZE)) {
                    // Storing the binary number in the array
                    for (int i = 0; i < SIZE; i++) {
                        binary[i] = Character.getNumericValue(binaryInput.charAt(i));
                    }
                    // Breaking the loop
                    valid = true;
                }else{
                    // Throwing an exception if the input is not valid
                    throw new Exception();
                }
            // Catching the exception
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid 8-bit binary number.");
            }
        }

        // Calculating the decimal equivalent of the binary number
        int decimal = 0;
        for (int i = 0; i < SIZE; i++) {
            decimal += binary[i] * Math.pow(2, SIZE - i - 1);
        }

        // Outputting the decimal equivalent
        System.out.println("Decimal equivalent: " + decimal);
        // Closing the scanner
        sc.close();
    }

    // Function to check if the input is a valid binary number with the given size
    public static boolean isBinary(String binaryInput, int SIZE) {
        // Checking if the input only contains 0's and 1's
        for (int i = 0; i < binaryInput.length(); i++) {
            if (binaryInput.charAt(i) != '0' && binaryInput.charAt(i) != '1') {
                // Returning false if the input contains a character other than 0 or 1
                return false;
            }
        }
        // Checking if the input has the correct size
        if ((binaryInput.length() != SIZE)) {
            // Returning false if the input does not have the correct size
            return false;       
        }
        // Returning true if the input is valid
        return true;
    }
}