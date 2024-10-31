package chapter2.OrderedArray;

public class UseOrderedArray {
    public static void main(String[] args) {
        int size = 100000;
        MyOrderedArray ma = new MyOrderedArray(size);
        for (int i = 0; i < size; i++) {
            ma.add((int) (Math.random() * 100));
        }

        System.out.println(ma.getCount());
        System.out.println(ma.search(3));
        System.out.println(ma.search(6000));
    }
}
