package chapter9;

public class MyHashTable {
	private long[] data;
	private int count;
	
	public MyHashTable(int size) {
		/* Should we use size directly? More on this later... */
		data = new long[size];
		count = 0;
	}
	
	private int hash(long value) {
		int key = (int)(value % data.length);
		return key;
	}
	
	public boolean insert(long key) {
		if(!isFull()) {
			int index = hash(key);
			if(data[index] == 0)//No data at that spot
				data[index] = key;
			else {
				while(data[index]>0) {//Keep probing for empty spot
					index++;
					if(index==data.length)//Go back to the beginning
						index = 0;
				}
				data[index] = key;
			}
			count++;
			return true;
		}
		else
			return false;
	}
	
	public boolean remove(long key) {
		int index = hash(key);
		if(data[index] == key) {
			data[index] = -1;
			count--;
			return true;
		}			
		else {
			while(data[index] != 0) {//Keep probing for empty spot
				index++;
				if(index==data.length)//Go back to the beginning
					index = 0;
				if(data[index]==key) {
					data[index] = -1;
					count--;
					return true;
				}
			} 
			return false;
		}
		
	}
	
	public boolean search(long key) {
		int index = hash(key);
		if(data[index] == key)
			return true;
		else {
			int probings = 0;
			while(data[index] !=0) {//Keep probing for empty spot
				index++;
				probings++;
				if(probings>data.length)
					return false;
				if(index==data.length)//Go back to the beginning
					index = 0;
				if(data[index]==key)
					return true;
			} 
			return false;
		}
	}
	
	public boolean isFull() {
		return (count==data.length);
	}
	
	public boolean isEmpty() {
		return (count==0);
	}
	
	public void display() {
		for(int i=0; i<data.length; i++)
			System.out.println(i+":" + data[i]);
	}

}