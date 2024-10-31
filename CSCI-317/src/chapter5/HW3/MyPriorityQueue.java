package chapter5.HW3;

// Homework 3
/*
Implement a priority queue class based on a sorted linked list of integers. The insert
operation on the priority queue should insert an item in its proper sorted position, and the
remove operation should remove the item with the smallest key. Using any code done in
class is acceptable, as long as you say so in a comment.
*/

public class MyPriorityQueue {
    private MyLinkedList list;

    public MyPriorityQueue() {
        list = new MyLinkedList();
    }

    public void insert(int item) {
        if (list.getCount() == 0) {
            list.insertHead(item);
        } else {
            MyLink current = list.head;
            MyLink prev = null;
            while (current != null && current.getData() < item) {
                prev = current;
                current = current.getNext();
            }
            if (prev == null) {
                list.insertHead(item);
            } else {
                MyLink temp = new MyLink(item);
                prev.setNext(temp);
                temp.setNext(current);
                list.count++;
            }
        }
    }

    public void remove() {
        if (list.head != null) {
            int x = list.removeHead();
            System.out.println(x + " removed");
        } else {
            System.out.println("Priority Queue is empty");
        }
    }

    public String toString() {
        return list.toString();
    }
}

// Code from class: MyLink.java
class MyLink {
    protected int data;
    protected MyLink next;

    public MyLink(int data) {
        this.data = data;
        this.next = null;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setNext(MyLink next) {
        this.next = next;
    }

    public MyLink getNext() {
        return next;
    }
}

// Code from class: MyLinkedList.java (partially)
class MyLinkedList {
    protected MyLink head; 
    protected int count;

    public MyLinkedList(int item) {
        head = new MyLink(item);
        count = 1;
    }

    public MyLinkedList() {
        head = null;
        count = 0;
    }

    public void insertHead(int item) {
        MyLink temp = new MyLink(item);
        temp.setNext(head);
        head = temp;
        count++;
    }

    public int removeHead() {
        if (head == null) {
            return Integer.MIN_VALUE;
        } else {
            int temp = head.getData();
            head = head.getNext();
            count--;
            return temp;
        }
    }

    public int getCount(){
        return count;
    }

    public String toString() {
        String output = "";
        if (head != null) {
            MyLink current = head;
            while (current != null) {
                output += current.getData() + " ";
                current = current.getNext();
            }
        }
        return output;
    }
}