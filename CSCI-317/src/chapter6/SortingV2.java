package chapter6;

public class SortingV2 {
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

    private static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int aptr = 0, bptr = 0, cptr = 0;

        while (aptr < a.length && bptr < b.length) {
            if (a[aptr] < b[bptr]) {
                c[cptr++] = a[aptr++];
            } else {
                c[cptr++] = b[bptr++];
            }
        }

        while (aptr < a.length) {
            c[cptr++] = a[aptr++];
        }

        while (bptr < b.length) {
            c[cptr++] = b[bptr++];
        }

        return c;
    }

    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        // } else if (array.length == 2) {
        //     if (array[0] > array[1]) {
        //         swap(array, 0, 1);
        // }
        } else {
            int mid = array.length / 2;
            int[] left = new int[mid];
            int[] right = new int[array.length - mid];

            for (int i = 0; i < mid; i++) {
                left[i] = array[i];
            }

            for (int i = mid; i < array.length; i++) {
                right[i - mid] = array[i];
            }

            mergeSort(left);
            mergeSort(right);

            int[] merged = merge(left, right);

            for (int i = 0; i < array.length; i++) {
                array[i] = merged[i];
            }
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
}
