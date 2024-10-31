/*
 * Author @ Sepehr Akbari (Compiler)
 * File: ThreeDice Class
 * April 16, 2024
 * Title: "Rock & Rollin'Dice"
 * Desc:
    * Using the Die class, create an application called ThreeDice that creates three Die objects, 
    and keeps rolling them together until the sum of the three Die faces is 12. Print the outcome of each roll, 
    and finally when the program stops, print the number of rolls that were needed.
 *
 * Points: [15 points]
 */

// Packages & Imports
package DiceApp;

public class ThreeDice {
    // Dice objects
    Die die1 = new Die();
    Die die2 = new Die();
    Die die3 = new Die();

    // roll() Method
    public void roll() {
        // Iteration Count Variable
        int rolls = 0;
        // Sum of the dice values
        int sum = 0;

        // Roll Dice until the sum of the dice values is 12
        while (sum != 12) {
            // Roll Dice (using the roll method from Die class)
            die1.roll();
            die2.roll();
            die3.roll();

            // Calculate the sum of the dice values
            sum = die1.getValue() + die2.getValue() + die3.getValue();

            // Print Dice values after every roll
            System.out.println("Die 1: " + die1.getValue());
            System.out.println("Die 2: " + die2.getValue());
            System.out.println("Die 3: " + die3.getValue());
            // Print the sum of the dice values
            System.out.println("\nSum: " + sum + "\n\n");

            // Increment the total number of rolls
            rolls++;
        }

        // Print the total number of rolls 
        System.out.println("Number of attempts: " + rolls);
        System.out.println("Number of total rolls: " + rolls * 3 + "\n"); 
    }

    // main() method for testing (not required)
    public static void main(String[] args) {
        System.out.println("\n Rock & Rollin'Dice\n");
        System.out.println("Testing: \n");

        // Create an object of ThreeDice
        ThreeDice threeDice = new ThreeDice();
        // Roll the dice
        threeDice.roll();

        System.out.println();
    }
}
