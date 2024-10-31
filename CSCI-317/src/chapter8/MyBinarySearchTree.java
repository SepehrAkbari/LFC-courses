package chapter8;

public class MyBinarySearchTree extends MyBinaryTree {
    private int frequency;

    public MyBinarySearchTree(int data) {
        super(data);
        frequency = 1;
    }

    @Override
    public void insert(int key) {
        if (key < data) {
            if (left == null) {
                left = new MyBinarySearchTree(key);
            } else {
                left.insert(key);
            }
        } else if (key > data) {
            if (right == null) {
                right = new MyBinarySearchTree(key);
            } else {
                right.insert(key);
            }
        } else {
            frequency++;
        }
    }

    @Override
    public boolean remove(int key) {
        // First, find the item
        if (key < data) {
            if (left == null) {
                return false;
            } else {
                return left.remove(key);
            }
        } else if (key > data){
            if (right == null) {
                return false;
            } else {
                return right.remove(key);
            }
        } else {
            // Case 0: item has a frequency > 1
            if (frequency > 1) {
                frequency--;
                return true;
            }
            // Case 1: item is a leaf
            if (left == null && right == null) {
                return true;
            }
            
        }
        // Case 2: item has one child
        // Case 3: item has two children

        return false;
    }

    @Override
    public boolean search(int key) {
        if (key < data) {
            if (left == null) {
                return false;
            } else {
                return left.search(key);
            }
        } else if (key > data){
            if (right == null) {
                return false;
            } else {
                return right.search(key);
            }
        } else {
            return true;
        }
    }

    public void inOrder() {
        if (left != null) {
            ((MyBinarySearchTree) left).inOrder();
        }
        for (int i = 0; i < frequency; i++) {
            System.out.print(data + " ");
        }
        if (right != null) {
            ((MyBinarySearchTree) right).inOrder();
        }
    }
}
