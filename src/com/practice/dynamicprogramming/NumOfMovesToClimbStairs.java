package com.practice.dynamicprogramming;

public class NumOfMovesToClimbStairs {

	public static int getNumOfMovesToClimbStairs(int n, int k) {
		return getNumOfMovesToClimbStairsHelper(n, k, new int[n + 1]);
	}

	private static int getNumOfMovesToClimbStairsHelper(int n, int k, int[] cache) {

		if (n <= 1) {
			return 1;
		}

		if (cache[n] == 0) {
			for (int i = 1; i <= k && n - i >= 0; i++) {
				cache[n] += getNumOfMovesToClimbStairsHelper(n - i, k, cache);
//				System.out.println(Arrays.toString(cache));
			}
		}

		return cache[n];
	}

	public static void main(String[] args) {
		int res = getNumOfMovesToClimbStairs(5, 2);
		System.out.println(res);
	}

}
