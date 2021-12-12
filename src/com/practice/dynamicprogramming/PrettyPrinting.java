package com.practice.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrettyPrinting {

	public static int getMinimunMessiness(List<String> words, int lineLength) {

		int[] messinessCache = new int[words.size()];
		Arrays.fill(messinessCache, Integer.MAX_VALUE);

		int numOfRemainingBlanks = lineLength - words.get(0).length();
		messinessCache[0] = numOfRemainingBlanks * numOfRemainingBlanks;

		for (int i = 1; i < words.size(); i++) {
			numOfRemainingBlanks = lineLength - words.get(i).length();
			messinessCache[i] = messinessCache[i - 1] + numOfRemainingBlanks * numOfRemainingBlanks;

			for (int j = i - 1; j >= 0; j--) {
				numOfRemainingBlanks -= (words.get(j).length() + 1);
				if (numOfRemainingBlanks < 0) {
					break;
				}
				int firstJMessiness = j - 1 >= 0 ? messinessCache[j - 1] : 0;
				int currentMessiness = numOfRemainingBlanks * numOfRemainingBlanks;
				messinessCache[i] = Math.min(messinessCache[i], firstJMessiness + currentMessiness);
			}
		}

		System.out.println(Arrays.toString(messinessCache));
		return messinessCache[words.size() - 1];
	}

	public static void main(String[] args) {

		List<String> words = new ArrayList<>();
		words.add("aaa");
		words.add("bbb");
		words.add("c");
		words.add("d");
		words.add("ee");
		words.add("ff");
		words.add("ggggggg");

		int res = getMinimunMessiness(words, 11);
		System.out.println(res);
	}

}
