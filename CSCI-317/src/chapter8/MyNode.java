package chapter8;

public class MyNode {

	private int data;
	private int frequency;
	private MyNode left;
	private MyNode right;

	public MyNode(int data) {
		this.data = data;
		frequency = 1;
		left = null;
		right = null;
	}

	public int getData() {
		return data;
	}

	public MyNode getLeft() {
		return left;
	}

	public MyNode getRight() {
		return right;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setLeft(MyNode node) {
		left = node;
	}

	public void setRight(MyNode node) {
		right = node;
	}
	
	public int getFrequency() {
		return frequency;
	}
	
	public void increaseFrequency() {
		frequency++;
	}
	
	public void decreaseFrequency() {
		frequency--;
	}

	public int height() {
		int h;
		if(left==null && right==null)
			return 0;
		else if(left==null)
			h = right.height()+1;
		else if(right==null)
			h = left.height()+1;
		else if(left.height()>=right.height())
			h = left.height()+1;
		else
			h = right.height()+1;
		return h;
	}

}