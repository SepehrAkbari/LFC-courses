package chapter2.Fibonacci;

public class fibonacci {
    private static long[] data = new long[100];

    public static long fib(int n) {
        System.out.println(n);
        
        if (data[n] != 0) {
            return data[n];
        }

        if (n <= 1) {
            data[n] = n;
            return n;
        } else {
            data[n] =  fib(n - 1) + fib(n - 2);
            return data[n];
        }
    }
    public static void main(String[] args) {
        System.out.println(fib(50));
    }
}

