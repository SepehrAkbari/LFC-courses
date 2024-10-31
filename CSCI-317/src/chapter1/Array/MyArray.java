package chapter1.Array;

public class MyArray {
    protected int[] array;
    protected int count;

    public MyArray(int size) {
        array = new int[size];
        count = 0;
    }

    public void add(int item){
        if (count == array.length) {
            grow();
        }
        array[count++] = item;   
    }

    protected void grow(){
        int[] temp = new int [array.length * 2];
        int i = 0;
        while (i < count) {
            temp[i] = array[i];
            i++;
        }
        array = temp;
    }

    public int remove(){
        if (count > 0) {
            return array[--count];
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public int search(int key){
        int i = 0;
        while (i < count) {
            if (array[i] == key) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int getCount(){
        return count;
    }

    public String toString(){
        String output = "";
        int i = 0;
        while (i < count) {
            output += array[i] + " ";
            i++;
        }
        return output;
    }
}
