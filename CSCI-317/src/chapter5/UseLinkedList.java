package chapter5;

public class UseLinkedList {
    public static void main(String[] args) {
        MyLinkedList a = new MyLinkedList();
        MyLinkedList b = new MyLinkedList(25);

        a.insertAtIndex(42, 0);
        b.insertAtIndex(42, 0);

        /*
        for (int i = 0; i < 10; i++) {
            a.insertHead(i);
            b.insertHead(i);
        }

        a.insertAtIndex(42, 4);
        */

        System.out.println("a is " + a);
        System.out.println("b is " + b);

        a.removeTail();
        b.removeTail();

        System.out.println("a is " + a);
        System.out.println("b is " + b);
    }
}
