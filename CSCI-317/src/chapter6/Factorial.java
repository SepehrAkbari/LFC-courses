package chapter6;

public class Factorial {
    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static long factorial2(int n) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("\n\nSTART\n");

        int m = 4;
        System.out.println(factorial(m));
        System.out.println(factorial2(m));
    }
}