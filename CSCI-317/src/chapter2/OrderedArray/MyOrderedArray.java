package chapter2.OrderedArray;

public class MyOrderedArray extends chapter1.Array.MyArray {
    public MyOrderedArray(int size) {
        super(size);
    }
    
    public int search(int key) {
        return binarySearch(key, 0, count - 1);
    }
    
    public int binarySearch(int key, int lowerBound, int upperBound){
        int middle = (lowerBound + upperBound) / 2;
        if (array[middle] == key) {
            return middle;
        } else if (lowerBound > upperBound) {
            return -1;
        } else {
            if (array[middle] < key) {
                return binarySearch(key, middle + 1, upperBound);
            } else {
                return binarySearch(key, lowerBound, middle - 1);
            }
        }
    }

    public void add(int item){
        if (count == array.length) {
            grow();
        }

        int i = count - 1;
        while (i >= 0 && array[i] > item) {
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = item;
        count++;
    }

    public boolean removeKey(int key){
        int index = search(key);
        if (index == -1){
            return false;
        } else {
            int i = index;
            while (i < count - 1) {
                array[i] = array[i + 1];
                i++;
            }
            count--;
            return true;
        }
    }
}