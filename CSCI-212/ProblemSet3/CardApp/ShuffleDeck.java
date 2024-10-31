/*
 * Author @ Sepehr Akbari (Compiler)
 * File: ShuffleDeck Class
 * April 16, 2024
 * Title: "Card Game: How I lost my life savings!"
 * Desc:
    * Define a driver class called ShuffleDeck with a main() method that does the following:
        * creates an array of 52 card objects called deck
        * use nested for loops to initialize all 52 cards to the four suits and 13 values, in order
        * use a for:each loop to print the entire deck (one card on each line)
        * use a loop with a random number generator to shuffle the deck. That means, take each card at index positions 0-51 one by one, and swap it with another randomly selected card in the deck.
        * use a for:each loop to print the shuffled deck (one card on each line)
    * Hint: Use an array of 52 Card objects.
 *
 * Points: [30 points]
 */

// Packages & Imports
package CardApp;
//import CardApp.Card; // Uncomment this line if you are running this file separately (locally)
import java.util.*;

public class ShuffleDeck {
    // Random object
    static Random rand = new Random();

    // Creating an array of 52 card objects called deck
    static Card[] deck = new Card[52];

    // Method to initialize cards
    public static void initializeDeck(Card[] deck) {
        int index = 0;
        // Use nested for loops to initialize all 52 cards to the four suits and 13 values, in order
        for (int i = 0; i < 4; i++) { 
            // Loop through the 13 values  
            for (int value = 1; value <= 13; value++) {
                // Create a card object and add it to the deck
                String suit = new String[] {"Diamonds", "Hearts", "Clubs", "Spades"}[i];
                // Add the card to the deck
                deck[index] = new Card(value, suit);
                // Increment the index
                index++;
            }
        }
    }

    // Method to shuffle the deck
    public static void shuffleDeck(Card[] deck) {
        for (int i = 0; i < deck.length; i++) {
            // Generate a random index
            int randomIndex = rand.nextInt(deck.length);
            // Swap the cards randomly
            Card temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }

    // Method to print the deck
    public static void printDeck(Card[] deck) {
        for (Card card : deck) {
            System.out.println(card);
        }
    }

    // main() method for testing (not required)
    public static void main(String[] args) {
        System.out.println("\n Card Game: How I lost my life savings! \n");

        // Initialize the deck
        initializeDeck(deck);
        // Print the deck
        System.out.println(" Initial Deck:\n");
        printDeck(deck);
        // Shuffle the deck
        shuffleDeck(deck);
        // Print the shuffled deck
        System.out.println("\n\n Shuffled Deck:\n");
        printDeck(deck);

        System.out.println();
    }
}