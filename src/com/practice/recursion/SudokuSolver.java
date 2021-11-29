package com.practice.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuSolver {

	public static boolean solveSudoku(List<List<Integer>> partialAssignments) {

		return solveSudokuHelper(0, 0, partialAssignments);
	}

	private static boolean solveSudokuHelper(int i, int j, List<List<Integer>> partialAssignments) {

		if (i == partialAssignments.size()) {
			i = 0;
			j++;
			if (j == partialAssignments.size()) {
				return true;
			}
		}

		if (partialAssignments.get(i).get(j) != 0) {
			return solveSudokuHelper(i + 1, j, partialAssignments);
		}

		for (int val = 1; val <= partialAssignments.size(); val++) {
			if (checkValidPlacement(i, j, val, partialAssignments)) {
				partialAssignments.get(i).set(j, val);
				if (solveSudokuHelper(i + 1, j, partialAssignments)) {
					return true;
				}
			}
		}

		partialAssignments.get(i).set(j, 0);
		return false;
	}

	private static boolean checkValidPlacement(int i, int j, int val, List<List<Integer>> partialAssignments) {

		for (int x = 0; x < partialAssignments.size(); x++) {
			if (partialAssignments.get(i).get(x) == val) {
				return false;
			}
		}

		for (int y = 0; y < partialAssignments.size(); y++) {
			if (partialAssignments.get(y).get(j) == val) {
				return false;
			}
		}

		int regionSize = (int) Math.sqrt(partialAssignments.size());
		int a = i / regionSize;
		int b = j / regionSize;
		for (int x = 0; x < regionSize; x++) {
			for (int y = 0; y < regionSize; y++) {
				if (partialAssignments.get(regionSize * a + x).get(regionSize * b + y) == val) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {

		List<List<Integer>> partialAssignments = new ArrayList<>();
		partialAssignments.add(Arrays.asList(new Integer[] { 5, 3, 0, 0, 7, 0, 0, 0, 0 }));
		partialAssignments.add(Arrays.asList(new Integer[] { 6, 0, 0, 1, 9, 5, 0, 0, 0 }));
		partialAssignments.add(Arrays.asList(new Integer[] { 0, 9, 8, 0, 0, 0, 0, 6, 0 }));
		partialAssignments.add(Arrays.asList(new Integer[] { 8, 0, 0, 0, 6, 0, 0, 0, 3 }));
		partialAssignments.add(Arrays.asList(new Integer[] { 4, 0, 0, 8, 0, 3, 0, 0, 1 }));
		partialAssignments.add(Arrays.asList(new Integer[] { 7, 0, 0, 0, 2, 0, 0, 0, 6 }));
		partialAssignments.add(Arrays.asList(new Integer[] { 0, 6, 0, 0, 0, 0, 2, 8, 0 }));
		partialAssignments.add(Arrays.asList(new Integer[] { 0, 0, 0, 4, 1, 9, 0, 0, 5 }));
		partialAssignments.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 8, 0, 0, 7, 9 }));

		boolean check = solveSudoku(partialAssignments);

		System.out.println(check);
		
		for (List<Integer> list : partialAssignments) {
			System.out.println(list);
		}
	}
}
