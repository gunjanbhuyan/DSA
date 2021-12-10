package com.practice.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinWeightPathInTriangle {

	public static int getMinWeightedPathInTriangle(List<List<Integer>> triangle) {

		if (triangle.isEmpty()) {
			return 0;
		}

		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				triangle.get(i).set(j,
						triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
			}
		}

		return triangle.get(0).get(0);
	}

	public static void main(String[] args) {

		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add(Arrays.asList(new Integer[] {2}));
		triangle.add(Arrays.asList(new Integer[] {4, 4}));
		triangle.add(Arrays.asList(new Integer[] {8, 5, 6}));
		triangle.add(Arrays.asList(new Integer[] {4, 2, 6, 2}));
		triangle.add(Arrays.asList(new Integer[] {1, 5, 2, 3, 4}));
		
		int res = getMinWeightedPathInTriangle(triangle);
		System.out.println(res);
	}

}
