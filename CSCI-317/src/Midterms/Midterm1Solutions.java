package Midterms;

public class Midterm1Solutions {
	
	public static String reverse(String input) {
		if(input.length()==1)
			return input;
		else 
			return input.charAt(input.length()-1) + 
					reverse(input.substring(0, input.length()-1));
		
	}
	
	public static int findPivot(int[] arr) {
		int sum = 0;
		for(int i=0; i<arr.length; i++)
			sum += arr[i];
		int pivotIndex = 0;
		int minDifference = Integer.MAX_VALUE;
		int leftSum = 0;
		int rightSum = sum;
		for(int i = 1; i<arr.length; i++) {
			leftSum += arr[i-1];
			rightSum -= arr[i];
			if(Math.abs(leftSum - rightSum)<minDifference) {
				minDifference = Math.abs(leftSum - rightSum);
				pivotIndex = i;
			}
		}
		return pivotIndex;
	}

	public static void main(String[] args) {
		System.out.println(reverse("Hello World."));
		
		int[] array = {1, 2, 4, 6, 7, 8, 10, 12} ;
		System.out.println(findPivot(array));
	}

}