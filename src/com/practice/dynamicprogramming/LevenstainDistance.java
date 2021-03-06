package com.practice.dynamicprogramming;

import java.util.Arrays;

public class LevenstainDistance {

	public static int getLevenstainDistance(String str1, String str2) {

		int[][] levenstainTable = new int[str1.length()][str2.length()];

		for (int[] row : levenstainTable) {
			Arrays.fill(row, -1);
		}

		return getLevenstainDistanceHelper(str1, str1.length() - 1, str2, str2.length() - 1, levenstainTable);
	}

	private static int getLevenstainDistanceHelper(String str1, int str1Len, String str2, int str2Len,
			int[][] levenstainTable) {

		if (str1Len < 0) {
			return str2Len + 1;
		}

		if (str2Len < 0) {
			return str1Len + 1;
		}

		if (levenstainTable[str1Len][str2Len] == -1) {
			if (str1.charAt(str1Len) == str2.charAt(str2Len)) {
				// delete one char from both strings from ending then compare
				return getLevenstainDistanceHelper(str1, str1Len - 1, str2, str2Len - 1, levenstainTable);
			} else {
				// after substituting both strings are same, so delete one char from both
				// strings from ending then compare
				int substitute = getLevenstainDistanceHelper(str1, str1Len - 1, str2, str2Len - 1, levenstainTable);
				// insert one char at end of str1 to match with str2, now last cars of both
				// strings are same. Pointer of str1 is at one after ending char so to compare
				// with same position of send string we do minus one then compare
				int insert = getLevenstainDistanceHelper(str1, str1Len, str2, str2Len - 1, levenstainTable);
				// delete one char from str1 to match with str2 then compare
				int delete = getLevenstainDistanceHelper(str1, str1Len - 1, str2, str2Len, levenstainTable);

				levenstainTable[str1Len][str2Len] = 1 + Math.min(substitute, Math.min(insert, delete));
			}
		}

		return levenstainTable[str1Len][str2Len];
	}

	public static void main(String[] args) {

		int res = getLevenstainDistance("Carthorse", "Orchestra");
		System.out.println(res);

	}

}
