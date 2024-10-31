package chapter3;

public class TrySorting {
    public static void main(String[] args) {
        final int SIZE = 100;

        int[] array = new int[SIZE];
        
        final int RANGE = 10;
        for (int i = 0; i < SIZE; i++) {
            array[i] = (int)(Math.random() * RANGE);
        }

        int[] arrayTwo = new int[5];
        for (int i = 0; i < 5; i++) {
            arrayTwo[i] = i + 1;
        }

        System.out.println(java.util.Arrays.toString(arrayTwo));
        Sorting.reverse(arrayTwo);
        System.out.println(java.util.Arrays.toString(arrayTwo));
    }

    public static void initialize(int[] array) {
        final int SIZE = 100;
        final int RANGE = 10;
        for (int i = 0; i < SIZE; i++) {
            array[i] = (int)(Math.random() * RANGE);
        }
    }
}
