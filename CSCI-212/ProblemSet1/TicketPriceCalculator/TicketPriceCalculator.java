/*
 * Author @ Sepehr Akbari (Compiler)
 * Feb 28, 2024
 * Title: "Wallet Damage - Calculator"
 * Desc:  
    * Write a program called TicketPriceCalculator. The input 
    * from the end user consists of the following: day of show 
    * (weekday/weekend), time of show (2 PM or 7 PM), customer's 
    * age, and number of tickets to be purchased together; it 
    * prints the individual ticket price for a Broadway show. 
    * The output should clearly indicate the price, along with all 
    * the show details provided as input (day, time, group size, age) 
    * in a user-friendly way.
    *
    *    The price is determined  based on the following criteria: 
    *       - the full price for weekday shows is  $80; on weekends is $100;
    *       - the matinee (2 PM show) has a 10% discount;
    *       - groups of 8 people or more have an additional 15% discount;
    *       - seniors (65 and over) have a 20% discount;
    *       - kids under 5 are free;
    *       - multiple discounts can be applied. 
    *   
    * Points: [20 points]
*/

package TicketPriceCalculator;
import java.util.*;

public class TicketPriceCalculator {
    // Scanner object to get the input from the user
    static Scanner sc = new Scanner(System.in);

    // Main function
    public static void main(String[] args){
        // Variables to store the input from the user
        String DayIn, TimeIn;
        int GroupSizeIn, AgeIn;
        double Price;

        // Printing the title of the program
        System.out.println("\n Wallet Damage - Calculator \n");

        // Calling the functions to get the input from the user
        DayIn = GetDay();
        TimeIn = GetTime();
        GroupSizeIn = GetGroupSize();
        AgeIn = GetAge();

        // Calling the function to calculate the price
        Price = GetPrice(DayIn, TimeIn, GroupSizeIn, AgeIn);

        // Calling the function to print the price
        PrintPrice(Price);
    }

    // Function to get the day of the show
    public static String GetDay() {
        // Variable to store the input from the user
        String day = "";

        // Getting a valid input from the user (either 'weekday' or 'weekend')
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Enter the day of the show (weekday/weekend): ");
                // Getting the input from the user
                day = sc.nextLine();
                if (day.equalsIgnoreCase("weekday") || day.equalsIgnoreCase("weekend")) {
                    // Breaking the loop
                    valid = true;
                } else {
                    System.out.println("Invalid input. Please only enter 'weekday' or 'weekend'.");
                }
            // Catching the exception if the input is not a string
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid string.");
                // Clearing the buffer
                sc.next();
            }
        }
        // Returning the day
        return day;
    }

    // Function to get the time of the show
    public static String GetTime() {
        // Variable to store the input from the user
        String time = "";

        // Getting a valid input from the user (either '2 PM' or '7 PM')
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Enter the time of the show (2 PM or 7 PM): ");
                // Getting the input from the user
                time = sc.nextLine();
                if (time.equalsIgnoreCase("2 PM") || time.equalsIgnoreCase("7 PM")) {
                    // Breaking the loop
                    valid = true;
                } else {
                    System.out.println("Invalid input. Please only enter '2 PM' or '7 PM'.");
                }
            // Catching the exception if the input is not a string
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid string.");
                // Clearing the buffer
                sc.next();
            }
        }
        // Returning the time
        return time;
    }

    // Function to get the group size from the user
    public static int GetGroupSize() {
        // Variable to store the input from the user
        int groupSize = 0;
        
        // Getting a valid input from the user (a positive integer & not 0)
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Enter the number of tickets you would like to purchase: ");
                // Getting the input from the user
                groupSize = sc.nextInt();
                if (groupSize > 0) {
                    // Breaking the loop
                    valid = true;
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
        // Returning the group size
        return groupSize;
    }

    // Function to get the age from the user
    public static int GetAge() {
        // Variable to store the input from the user
        int age = 0;

        // Getting a valid input from the user (a positive integer & not 0)
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Enter your age: ");
                // Getting the input from the user
                age = sc.nextInt();
                if (age > 0) {
                    // Breaking the loop
                    valid = true;
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
        // Returning the age
        return age;
    }

    // Function to calculate the price
    public static double GetPrice(String day, String time, int groupSize, int age) {
        // Variable to store the price
        double price = 0;

        // If the day is a weekday, the price is $80;
        if (day.equalsIgnoreCase("weekday")) {
            price = 80;
        // otherwise, it's $100
        } else {
            price = 100;
        }

        // If the time is 2 PM, there's a 10% discount
        if (time.equalsIgnoreCase("2 PM")) {
            price *= 0.9;
        }

        // If the group size is 8 or more, there's an additional 15% discount   
        if (groupSize >= 8) {
            price *= 0.85;
        }

        // If the age is 65 or more, there's a 20% discount
        if (age >= 65) {
            price *= 0.8;
        }

        // If the age is less than 5, the price is 0
        if (age < 5) {
            price = 0;
        }

        // Returning the price
        return price;
    }

    // Function to print the price
    public static void PrintPrice(double price) {
        // Printing the price
        System.out.println("The individual ticket price for the show is: $" + price + "\n");

        // Getting a valid input from the user (either 0 or 1)
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Enter 0 to exit. To see how the price was calculated, enter 1: ");
                // Getting the input from the user
                int choice = sc.nextInt();
                // If the user enters 1, print the criteria for the price
                if (choice == 1) {
                    System.out.println("\n The price was calculated based on the following criteria: ");
                    System.out.println("   - the full price for weekday shows is  $80; on weekends is $100;");
                    System.out.println("   - the matinee (2 PM show) has a 10% discount;");
                    System.out.println("   - groups of 8 people or more have an additional 15% discount;");
                    System.out.println("   - seniors (65 and over) have a 20% discount;");
                    System.out.println("   - kids under 5 are free;");
                    System.out.println("   - multiple discounts can be applied. \n\n");

                    System.out.println("\n Enjoy the show!");
                    // Exit
                    System.exit(0);
                    // Breaking the loop
                    valid = true;
                // If the user enters 0, exit the program
                } else if (choice == 0) {
                    System.out.println("\n Enjoy the show!");
                    // Exit
                    System.exit(0);
                } else {
                    System.out.println("Invalid input. Please only enter 0 or 1.");
                }
            // Catching the exception if the input is not an integer
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                // Clearing the buffer
                sc.next();
            }
        }
    }
}
