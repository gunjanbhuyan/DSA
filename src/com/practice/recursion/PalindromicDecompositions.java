package com.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromicDecompositions {
	
	public static List<List<String>> getAllPalindromicDecompositions(String str){
		List<List<String>> res = new ArrayList<>();
		
		getAllPalindromicDecompositionsHelper(str, 0, new ArrayList<String>(), res);
		
		return res;
	}

	private static void getAllPalindromicDecompositionsHelper(String str, int i, List<String> partialDecompositions,
			List<List<String>> res) {

		if(i == str.length()) {
			res.add(new ArrayList<>(partialDecompositions));
			return;
		}
		
		for(int j = i + 1; j <= str.length(); j++) {
			String prefix = str.substring(i, j);
			if(isPallindrome(prefix)) {
				partialDecompositions.add(prefix);
				getAllPalindromicDecompositionsHelper(str, j, partialDecompositions, res);
				partialDecompositions.remove(partialDecompositions.size() - 1);
			}
		}
	}

	private static boolean isPallindrome(String prefix) {

		for(int i = 0, j = prefix.length() - 1; i < j; i++, j--){
			if(prefix.charAt(i) != prefix.charAt(j)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		List<List<String>> res = getAllPalindromicDecompositions("1122");
		System.out.println(res);
	}

}
