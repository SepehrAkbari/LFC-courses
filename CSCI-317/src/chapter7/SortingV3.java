package chapter7;

public class SortingV3 {
	
	public static void bubbleSort(int[] array) {
		for(int i=0; i<array.length-1; i++)
			for(int j=0; j<array.length-1-i; j++)
				if(array[j]>array[j+1])
					swap(array,j,j+1);
	}
	
	public static void selectionSort(int[] array) {
		int current = 0;
		for(int j = 0; j<array.length-1; j++){
			int smallestIndex = current+1;
			for(int i=current+2; i<array.length; i++) {
				if(array[i]<array[smallestIndex])
					smallestIndex = i;
			}
			if(array[smallestIndex]<array[current])
				swap(array, current, smallestIndex);
			current++;
		}
		
	}
	
	public static void insertionSort(int[] array) {
		int lastSorted = 0;
		for(int j = 0; j<array.length-1;j++) {
			int firstUnsorted = lastSorted + 1;
			int marked = array[firstUnsorted];
			int i;
			for (i = lastSorted; i>=0; i-- ) {
				if(array[i]>marked)
					array[i+1] = array[i];
				else
					break;
			}
			array[i+1] = marked;
			lastSorted++;
		}
	}
	
	private static int[] merge(int[] a, int[] b) {
		int[] c = new int[a.length+b.length];
		int aptr = 0, bptr = 0, cptr = 0;
		while(aptr<a.length && bptr<b.length) {
			if(a[aptr] <= b[bptr]) 
				c[cptr++] = a[aptr++];
			else
				c[cptr++] = b[bptr++];
		}
		while(aptr < a.length)
			c[cptr++] = a[aptr++];
		while(bptr < b.length)
			c[cptr++] = b[bptr++];
		
		return c;
	}
	
	public static void mergeSort(int[] array) {
		if(array.length<=1)
			return;
		else {
			//split into two halves
			int mid = array.length / 2;
			int[] left = new int[mid];
			int[] right = new int[array.length-mid];
			for(int i=0; i<mid; i++)
				left[i] = array[i];
			for(int i=mid; i<array.length; i++)
				right[i-mid] = array[i];
			
			//mergesort each half
			mergeSort(left);
			mergeSort(right);
			
			//merge the two halves
			int[] merged = merge(left, right);
			
			for(int i=0; i<merged.length; i++)
				array[i] = merged[i];
		}
	}
	
	public static void shellSort(int[] array) {
		int[] intervals = getSequence(array.length);
		for(int i = 0; i<intervals.length; i++) {
			int interval = intervals[i];
			//System.out.println(interval);
			if(interval>=array.length) {
				continue;

			}
			for(int shift = 0; shift<interval; shift++) {
			
				// code for insertion sort
				int lastSorted = shift;
				for(int j = 0; j<array.length-1;j+=interval) {
					int firstUnsorted = lastSorted + interval;
					if(firstUnsorted>=array.length)
						break;
					int marked = array[firstUnsorted];
					//System.out.println(firstUnsorted);
					int k;
					for (k = lastSorted; k>=shift; k-=interval ) {
						if(array[k]>marked)
							array[k+interval] = array[k];
						else
							break;
					}
					array[k+interval] = marked;
					lastSorted+=interval;
				}
			}
		}
		
	}
	
	private static int[] getSequence(int len) {
		int size = (int)Math.round(Math.log10(len)/Math.log10(3));
		int[] sequence = new int[size];
		int val = 1;
		for(int i=size-1; i>=0; i--) {
			sequence[i] = val;
			val = 3*val + 1;
		}
		return sequence;
		
	}
	
	public static void quickSort(int[] array) {
//		for(int i=0;i<array.length;i++) {
//			int r = (int)(Math.random()* array.length);
//			swap(array,i,r);
//		}
		quickSort(array, 0, array.length-1);
	}
	
	private static void quickSort(int[] array, int low, int high) {
		if(low>=high)
			return;
		else {
			// Try to find median of first, middle and last element
				
			int pivotIndex = low;
			pivotIndex = partition(array, pivotIndex, low, high);
			//System.out.println(pivotIndex);
			quickSort(array, low, pivotIndex-1);
			quickSort(array,pivotIndex+1, high);
			
		}	
	}
	
	private static int partition(int[] array, int pivotIndex, 
								int low, int high) {
		
		int left = low;
		int right = high;
		int pivotCurrent = pivotIndex;
		int pivot = array[pivotIndex];
		while(left <= right) {

			if(array[left]>pivot && array[right]<=pivot) {
				swap(array, left, right);
				if(left == pivotCurrent)
					pivotCurrent = right;
				else if(right == pivotCurrent)
					pivotCurrent = left;
				left++;
				right--;
			}
			else if(array[left]>pivot)
				right--;
			else
				left++;
		}
		swap(array, pivotCurrent, right);
		return right;
		
	}
	
	public static void radixSort(int[] array) {
		MyLinkedQueue[] buckets = new MyLinkedQueue[10];
		
		// Initialize the empty buckets
		for(int i=0; i<buckets.length; i++)
			buckets[i] = new MyLinkedQueue();
		int powerOfTen = 1;
		int largestSize = 1;
		int max = array[0];
		while(powerOfTen <= largestSize) {
			for(int i=0; i<array.length; i++) {
				int temp = array[i] % (int)Math.pow(10, powerOfTen);
				int digit = temp / (int)Math.pow(10, powerOfTen-1);
				buckets[digit].insert(array[i]);
				//code to find out the max number of digits
				//runs only the first time
				if(powerOfTen==1) {
					if(array[i]>max)
						max = array[i];
					String max_str = Integer.toString(max);
					largestSize = max_str.length();
				}
			}
			int count = 0;
			for(int i=0; i<buckets.length; i++) {
				while(buckets[i].getCount()>0)
					array[count++] = buckets[i].remove();
			}
			powerOfTen++;
//			for (int num:array)
//				System.out.print(num + " ");
//			System.out.println();
		}
		
	}
	
	private static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public static boolean isSorted(int[] array) {
		for(int i=0; i<array.length-1; i++)
			if(array[i]>array[i+1])
				return false;
		return true;
	}

}