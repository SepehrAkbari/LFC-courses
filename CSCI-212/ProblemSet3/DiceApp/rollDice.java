/*
 * Author @ Sepehr Akbari (Compiler)
 * File: RollDice Class
 * April 16, 2024
 * Title: "Rock & Rollin'Dice"
 * Desc:
    * Write an application named rollDice that creates two objects of the Die class (given). 
    The application should roll the dice one by one, print their face values, and then print the sum, 
    difference and product of those values.
 *
 * Points: [10 points]
 */

// Packages & Imports
package DiceApp;

public class rollDice {
  // Dice objects
  Die die1 = new Die();
  Die die2 = new Die();

  // Sum Method
  public int getSum() {
    return die1.getValue() + die2.getValue();
  }

  // Difference Method
  public int getDifference() {
    // Using Math.abs to make sure the difference is positive
    return Math.abs(die1.getValue() - die2.getValue());
  }

  // Product Method
  public int getProduct() {
    return die1.getValue() * die2.getValue();
  }

  // Print Method
  public void printDice() {
    // Print dice values
    System.out.println("Die 1: " + die1.getValue());
    System.out.println("Die 2: " + die2.getValue());
    // Print sum, difference, and product
    System.out.println("Sum: " + getSum());
    System.out.println("Difference: " + getDifference());
    System.out.println("Product: " + getProduct());
  }

  // main() method for testing (not required)
  public static void main(String[] args) {
    System.out.println("\n Rock & Rollin'Dice\n");
    System.out.println("Testing: \n");

    // Create an object of rollDice
    rollDice roll = new rollDice();
    // Roll the dice
    roll.die1.roll();
    roll.die2.roll();
    // Print the dice values
    roll.printDice();

    System.out.println();
  }
}