/*
 * Author @ Sepehr Akbari (Compiler)
 * Feb 28, 2024
 * Title: "What factors are you/we made of?"
 * Desc: 
    * Write a program called Factorize that takes 
    * an integer n from the user and prints out the prime 
    * factorization of the number. e.g., if n is 72, the 
    * program should print 2*2*2*3*3, and if n is 210 then 
    * the program should print 2*3*5*7.
 *
 * Points: [25 points]
*/

package Factorize;
import java.util.*;

public class Factorize {
   // Scanner object to get the input from the user
   static Scanner sc = new Scanner(System.in);

   // Main function
   public static void main(String[] args) {
      // Printing the title of the program
      System.out.println("\n What factors are you/we made of? \n");

      // Getting a valid input from the user (a positive integer & not 0)
      boolean valid = false;
      while (!valid) {
         try {
            System.out.print("Enter a number to factorize: ");
            // Getting the input from the user
            int n = sc.nextInt();
            if (n > 0) {
               // Breaking the loop
               valid = true;
               // Calling the function to print the prime factorization of the number
               factorize(n);
            } else {
               System.out.println("Invalid input. Please enter a positive integer.");
            }
         // Catching the exception if the import is not an integer
         } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            // Clearing the buffer
            sc.next();
         }
      }
      // Printing a new line for better readability
      System.out.print("\n");
   }

   // Function to print the prime factorization of the number
   public static void factorize(int n) {
      System.out.print("The prime factorization of " + n + " is: ");
      // If the number is 1, then the prime factorization is 1 (This is an exception to the rule)
      if (n == 1) {
         System.out.print("1");
         // Breaking the function
         return;
      }
      
      for (int i = 2; i <= n; i++) {
         // If the number is divisible by i, then i is a prime factor
         while (n % i == 0) {
            System.out.print(i);
            n /= i;
            // If n is not 1, then print a '*' to separate the prime factors
            if (n != 1) {
               System.out.print("*");
            }
         }
      }
   }
}
