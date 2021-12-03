package com.practice.dynamicprogramming;

public class NumberOfWaysToTraverseWithObstaclesIn2dArray {

	public static int getNumberOfWaysToTraverse(boolean[][] arrayWithObstacles) {
		int m = arrayWithObstacles.length;
		int n = arrayWithObstacles[0].length;
		return getNumberOfWaysToTraverseHelper(m - 1, n - 1, arrayWithObstacles, new int[m][n]);
	}

	private static int getNumberOfWaysToTraverseHelper(int i, int j, boolean[][] arrayWithObstacles, int[][] cache) {

		if(arrayWithObstacles[i][j] == true) {
			return 0;
		}
		
		if (i == 0 && j == 0) {
			return 1;
		}
		
		if (i == 0 && j > 0) {
			return getNumberOfWaysToTraverseHelper(i, j - 1, arrayWithObstacles, cache);
		}

		if (j == 0 && i > 0) {
			return getNumberOfWaysToTraverseHelper(i - 1, j, arrayWithObstacles, cache);
		}

		if (cache[i][j] == 0) {
			int waysFromOneTop = getNumberOfWaysToTraverseHelper(i - 1, j, arrayWithObstacles, cache);
			int waysFromOneLeft = getNumberOfWaysToTraverseHelper(i, j - 1, arrayWithObstacles, cache);
			cache[i][j] = waysFromOneTop + waysFromOneLeft;
		}

		return cache[i][j];
	}

	public static void main(String[] args) {
		boolean[][] arrayWithObstacles = new boolean[3][];
		arrayWithObstacles[0] = new boolean[] { false, true, false };
		arrayWithObstacles[1] = new boolean[] { false, false, false };
		arrayWithObstacles[2] = new boolean[] { false, false, false };
		int res = getNumberOfWaysToTraverse(arrayWithObstacles);
		System.out.println(res);
	}

}
