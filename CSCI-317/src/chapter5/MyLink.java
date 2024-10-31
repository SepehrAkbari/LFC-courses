package chapter5;

public class MyLink {
    private int data;
    private MyLink next;

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
