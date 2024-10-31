package chapter6;

public class RecursivePower {
    public static long power2(int base, int index) {
        if (index == 0) {
            return 1;
        } else {
            return base * power2(base, index - 1);
        }
    } // same efficiency as a while loop

    public static long power(int base, int index) {
        if (index == 0) {
            return 1;
        } else {
            long ans = power(base, index / 2);
            ans = ans * ans;
            if (index % 2 == 1) {
                return ans * base;
            } else {
                return ans;
            } 
        }
    } // more efficient than power2
}
