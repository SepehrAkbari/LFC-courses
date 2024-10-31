package Exams;

// Question 16

public class Exam1_16 {
    // Question 16 Solution
    public static String reverse(String s) {
        if (s.length() == 0) {
            return ""; // wont be reached if the user inputs correctly
        } else if (s.length() == 1) {
            return s; // base case
        } else {
            // returning last char followed by the rest of the string reversed
            return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
        }
    }

    public static void main(String[] args) {
        // Question 16 Testing
        System.out.println(reverse("sepehr"));
        System.out.println(reverse("M"));
        System.out.println(reverse(""));
    }
}