package com.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsOfSizeK {

	public static List<List<Integer>> generateAllSubsetsOfSizeK(int n, int k) {

		List<List<Integer>> result = new ArrayList<>();

		generateAllSubsetsOfSizeKHelper(0, n, k, new ArrayList<Integer>(), result);

		return result;
	}

	private static void generateAllSubsetsOfSizeKHelper(int i, int n, int k, ArrayList<Integer> listSoFar,
			List<List<Integer>> result) {

		if (listSoFar.size() == k) {
			result.add(new ArrayList<>(listSoFar));
			return;
		}

		if (i == n) {
			return;
		}

		listSoFar.add(i + 1);
		generateAllSubsetsOfSizeKHelper(i + 1, n, k, listSoFar, result);
		listSoFar.remove(listSoFar.size() - 1);
		generateAllSubsetsOfSizeKHelper(i + 1, n, k, listSoFar, result);

	}

	public static void main(String[] args) {

		List<List<Integer>> result = generateAllSubsetsOfSizeK(4, 3);
		System.out.println(result);
	}

}
