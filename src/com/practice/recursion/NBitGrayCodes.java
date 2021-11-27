package com.practice.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NBitGrayCodes {

	public static List<Integer> getGrayCodes(int numOfBits) {

		if (numOfBits == 0) {
			return new ArrayList<Integer>(Arrays.asList(0));
		}

		List<Integer> grayCodeListOfOneLessBits = getGrayCodes(numOfBits - 1);

		// last bit to add with each element of grayCodeListOfOneLessBits in reverse way
		int lastBitToAdd = 1 << (numOfBits - 1);
		
		for(int i = grayCodeListOfOneLessBits.size() - 1; i >= 0; i--) {
			grayCodeListOfOneLessBits.add(lastBitToAdd | i);
		}

		return grayCodeListOfOneLessBits;
	}

	public static void main(String[] args) {

		List<Integer> res = getGrayCodes(3);
		System.out.println(res);
 	}
}
