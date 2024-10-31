package chapter1.Array;
//import chapter1.MyArray;

public class UseArray {
    public static void main(String[] args) {
        MyArray ma = new MyArray(3);
        System.out.println(ma);
        System.out.println(ma.getCount());
        ma.add(3);
        ma.add(4);
        ma.add(5);
        ma.add(6);
        System.out.println(ma);
        System.out.println(ma.getCount());
        System.out.println(ma.remove());
        System.out.println(ma.search(4));
        System.out.println(ma.search(5));
        System.out.println(ma);
    }
}
