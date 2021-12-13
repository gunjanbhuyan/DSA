package com.practice.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class LongestNonDecreasingSubsequence {

	public static int getLongestNonDecreasingSubsequenceLength(List<Integer> sequence) {

		int maxLen = 0;
		int[] maxLenArr = new int[sequence.size()];
		Arrays.fill(maxLenArr, 1);

		for (int i = 1; i < sequence.size(); i++) {
			for (int j = 0; j < i; j++) {
				if (sequence.get(i) >= sequence.get(j)) {
					maxLenArr[i] = Math.max(maxLenArr[i], maxLenArr[j] + 1);
					maxLen = maxLenArr[i] > maxLen ? maxLenArr[i] : maxLen;
				}
			}
		}

		return maxLen;
	}

	public static void main(String[] args) {

		int res = getLongestNonDecreasingSubsequenceLength(
				Arrays.asList(new Integer[] { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9 }));
		System.out.println(res);
	}

}
