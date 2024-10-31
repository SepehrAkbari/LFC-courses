package chapter3;

public class Sorting {
    public static void main(String[] args) {
        final int SIZE = 100000;
        int[] myArray = new int[SIZE];
        long start, end;

        for (int i = 0; i < SIZE; i++) {
            myArray[i] = (int)(Math.random() * SIZE);
        }

        start = System.currentTimeMillis();
        insertionSort(myArray);
        end = System.currentTimeMillis();
        System.out.println("\nNormal Array; time taken: " + (end - start) + "ms.\n");

        reverse(myArray);
        
        start = System.currentTimeMillis();
        insertionSort(myArray);
        end = System.currentTimeMillis();
        System.out.println("Reversed; time taken: " + (end - start) + "ms.\n");

        start = System.currentTimeMillis();
        insertionSort(myArray);
        end = System.currentTimeMillis();
        System.out.println("Sorted; time taken: " + (end - start) + "ms.");

    }

    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void selectionSort(int[] array) {
        int current = 0;
        for (int j = 0; j < array.length; j++) {
            int smallestIndex = current + 1;
            for (int i = current + 1; i < array.length; i++) {
                if (array[i] < array[current]) {
                    smallestIndex = i;
                }
            }
            if (array[smallestIndex] < array[current]) {
                swap(array, current, smallestIndex);
            }
            current++;
        }
    }

    public static void insertionSort(int[] array) {
        int lastSorted = 0;
        for (int j = 0; j < array.length - 1; j++) {
            int firstUnsorted = lastSorted + 1;
            int marked = array[firstUnsorted];
            int i;

            for (i = lastSorted; i >= 0; i--) {
                if (marked < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }

            array[i + 1] = marked;
            lastSorted++;
        }
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // HW 2
    public static void reverse(int[] array) {
        /* to reverse an array, we swap the first element with the last element,
        the second element with the second to last element, and so on. */
        for (int i = 0; i < array.length / 2; i++) {
            swap(array, i, array.length - 1 - i);
        }
    }
}

// Homework 2 Output:
/*
Normal Array; time taken: 1752ms.

Reversed; time taken: 997ms.

Sorted; time taken: 1ms.
*/