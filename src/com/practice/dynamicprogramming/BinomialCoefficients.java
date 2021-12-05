package com.practice.dynamicprogramming;

public class BinomialCoefficients {

	public static int getBinomialCoefficientsA(int n, int k) {

//		int[][] cache = new int[n + 1][k + 1];
		int[] cache = new int[k + 1];
		
		cache[0] = 1;
		
		for(int i = 1; i <= n; i++) {
			for(int j = Math.min(i, k); j > 0; j--) {
				cache[j] = cache[j] + cache[j - 1];
//				System.out.print(cache[j] +"\t");
			}
			for(int a : cache) {
				System.out.print(a + "\t");
			}
			System.out.println();
		}

		return cache[k];
	}
	
	public static int getBinomialCoefficientsB(int n, int k) {
		return getBinomialCoefficientsHelper(n, k, new int[n + 1][k + 1]);
	}

	private static int getBinomialCoefficientsHelper(int n, int k, int[][] cache) {

		if (k == 0 || n == k) {
			// below assignment to cache is not necessary but looks good and meaningful on
			// cache and doesn't affect space or time complexity.
			cache[n][k] = 1;
			return 1;
		}

		if (cache[n][k] == 0) {
			int withoutK = getBinomialCoefficientsHelper(n - 1, k, cache);
			int withK = getBinomialCoefficientsHelper(n - 1, k - 1, cache);

			cache[n][k] = withK + withoutK;
		}

		return cache[n][k];
	}

	public static void main(String[] args) {

		int res = getBinomialCoefficientsA(8, 4);
		System.out.println(res);
		
		res = getBinomialCoefficientsB(8, 4);
		System.out.println(res);
	}

}
