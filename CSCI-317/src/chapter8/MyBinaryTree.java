package chapter8;

public abstract class MyBinaryTree {
    protected int data;
    protected MyBinaryTree left;
    protected MyBinaryTree right;

    public MyBinaryTree(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public int getData() {
        return data;
    } 
    
    public MyBinaryTree getLeft() {
        return left;
    }

    public MyBinaryTree getRight() {
        return right;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(MyBinaryTree node) {
        left = node;
    }

    public void setRight(MyBinaryTree node) {
        right = node;
    }

    public int height() {
		int h;
		if(left == null && right == null) {
			return 0;
        } else if(left == null) {
			h = right.height() + 1;
        } else if(right == null) {
			h = left.height() + 1;
        } else if(left.height() >= right.height()) {
			h = left.height() + 1 ;
        } else {
			h = right.height() + 1;
        }
		return h;
	}

    public abstract void insert(int key);
    public abstract boolean remove(int key);
    public abstract boolean search(int key);
}