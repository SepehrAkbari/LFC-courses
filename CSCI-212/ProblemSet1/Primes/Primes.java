/*
 * Author @ Sepehr Akbari (Compiler)
 * Feb 28, 2024
 * Title: "Here are - this many - Primes; Honey!"
 * Desc: 
    * Write a program called Primes that takes an integer 
    * 'n' from the user and prints the first n prime numbers 
    * on the screen. A prime is a number that is only divisible 
    * by 1 and itself. 1 is not considered a prime. Using the 
    * following theorem: "A composite number n (meaning is not 
    * prime) has a prime divisor less than or equal to sqrt(n)" 
    * will shorten your code.
 *
 * Points: [25 points]
*/

package Primes;
import java.util.*;
import java.lang.Math;

public class Primes {
    // Scanner object to get the input from the user
    static Scanner sc = new Scanner(System.in);

    // Main function
    public static void main(String[] args){
        // The amount of prime numbers to be printed
        int n;

        // Printing the title of the program
        System.out.println("\n Here are - this many - Primes; Honey! \n");

        // Getting a valid input from the user (a positive integer & not 0)
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Enter the first n prime numbers to be printed: ");
                // Getting the input from the user
                n = sc.nextInt();
                if (n > 0) {
                    // Breaking the loop
                    valid = true;
                    // Calling the function to print the first n prime numbers
                    PrintPrimes(n);
                } else {
                    System.out.println("Invalid input. Please enter a positive integer.");
                }
            // Catching the exception if the input is not an integer
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                // Clearing the buffer
                sc.next();
            }
        }
        // Printing a new line for better readability
        System.out.print("\n");
    }

    // Function to print the first n prime numbers
    public static void PrintPrimes(int n) {
        System.out.print("The first " + n + " prime numbers are: ");

        // Printing the first n prime numbers
        for (int i = 2; n > 0; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                n--;
            }
        }
    }

    // Function to check if a number is prime or not
    public static boolean isPrime(int x) {
        // Checking if the number is prime or not
        // Steps (2) and (3) are only for optimization purposes

        // 1) If the number is less than or equal to 1, it's not prime
        if (x <= 1) {
            return false; 
        }

        // 2) If the number is 2 or 3, it's prime
        if (x == 2 || x == 3) {
            return true; 
        }

        // 3) If the number is divisible by 2 or 3, it's not prime
        if (x % 2 == 0 || x % 3 == 0) {
            return false; 
        }

        // 4) A composite number has a prime divisor less than or equal to sqrt(n)
        for (int i = 5; i < Math.sqrt(x); i = i + 6) {
            // If the number is divisible by i or i + 2, it's not prime
            if (x % i == 0 || x % (i + 2) == 0) {
                return false;
            } 
        }
        // If the number is not divisible by any of the above numbers, it's prime
        return true; 
    }
}
