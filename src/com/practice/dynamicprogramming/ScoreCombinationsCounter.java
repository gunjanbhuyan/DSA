package com.practice.dynamicprogramming;

public class ScoreCombinationsCounter {
	
	public static int getCombinationsForFinalScore(int finalScore, int[] points) {
		
//		approach with O(sn) space complexity, where s = finalScore and n = points.length
//		int[][] scoreTable = new int[points.length][finalScore + 1];
		
//		approach with O(s) space complexity
		int[] scoreTable = new int[finalScore + 1];
		
		for(int i = 0; i < points.length; i++) {
//			approach with O(sn) space complexity
//			scoreTable[i][0] = 1;
			
//			approach with O(s) space complexity
			scoreTable[0] = 1;
			for(int j = 1; j <= finalScore; j++) {
//				approach with O(sn) space complexity
//				int withoutThisPlay = i - 1 >= 0 ? scoreTable[i - 1][j] : 0;
//				int withThisPlay = j >= points[i] ? scoreTable[i][j - points[i]] : 0;
//				scoreTable[i][j] = withoutThisPlay + withThisPlay;

//				approach with O(s) space complexity
				scoreTable[j] = j >= points[i] ? scoreTable[j] + scoreTable[j - points[i]] : scoreTable[j];
			}
		}
		
//		approach with O(sn) space complexity
//		return scoreTable[points.length - 1][finalScore];
		
//		approach with O(s) space complexity
		return scoreTable[finalScore];
	}

	public static void main(String[] args) {

		int res = getCombinationsForFinalScore(9, new int[]{2, 3, 7});
		System.out.println(res);
	}

}
