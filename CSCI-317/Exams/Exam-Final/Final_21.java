public class Final_21 {
    public static int[] getUnion(int[] arr1, int[] arr2) {
        int[] union = new int[arr1.length + arr2.length]; 
    
        int x = 0; // union's index
        int r1 = 0; // arr1's index
        int r2 = 0; // arr2's index

        // merging the arrays
        while (r1 < arr1.length && r2 < arr2.length) {
            if (arr1[r1] < arr2[r2]) {
                union[x] = arr1[r1];
                r1++;
                x++;
            } else if (arr1[r1] > arr2[r2]) {
                union[x] = arr2[r2];
                r2++;
                x++;
            // if the values are equal, i'll add only one of them but move on to the next index in both
            } else  if (arr1[r1] == arr2[r2]) {
                union[x] = arr1[r1];
                x++;
                r1++;
                r2++;
            }
        }

        // adding the remaining elements (if the arrays are not the same size)
        while (r1 < arr1.length) {
            union[x] = arr1[r1];
            x++;
            r1++;
        }

        while (r2 < arr2.length) {
            union[x] = arr2[r2];
            x++;
            r2++;
        }

        /* At this point [union] might have some 0's at the end, 
        for the spaces we created but never used. So I have to make a
         new array with length x and copy the values into that.
        */

        int[] unionCopy = new int[x];
        for (int i = 0; i < x; i++) {
            unionCopy[i] = union[i];
        }

        return unionCopy;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 5, 7, 9};
        int[] arr2 = {1, 4, 6, 7, 8, 10};

        int[] unions = getUnion(arr1, arr2);

        for (int i = 0; i < unions.length; i++) {
            System.out.print(unions[i] + " ");
        }
    }
}
