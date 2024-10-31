package chapter6.HW4;
import chapter4.Stack.MyStack;

public class Homework4_Sepehr {
    public static void main(String[] args) {
        // PROBLEM ONE – TEST
        System.out.println("TESTING PROBLEM ONE \n");
        System.out.println("0: " + numToNames(0));
        System.out.println("5: " + numToNames(5));
        System.out.println("10: " + numToNames(10));
        System.out.println("372: " + numToNames(372));
        System.out.println("1234567890: " + numToNames(1234567890));

        System.out.println("\n");

        // PROBLEM TWO – TEST
        System.out.println("TESTING PROBLEM TWO \n");
        MyStack stack = new MyStack(8);
        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.push('1');
        stack.push('d');
        stack.push('e');
        stack.push('2');
        stack.push('f');

        System.out.print("Original Stack: ");
        stack.print();

        invertStack(stack);

        System.out.print("Inverted Stack: ");
        stack.print();
    }

    // PROBLEM ONE
    public static String digitToName(int digit) {
        switch (digit) {
            case 0:
                return "zero";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
        }
        return "";
    }

    public static String numToNames(int num) {
        if (num == 0) {
            return "zero";
        } else if (num < 10) {
            return digitToName(num);
        } else {
            return numToNames(num / 10) + " " + digitToName(num % 10);
        }
    }

    // PROBLEM TWO
    public static void invertStack(MyStack stack) {
        if (stack.isEmpty()) {
            return;
        }
        char temp = stack.pop();
        invertStack(stack);
        insertAtBottom(stack, temp);
    }
    
    private static void insertAtBottom(MyStack stack, char item) {
        if (stack.isEmpty()) {
            stack.push(item);
        } else {
            char temp = stack.pop();
            insertAtBottom(stack, item);
            stack.push(temp);
        }
    }
}
