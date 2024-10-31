package chapter4.Queue;

public class MyQueue {
    private char[] data;
    private int front, rear, count;

    public MyQueue(int size) {
        data = new char[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    public void enqueue(char value) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (rear < data.length - 1) {
                data[++rear] = value;
            } else {
                rear = -1;
                data[++rear] = value;
            }
        }
        count++;
    }

    public char dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return (char) 0;
        } else {
            count--;
            char item = data[front++];
            if (front == data.length) {
                front = 0;
            }
            return item;
        }
    }

    public boolean isFull() {
        return count == data.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int getLength() {
        return count;
    }

    public char peek() {
        return data[front];
    }

    // Homework 3
    /*
    The MyQueue class given in class implemented a circular queue. You should add a
    method to that class that displays the contents of the queue. Note that this does not mean
    simply displaying the contents of the underlying array. You should show the queue
    contents from the first item inserted to the last, without indicating to the viewer whether the
    sequence is broken by wrapping around the end of the array. Be careful that “one item”
    and “no items” conditions display properly, no matter where front and rear are. You can
    either do it by overriding the inherited toString() method or adding a separate public
    display() method. Both are correct answers.
    */
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else if (getLength() == 1) {
            System.out.println("Queue has one item: " + data[front]);
        } else {
            int i = front;
            while (i != rear) {
                System.out.print(data[i]);
                i++;
                if (i == data.length) {
                    i = 0;
                }
            }
            System.out.println(data[rear]);
        }
    }
}
