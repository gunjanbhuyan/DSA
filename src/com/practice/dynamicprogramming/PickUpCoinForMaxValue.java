package com.practice.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class PickUpCoinForMaxValue {

	public static int getMaxvalue(List<Integer> coins) {
		int[][] cache = new int[coins.size()][coins.size()];
		int res = getMaxvalueHelper(coins, 0, coins.size() - 1, cache);
		for(int[] row : cache) {
			System.out.println(Arrays.toString(row));
		}
		return res;
	}

	private static int getMaxvalueHelper(List<Integer> coins, int i, int j, int[][] cache) {
		if (i > j) {
			return 0;
		}

		int maxWithI = coins.get(i)
				+ Math.min(getMaxvalueHelper(coins, i + 1, j - 1, cache), getMaxvalueHelper(coins, i + 2, j, cache));
		int maxWithJ = coins.get(j)
				+ Math.min(getMaxvalueHelper(coins, i + 1, j - 1, cache), getMaxvalueHelper(coins, i, j - 2, cache));
		cache[i][j] = Math.max(maxWithI, maxWithJ);

		return cache[i][j];
	}

	public static void main(String[] args) {

		int res = getMaxvalue(Arrays.asList(new Integer[] { 10, 25, 5, 1, 10, 5 }));
		System.out.println(res);

	}

}
