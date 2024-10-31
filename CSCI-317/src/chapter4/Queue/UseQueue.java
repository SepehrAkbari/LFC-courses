package chapter4.Queue;

public class UseQueue {
    public static void main(String[] args) {
        MyQueue q = new MyQueue(5);

        String text = "Hello";
        for (int i = 0; i < text.length(); i++) {
            if (q.isFull()) {
                System.out.println("Queue is full");
                break;
            }
            q.enqueue(text.charAt(i));
        }
        System.out.println("1:");
        q.display();

        q.dequeue();
        q.dequeue();
        q.dequeue();
        
        System.out.println("2:");
        q.display();

        q.enqueue('X');
        q.dequeue();
        q.dequeue();
        
        System.out.println("3:");
        q.display();
    }
}
