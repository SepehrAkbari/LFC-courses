public class Final_22 {
    public static void getMode(int[] arr) {
        int mode = arr[0]; // Starting with the first element as the mode
        int maxCount = 0; // The frequency of the most repeated number

        // counting all the elements and updating maxCount as we go
        for (int i = 0; i < arr.length; i++) {
            int count = 0;

            // getting frequency of arr[i] (we are basically doing this with two pointers)
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }

            // if the coint for arr[i] is bigger than maxCount, we'll update it
            if (count > maxCount) {
                maxCount = count;
                mode = arr[i];
            }
        }

        // At the end, the number that was assigned to maxCount last (the most frequent) will remain the mode
        System.out.println(mode);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 5, 2, 1, 1, 2, 2, 4, 2, 2};

        getMode(arr);
    }
}
