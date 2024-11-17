package chapter8;

public class TestBST {

	public static void main(String[] args) {
		MyBinarySearchTree bst = new MyBinarySearchTree(50);
		System.out.println("No. of nodes="+bst.getCount());
		bst.insert(30);
		bst.insert(70);
		bst.insert(60);
		bst.insert(25);
		bst.insert(45);
		bst.insert(40);
		bst.insert(40);
		bst.insert(48);
		bst.insert(43);
		System.out.println("No. of nodes="+bst.getCount());
		System.out.println("Height of tree="+bst.getHeight());
		System.out.println(bst.search(6));
		System.out.println(bst.search(2));
		bst.inorder();
//		System.out.println();
//		System.out.println(bst.remove(30));
//		bst.inorder();
//		System.out.println();
//		System.out.println("No. of nodes="+bst.getCount());
//		System.out.println(bst.getHeight());
		bst.balance();
		bst.inorder();
		bst.balance();
		bst.inorder();
		bst.balance();
	}

}