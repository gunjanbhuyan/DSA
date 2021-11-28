package com.practice.dynamicprogramming;

public class FibonacciOfN {
	
	public static int getFibonacciNumber(int n) {
		
		if(n <= 1) {
			return n;
		}
		
		// bottom-up cache storage
		int cacheOfNMinus2 = 0;
		int cacheOfNMinus1 = 1;
		
		int finalNum = 0;
		
		for(int i = 2; i <= n; i++) {
			finalNum = cacheOfNMinus2 + cacheOfNMinus1;
			cacheOfNMinus2 = cacheOfNMinus1;
			cacheOfNMinus1 = finalNum;
		}
		
		return finalNum;
	}

	public static void main(String[] args) {

		int fiboNum = getFibonacciNumber(6);
		System.out.println(fiboNum);
	}

}
