/*
TIME COMPLEXITY:

The time complexity for assigning variables and conditions is constant time, so let's just ignore them.
We have two loops, both iterating through the array exactly once, so the time complexity for one loop is O(n). 
So the overall complexity is O(2n), which is still equivalant to O(n).

Final Answer: O(n)
*/

package Practice;

public class Exam_Sepehr {
    // majorityElement method
    public static int majorityElement(int[] A) {
        // length of the array
        int n = A.length;
        // highest count of an element 
        int count = 0; 
        // times a certain element is repeated in our array
        int repeated = 0;
        // variable to store the majority element
        int element = 0;

        // I loop through the array to find the the elements with the higest count
        for (int i = 0; i < n; i++) {
            // if the count is 0, that means we don't have any preference about any elements, so we just assign it to the current element
            if (count == 0) {
                element = A[i];
                count = 1;
            } else {
                // if the current element is the same as the previous element, we increase the count as it is appearing again
                if (A[i] == element) {
                    count++;
                // if it does not match, we decrease the count
                } else {
                    count--; // the reason we reduce the count here is to allow it to reach zero so then we can assign the next item to the element variable
                }
            }
        }
        // After the loop, we have the element with the highest repetition

        // Now we just have to see how many times exactly it appears, which is just a simple iteration
        for (int i = 0; i < n; i++) {
            if (A[i] == element) {
                repeated++;
            }
        }

        // Now that we have the count, we'll check if it is more than n/2 or not
        if (repeated > n / 2) {
            return element;
        } else {
            return -1;
        }
    }

    // testing majorityElement()
    public static void main(String[] args) {
        int[] A = { 3, 3, 4, 2, 4, 4, 2, 4, 4 };
        System.out.println(majorityElement(A));

        int[] B = { 3, 3, 4, 2, 4, 4, 2, 4 };
        System.out.println(majorityElement(B));

        int[] C = {1, 1, 1};
        System.out.println(majorityElement(C));

        int[] D = {5, 2, 5};
        System.out.println(majorityElement(D));

        int[] E = {1, 1, 1, 2, 2, 2};
        System.out.println(majorityElement(E));
    }
}