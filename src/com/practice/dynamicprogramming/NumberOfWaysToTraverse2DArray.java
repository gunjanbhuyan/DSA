package com.practice.dynamicprogramming;

public class NumberOfWaysToTraverse2DArray {

	public static int getNumberOfWaysToTraverse2DArray(int m, int n) {
		return getNumberOfWaysToTraverse2DArrayHelper(m - 1, n - 1, new int[m][n]);
	}

	private static int getNumberOfWaysToTraverse2DArrayHelper(int i, int j, int[][] cache) {

		if((i == 0 && j > 0) || (j == 0 && i > 0)) {
			return 1;
		}
		
		if(i == 0 && j == 0) {
			return 0;
		}
		
		if(cache[i][j] == 0) {
			int waysFromOneTop = getNumberOfWaysToTraverse2DArrayHelper(i - 1, j, cache);
			int waysFromOneLeft = getNumberOfWaysToTraverse2DArrayHelper(i, j - 1, cache);
			cache[i][j] = waysFromOneTop + waysFromOneLeft;
		}
		
		return cache[i][j];
	}

	public static void main(String[] args) {
		int res = getNumberOfWaysToTraverse2DArray(5, 5);
		System.out.println(res);
	}

}
