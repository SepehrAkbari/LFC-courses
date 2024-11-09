package chapter9;

// Code is based on the MyHashTable class given in class, insert() method was modified and rehash() added
class MyHashTable2 {
	private long[] data;
	private int count;
	
	public MyHashTable2(int size) {
		/* Should we use size directly? More on this later... */
		int s = size;
		while(!isPrime(s++));
		data = new long[s-1];
		System.out.println("Created a hash table of size "+data.length);
		count = 0;
	}
	
	private boolean isPrime(int num) {
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0)
				return false;
		}
		return true;
	}
	
	
	private int hash(long value) {
		int key = (int)(value % data.length);
		return key;
	}
	
	public boolean insert(long key) {
        if ((double) count / data.length > 0.5) {
            rehash();
        }

        int index = hash(key);
        if (data[index] == 0)
            data[index] = key;
        else {
            while (data[index] > 0) {
                index++;
                if (index == data.length)
                    index = 0;
            }
            data[index] = key;
        }
        count++;
        return true;
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

    // REHASH() METHOD
    public void rehash() {
        int newSize = data.length * 2;
        while (!isPrime(newSize)) newSize++;
    
        long[] oldData = data;
        data = new long[newSize];
        count = 0;
    
        for (long key : oldData) {
            if (key > 0) { 
                insert(key);
            }
        }
        System.out.println("Rehashed table to size " + newSize);
    }
}

public class Homework7 {
    // DRIVER CLASS
    public static void main(String[] args) {
        MyHashTable2 table = new MyHashTable2(5);

        System.out.println("Inserting elements:");
        for (long i = 1; i <= 10; i++) {
            table.insert(i);
            table.display();
            System.out.println("------");
        }
    }
}