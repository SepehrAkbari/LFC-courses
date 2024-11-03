package chapter9;

public class TestHashTable {
	public static void main(String[] args) {

		MyHashTable mht = new MyHashTable(100);
		long r=0;
		for(int i = 0; i< 40; i++) {
			r = (long)(Math.random()*1000000000);
			mht.insert(r);

		}
		mht.display();
		System.out.println(mht.search(r));
		System.out.println(mht.search(r+1));
		mht.remove(r);
		System.out.println();
		mht.display();

	}
}