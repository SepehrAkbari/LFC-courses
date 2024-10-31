package chapter4.Stack;

public class UseStack {
    public static void main(String[] args) {
        MyStack s = new MyStack(5);
        String text = "Lake Forest College";
        for (int i = 0; i < 6; i++) {
            System.out.println("Pushing " + text.charAt(i));
            s.push(text.charAt(i));
        }
        System.out.println();
        System.out.println("Item on top is " + s.peek());
        while (!s.isEmpty()) {
            System.out.println("Popping " + s.pop());
        }
        s.pop();
    }
}
