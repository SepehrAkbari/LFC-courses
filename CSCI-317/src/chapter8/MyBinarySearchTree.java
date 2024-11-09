package chapter8;

public class MyBinarySearchTree {

	private MyNode root;
	public MyBinarySearchTree() {
		root = null;
	}

	public MyBinarySearchTree(int data) {
		root = new MyNode(data);
	}

	public MyBinarySearchTree(MyNode root) {
		this.root = root;
	}


	public void insert(int key) {
		if(key < root.getData()) {
			if (root.getLeft()==null) {
				root.setLeft(new MyNode(key));
			}	
			else {	
				MyBinarySearchTree current = new MyBinarySearchTree(root.getLeft());
				current.insert(key);
			}
		}
		else if(key > root.getData()){
			if (root.getRight()==null) {
				root.setRight(new MyNode(key));
			}	
			else {
				MyBinarySearchTree current = new MyBinarySearchTree(root.getRight());
				current.insert(key);
			}
		}

		else // if key == data
			root.increaseFrequency();
	}

    /*
	/// This method is still incomplete
	public boolean remove(int key) {
		// First, find the item
		if(search(key)==false)
			return false;
		// Check if root is the only node and needs to be deleted
		if(root.getData()==key && 
				root.getLeft()==null && root.getRight()==null) {
			if(root.getFrequency()>1) {
				root.decreaseFrequency();
				return true;
			}
			else {
				root = null;
				return true;
			}
		}
		
		// Now decide if the key is left or right
		if(key < data) {
			MyBinarySearchTree current = this;
			while(current.left > key) {
				current = current.left;
			}

		}
		else if(key > data) {

		}
		else {//if key == data

			// Case 0: item has a frequency > 1
			if(frequency>1) {
				frequency--;
				return true;
			}
			// Case 1: item is a leaf
			if()

				// Case 2: item has one child
				// Case 3: item has two children
		}

	}
    */


	public boolean search(int key) {
		if(key < root.getData()) {
			if (root.getLeft()==null)
				return false;
			else {
				MyBinarySearchTree current = new MyBinarySearchTree(root.getLeft());	
				return current.search(key);
			}
		}
		else if(key > root.getData()){

			if(root.getRight()==null)
				return false;
			else {
				MyBinarySearchTree current = new MyBinarySearchTree(root.getRight());
				return current.search(key);
			}
		}
		else // if key == data
			return true;

	}

	public void inorder() {
		if(root.getLeft()!=null) {
			MyBinarySearchTree current = new MyBinarySearchTree(root.getLeft());
			current.inorder();
		}
		for(int i =0; i<root.getFrequency(); i++)
			System.out.print(root.getData()+" ");
		if(root.getRight()!=null) {
			MyBinarySearchTree current = new MyBinarySearchTree(root.getRight());
			current.inorder();

		}
	}

	public int getHeight() {
		return root.height();
	}


}