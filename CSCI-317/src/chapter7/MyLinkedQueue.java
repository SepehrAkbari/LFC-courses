package chapter7;

import chapter5.MyLink;

public class MyLinkedQueue {

	private MyLink head;
	private int count;
	
	
	//constructor
	public MyLinkedQueue() {
		head = null;
		count = 0;
	}
	
	//insert at the beginning
	private void insertHead(int item) {
		MyLink temp = new MyLink(item);
		temp.setNext(head);
		head = temp;
		count++;
	}
	
	//insert at the end (insertTail)
	public void insert(int item) {
			
		if(head==null) {
			insertHead(item);
			return;
		}
		MyLink current = head;
		while(current.getNext() != null)
			current = current.getNext();
		
		MyLink temp = new MyLink(item);
		current.setNext(temp);
		count++;
	}
	
	//remove from the head(removeHead)
	public int remove() {
		if(head==null)
			return Integer.MIN_VALUE;
		else {
			int temp = head.getData();
			head = head.getNext();
			count--;
			return temp;
		}
		
	}
		
	public int getCount() {
		return count;
	}
	
	public String toString() {
		String output = "";
		if(head != null) {
			MyLink current = head;
			while(current != null) {
				output += current.getData() + " ";
				current = current.getNext();
			}
		}
		return output;
			
	}
}