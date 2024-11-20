import java.util.*;

public class Exam2_12 {
    public static int[] findIntersection(int[] arr1, int[] arr2) {
        // creating an array in the size of the smaller set to store the interesctions
        int[] intersections = new int[Math.min(arr1.length, arr2.length)];
        int index = 0;
        int i = 0; 
        int j = 0;

        // iterating through the arrays with two different index holders
        while (i < arr1.length && j < arr2.length) {
            // adding the common elements
            if (arr1[i] == arr2[j]) {
                intersections[index++] = arr1[i];
                i++;
                j++;
            // if the element in the array1 is smaller, we move the index in array1
            } else if (arr1[i] < arr2[j]) {
                i++;
            // if the element in the aaray2 is smaller, we move the index in array2
            } else {
                j++;
            }
        }

        /* 
        At this point the intersections array is full of different stuff.
        But we know that the valid part of the array is from 0 to index, 
        cause we only changed the index when we added an actual intersection
        */

        // so we can move from 0 to index of the interesction array to a new array
        int[] result = new int[index];
        for (int k = 0; k < index; k++) {
            result[k] = intersections[k];
        }

        return result;
    } 

    // testing it
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 5, 7, 9};
        int[] arr2 = {1, 4, 6, 7, 8, 10};

        System.out.println(Arrays.toString(findIntersection(arr1, arr2))); // [1, 4, 7]
    }
}