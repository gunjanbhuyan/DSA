package com.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class StringsOfMatchedParens {

	public static List<String> generateStringsOfMatchedParens(int k) {
		List<String> result = new ArrayList<>();

		generateStringsOfMatchedParensHelper(k, k, "", result);

		return result;
	}

	private static void generateStringsOfMatchedParensHelper(int leftParensNeeded, int rightParensNeeded, String stringSofar, List<String> result) {
		
		if(leftParensNeeded == 0 && rightParensNeeded == 0) {
			result.add(stringSofar);
			return;
		}
		
		if(leftParensNeeded > 0) {
			generateStringsOfMatchedParensHelper(leftParensNeeded - 1, rightParensNeeded, stringSofar + "(", result);
		}
		
		if(rightParensNeeded > leftParensNeeded) {
			generateStringsOfMatchedParensHelper(leftParensNeeded, rightParensNeeded - 1, stringSofar + ")", result);
		}
	}

	public static void main(String[] args) {

		List<String> result = generateStringsOfMatchedParens(3);
		System.out.println(result);
	}

}
