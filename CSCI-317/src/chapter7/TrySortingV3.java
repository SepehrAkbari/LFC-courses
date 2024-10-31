package chapter7;

public class TrySortingV3 {

	public static void main(String[] args) {
		final int SIZE = 10;
		
		long startTime, endTime;
		int[] array = new int[SIZE];
		
		
		
//		for (int num:array)
//			System.out.print(num + " ");
				
		initialize(array);
		startTime = System.currentTimeMillis();
		SortingV3.insertionSort(array);
		endTime = System.currentTimeMillis();
		
		System.out.println("Time for insertionSort: " + (endTime -
		startTime) );
		System.out.println(SortingV3.isSorted(array));
//		for (int num:array)
//			System.out.print(num + " ");
		
		initialize(array);
		startTime = System.currentTimeMillis();
		SortingV3.quickSort(array);
		endTime = System.currentTimeMillis();
		
		System.out.println("Time for quickSort: " + (endTime -
		startTime) );
		System.out.println(SortingV3.isSorted(array));
		
		
		initialize(array);
		startTime = System.currentTimeMillis();
		SortingV3.radixSort(array);
		endTime = System.currentTimeMillis();
		
		System.out.println("Time for radixSort: " + (endTime -
		startTime) );
		System.out.println(SortingV3.isSorted(array));

	}
	
	public static void initialize(int[] array) {
//		//sorted
//		for(int i = 0; i<array.length; i++)
//			array[i] = i;
		
//		//reverse sorted
//		for(int i = 0; i<array.length; i++)
//			array[i] = array.length - i;
//		
		//random
		final int RANGE = 1000;
		for(int i=0; i<array.length; i++)
			array[i] = (int)(Math.random()*RANGE);
	}

}