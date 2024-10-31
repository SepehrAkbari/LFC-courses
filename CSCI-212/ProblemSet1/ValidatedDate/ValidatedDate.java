/*
 * Author @ Sepehr Akbari (Compiler)
 * Feb 28, 2024
 * Title: "Let's go on a - Validated - Date!"
 * Desc: 
    * Write a program called ValidatedDate that asks the user 
    * to input a month (number), a date and a year. The month should 
    * be in the range 1-12, the date should be a valid date for the month 
    * and the year. The year should be between 1900 and 2023. The program 
    * should not accept any invalid date. Finally, print the date entered. 
    * (Notes: Remember that September, April, June and November have 30 days 
    * each, and the rest (other than February) have 31. February has 28 days 
    * in non-leap years and 29 days in leap years. 
 * 
 * Points: [30 points]
*/

package ValidatedDate;
import java.util.*;

public class ValidatedDate {
    // Scanner object to get the input from the user
    static Scanner sc = new Scanner(System.in);
   
    // Main function
    public static void main(String[] args){
        // Variables to store the input from the user
        int monthIn, dateIn, yearIn;
        // Variable to store the user's response to the date format
        int response;

        // Printing the title of the program
        System.out.println("\n 3Let's go on a - Validated - Date! \n");

        // Calling the functions to get the input from the user
        yearIn = GetYear();
        monthIn = GetMonth();
        dateIn = GetDate(yearIn, monthIn);

        // Asking the user to choose the date format
        boolean ZeroOrOne = false;
        while (!ZeroOrOne){
            try {
                System.out.print("Please enter 0 to display the date in the format MM/DD/YYYY or 1 to display the date in the format DD/MM/YYYY: ");
                // Getting the input from the user
                response = sc.nextInt();

                if (response == 0) {
                    // Printing the date in the format: MM/DD/YYYY
                    System.out.println("The date entered is: " + monthIn + "/" + dateIn + "/" + yearIn);
                    // Breaking the loop
                    ZeroOrOne = true;
                } else if (response == 1) {
                    // Printing the date in the format: DD/MM/YYYY
                    System.out.println("The date entered is: " + dateIn + "/" + monthIn + "/" + yearIn);
                    // Breaking the loop
                    ZeroOrOne = true;
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

    // Function to get the year from the user
    public static int GetYear() {
        // initializing the year
        int year = 0;

        // Getting a valid input from the user (an integer between 1900 and 2023)
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Enter the year (1900-2023): ");
                // Getting the input from the user
                year = sc.nextInt();

                if (year >= 1900 && year <= 2023) {
                    // Breaking the loop
                    valid = true;
                } else {
                    System.out.println("Invalid input. Year must be between 1900 and 2023.");
                }
            // Catching the exception if the input is not an integer
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                // Clearing the buffer
                sc.next();
            }
        }
        // Returning the year
        return year;
    }

    // Function to get the month from the user
    public static int GetMonth() {
        // initializing the month
        int month = 0;

        // Getting a valid input from the user (an integer between 1 and 12)
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Enter a month (1-12): ");
                // Getting the input from the user
                month = sc.nextInt();

                if (month >= 1 && month <= 12) {
                    // Breaking the loop
                    valid = true;
                } else {
                    System.out.println("Invalid input. Month must be between 1 and 12.");
                }
            // Catching the exception if the input is not an integer
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                // Clearing the buffer
                sc.next();
            }
        }
        // Returning the month
        return month;
    }

    // Function to get the date from the user
    public static int GetDate(int year, int month) {
        // initializing the date
        int date = 0;

        boolean valid = false;
        // Conditioning if the month is February and if it's a leap year
        if ((month == 2) && IsLeapYear(year)) {
            // Getting a valid input from the user (an integer between 1 and 29)
            while (!valid) {
                try {
                    System.out.print("Enter a date (1-29): ");
                    // Getting the input from the user
                    date = sc.nextInt();
    
                    if (date >= 1 && date <= 29) {
                        // Breaking the loop
                        valid = true;
                    } else {
                        System.out.println("Invalid input. Date must be between 1 and 29.");
                    }
                // Catching the exception if the input is not an integer
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    // Clearing the buffer
                    sc.next();
                }
            }
        // Conditioning if the month is February and if it's not a leap year
        }else if ((month == 2) && !(IsLeapYear(year))) {
            // Getting a valid input from the user (an integer between 1 and 28)
            while (!valid) {
                try {
                    System.out.print("Enter a date (1-28): ");
                    // Getting the input from the user
                    date = sc.nextInt();
    
                    if (date >= 1 && date <= 28) {
                        // Breaking the loop
                        valid = true;
                    } else {
                        System.out.println("Invalid input. Date must be between 1 and 28.");
                    }
                // Catching the exception if the input is not an integer
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    // Clearing the buffer
                    sc.next();
                }
            }
        // Conditioning if the month is September, April, June or November
        }else if (month == 4 || month == 6 || month == 9 || month == 11) {
            // Getting a valid input from the user (an integer between 1 and 30)
            while (!valid) {
                try {
                    System.out.print("Enter a date (1-30): ");
                    // Getting the input from the user
                    date = sc.nextInt();
    
                    if (date >= 1 && date <= 30) {
                        // Breaking the loop
                        valid = true;
                    } else {
                        System.out.println("Invalid input. Date must be between 1 and 30.");
                    }
                // Catching the exception if the input is not an integer
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    // Clearing the buffer
                    sc.next();
                }
            }
        // Conditioning if the month is January, March, May, July, August, October or December
        }else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            // Getting a valid input from the user (an integer between 1 and 31)
            while (!valid) {
                try {
                    System.out.print("Enter a date (1-31): ");
                    // Getting the input from the user
                    date = sc.nextInt();
    
                    if (date >= 1 && date <= 31) {
                        // Breaking the loop
                        valid = true;
                    } else {
                        System.out.println("Invalid input. Date must be between 1 and 31.");
                    }
                // Catching the exception if the input is not an integer
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    // Clearing the buffer
                    sc.next();
                }
            }
        // In case of terminal error
        }else{
            System.out.println("Something went wrong.");
            // Killing the program
            return 0;
        }
        // Returning the date
        return date;
    }

    // Function to check if a year is a leap year or not
    public static boolean IsLeapYear(int year) {
        return ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)));
    }
}
