package com.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public static List<List<Integer>> solveNQueens(int n) {
		List<List<Integer>> result = new ArrayList<>();

		solveNQueensHelper(n, 0, new ArrayList<Integer>(), result);

		return result;
	}

	private static void solveNQueensHelper(int n, int row, ArrayList<Integer> colPlacement,
			List<List<Integer>> result) {

		if (row == n) {
			// all column placements are safe so store them in result
			result.add(new ArrayList<>(colPlacement));
		} else {
			for (int i = 0; i < n; i++) {
				colPlacement.add(i);

				// check if column placement is valid
				if (isValid(colPlacement)) {
					// store column placement and proceed to next row
					solveNQueensHelper(n, row + 1, colPlacement, result);
				}
				// column placement failed in current row, delete the column placement in that
				// row
				colPlacement.remove(colPlacement.size() - 1);
			}
		}
	}

	private static boolean isValid(ArrayList<Integer> colPlacement) {

		int rowId = colPlacement.size() - 1;

		for (int i = 0; i < rowId; i++) {
			int diff = 0;
			diff = Math.abs(colPlacement.get(i) - colPlacement.get(rowId));

			// if diff == 0, then placement in same column with any queen, so not safe.
			// if diff ==Math.abs(i - rowId), then column place in diagonal not safe.
			if (diff == 0 || diff == Math.abs(i - rowId)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		List<List<Integer>> result = solveNQueens(4);

		System.out.println(result);
	}

}
