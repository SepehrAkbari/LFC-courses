package chapter6;

public class Hanoi {
    private static int count = 0;

    public static void solve(int num, String source, String destination, String intermediate) {
        if (num == 1) {
            count++;
            System.out.println("Move top disk from " + source + " to " + destination);
        } else {
            solve(num - 1, source, intermediate, destination);
            solve(1, source, destination, intermediate);
            solve(num - 1, intermediate, destination, source);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        solve(n, "A", "C", "B");
        System.out.println("The puzzle with " + n + " disks is solved in " + count + " moves.");
    }
}
