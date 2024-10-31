package chapter4.Stack;

public class MyStack {
    public char[] data;
    private int top;

    public MyStack(int size) {
        data = new char[size];
        top = -1;
    }

    public void push(char c) {
        if (!isFull()){
            data[++top] = c;
        } else {
            System.out.println("Stack is full");
        }
    }

    public char pop() {
        if (!isEmpty()) {
            return data[top--];
        } else {
            System.out.println("Stack is empty");
            return (char) 0;
        }
    }

    public char peek() {
        if (!isEmpty()) {
            return data[top];
        } else {
            System.out.println("Stack is empty");
            return (char) 0;
        }
    }

    public boolean isFull() {
        return top == data.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}