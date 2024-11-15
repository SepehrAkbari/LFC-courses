package chapter8;

public class MyBinarySearchTree {

	private MyNode root;
	private int count;

	public MyBinarySearchTree() {
		root = null;
		count = 0;
	}

	public MyBinarySearchTree(int data) {
		root = new MyNode(data);
		count = 1;
	}
	
	public void insert(int key) {
		root = insertRec(root, key);
	}

	private MyNode insertRec(MyNode root, int key) {
		if(root==null) {
			root = new MyNode(key);
			return root;
		}
		
		if(root.getData()>key) {
			//insert on left subtree
			root.setLeft(insertRec(root.getLeft(), key));
		}
		else if(root.getData() < key) {
			//insert on right subtree
			root.setRight(insertRec(root.getRight(), key));
		}
		else // if key == data
			root.increaseFrequency();
		count++;
		return root;
	}

	public void remove(int key) {
		root = removeRec(root, key);

	}
	
	public MyNode removeRec(MyNode root, int key) {
		if(root==null)
			return root;
		
		if(key < root.getData()) {
			// remove from left subtree
			root.setLeft(removeRec(root.getLeft(), key));
		}
		else if(key > root.getData()) {
			// remove from right subtree
			root.setRight(removeRec(root.getRight(), key));
		}
		else { //root == key
			if(root.getFrequency()>1)
				root.decreaseFrequency();
			else {
				//write the deletion code
				// if we're at a leaf
				if(root.getLeft()==null && root.getRight()==null)
					root = null;
				else if(root.getLeft()==null)// we only have the right child
					return root.getRight();
				else if(root.getRight()==null)// we only have the left child
					return root.getLeft();
				else {//we have two children
					int min = findMin(root);
					root.setData(min);
					root.setRight(removeRec(root.getRight(), min));
				}
			}
			count--;
		}
		
		return root;

	}
	
	public int findMin(MyNode root) {
		if(root.getLeft()==null)
			return root.getData();
		else
			return findMin(root.getLeft());
	}
	
	public boolean search(int key) {
		return searchRec(root, key);
	}

	private boolean searchRec(MyNode root, int key) {
		if(root==null)
			return false;
		if(key < root.getData())//search left subtree
				return searchRec(root.getLeft(),key);
		else if(key > root.getData())//search right subtree
			return searchRec(root.getRight(),key);
		else // if key == data
			return true;

	}
	
	public void inorder() {
		inorderRec(root);
	}

	private void inorderRec(MyNode root) {
		if(root==null)
			return;
		inorderRec(root.getLeft());
		
		for(int i =0; i<root.getFrequency(); i++)
			System.out.print(root.getData()+" ");
		
		inorderRec(root.getRight());
	}

	public int getHeight() {
		return root.height();
	}

	public int getCount() {
		return count;
	}

}