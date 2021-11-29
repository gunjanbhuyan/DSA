package com.practice.dynamicprogramming;

public class MaxSubarraySum {
	
	public static int getMaxSubarraySum(int[] arr) {
		
		int sum = 0;
		int minSum = 0;
		int maxSum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
//			System.out.println("sum : " + sum);
			
			minSum = sum < minSum ? sum : minSum;
//			System.out.println("minSum : " + minSum);
			
			maxSum = sum - minSum > maxSum ? sum - minSum : maxSum;
//			System.out.println("maxSum : " + maxSum);
			
//			System.out.println("-----");
		}
		
		return maxSum;
	}

	public static void main(String[] args) {

		int res = getMaxSubarraySum(new int[] {1, 2, 3, 4, -11, -2, -3, 5, 3, 4});
		System.out.println(res);
	}

}
