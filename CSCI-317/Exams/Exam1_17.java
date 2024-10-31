package Exams;

// Question 17

/* Time complexity: O(n)

The first loop to calculate the total sum, takes O(n) time. As it iterates through every element once.
The second loop to takes O(n) time as well, cause it iterates only once, 
and the operations within the loop are just assignments and a conditional which are constant or O(1).

So overall we have O(n) + O(n) = O(2n) = O(n) time complexity.
*/

public class Exam1_17 {
    // Question 17 Solution
    public static int findPivot(int[] arr) {
        int totalSum = 0; // total sum of the array
        int leftSum = 0; // sum of left subarray based on the current pivot index
        int minDiff = Integer.MAX_VALUE; // just a placeholder for now
        int pivot = 0; // the index of the pivot element

        // total sum of the array
        for (int num : arr) {
            totalSum += num;
        }

        // finding the pivot index by iterating and chaning left and right sums until the difference is at its lowest and that point will be the pivot element
        for (int i = 0; i < arr.length; i++) {
            leftSum += arr[i];
            int rightSum = totalSum - leftSum;

            // chechking if the current difference is smaller than the previous minimum difference if it is we update the minimum difference and the pivot element
            int diff = Math.abs(leftSum - rightSum); // i use absolute value cause we care about the differnce not negativity or positivity but we need a positive number to compare
            if (diff < minDiff) {
                minDiff = diff;
                pivot = i;
            }
        }
        return pivot;
    }

    public static void main(String[] args) {
        // Question 17 Testing
        int[] arr1 = {1, 2, 4, 6, 7, 8, 10, 12};
        System.out.println(findPivot(arr1));
    
        int[] arr2 = {3, 1, 2, 6, 1, 1, 2, 3};
        System.out.println(findPivot(arr2));
    
        int[] arr3 = {5, 5, 5, 5, 5, 5};
        System.out.println(findPivot(arr3));
    
        int[] arr4 = {10, 20};
        System.out.println(findPivot(arr4));
    
        int[] arr5 = {-10, -20, -30, 40, 20};
        System.out.println(findPivot(arr5));
    
        int[] arr6 = {5};
        System.out.println(findPivot(arr6));
    
        int[] arr8 = {0, 0, 0, 0, 0};
        System.out.println(findPivot(arr8));
    }
}

