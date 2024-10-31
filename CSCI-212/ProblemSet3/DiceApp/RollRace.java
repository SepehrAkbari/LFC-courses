/*
 * Author @ Sepehr Akbari (Compiler)
 * File: RollRace Class
 * April 16, 2024
 * Title: "Rock & Rollin'Dice"
 * Desc:
    * Using the same Die class, write a program called RollRace that creates two Die objects, 
    * and keeps rolling them to see which one comes up three sixes in a row first. 
    * Continue rolling the dice until one of them wins the race and consider the possibility 
    * that they might tie. Print the results of each roll, and at the end print the winner and 
    * total number of rolls that were required.
 * 
 * Points: [15 points]
 */

// Packages & Imports
package DiceApp;

public class RollRace {
   // Dice objects
   Die die1 = new Die();
   Die die2 = new Die();

   // race() Method
   public void race() {
      // Iteration Count Variables
      int rolls = 0;
      int sixCount1 = 0;
      int sixCount2 = 0;

      // Roll Dice until one of them gets three sixes in a row
      while (sixCount1 < 3 || sixCount2 < 3) {
         // Roll Dice (using the roll method from Die class)
         die1.roll();
         die2.roll();

         // Print Dice values after every roll
         System.out.println("Die 1: " + die1.getValue());
         System.out.println("Die 2: " + die2.getValue());

         // Check if the firt die value is 6
         if (die1.getValue() == 6) {
            // Increment the counter if the value is 6
            sixCount1++;
         // Reset the counter if the value is not 6
         } else {
            sixCount1 = 0;
         }

         // Check if the second die value is 6
         if (die2.getValue() == 6) {
            // Increment the counter if the value is 6
            sixCount2++;
         // Reset the counter if the value is not 6
         } else {
            sixCount2 = 0;
         }

         // Increment the total number of rolls
         rolls++;
      }

      // Check for a tie
      if (sixCount1 == 3 && sixCount2 == 3) {
         System.out.println("\nIt's a tie!\n");
      // Check which if first die won
      } else if (sixCount1 == 3) {
         System.out.println("\nDie 1 wins!\n");
      // If not a tie and first die didn't win, second die wins
      } else {
         System.out.println("\nDie 2 wins!\n");
      }

      // Print the total number of rolls
      System.out.println("Number of rolls: " + rolls + "\n");
   }

   // main() method for testing (not required)
   public static void main(String[] args) {
      System.out.println("\n Rock & Rollin'Dice\n");
      System.out.println("Testing: \n");

      // Create an object of RollRace
      RollRace race1 = new RollRace();

      // Calling race()
      race1.race();

      System.out.println();
   }
}