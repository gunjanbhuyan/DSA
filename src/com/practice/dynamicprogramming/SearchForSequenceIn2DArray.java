package com.practice.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class SearchForSequenceIn2DArray {

	static class Pattern {

		int x, y, offset;

		public Pattern(int x, int y, int offset) {
			super();
			this.x = x;
			this.y = y;
			this.offset = offset;
		}

		@Override
		public int hashCode() {
			return Objects.hash(offset, x, y);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pattern other = (Pattern) obj;
			return offset == other.offset && x == other.x && y == other.y;
		}
	}

	public static boolean isPatternContainedInGrid(List<List<Integer>> grid, List<Integer> pattern) {

		Set<Pattern> prevPattern = new HashSet<>();

		for (int i = 0; i < grid.size(); i++) {
			for (int j = 0; j < grid.get(i).size(); j++) {
				if (isPatternContainedInGridHelper(grid, i, j, pattern, 0, prevPattern)) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean isPatternContainedInGridHelper(List<List<Integer>> grid, int i, int j, List<Integer> pattern,
			int offset, Set<Pattern> prevPattern) {

		if (pattern.size() == offset) {
			return true;
		}

		if (i < 0 || i >= grid.size() || j < 0 || j >= grid.get(i).size()
				|| prevPattern.contains(new Pattern(i, j, offset))) {
			return false;
		}

		if (grid.get(i).get(j) == pattern.get(offset)) {
			return isPatternContainedInGridHelper(grid, i - 1, j, pattern, offset + 1, prevPattern)
					|| isPatternContainedInGridHelper(grid, i + 1, j, pattern, offset + 1, prevPattern)
					|| isPatternContainedInGridHelper(grid, i, j - 1, pattern, offset + 1, prevPattern)
					|| isPatternContainedInGridHelper(grid, i, j + 1, pattern, offset + 1, prevPattern);
		}

		prevPattern.add(new Pattern(i, j, offset));

		return false;
	}

	public static void main(String[] args) {

		List<List<Integer>> grid = new ArrayList<>();
		grid.add(Arrays.asList(new Integer[] { 1, 2, 3 }));
		grid.add(Arrays.asList(new Integer[] { 3, 4, 5 }));
		grid.add(Arrays.asList(new Integer[] { 5, 6, 7 }));

		List<Integer> pattern = Arrays.asList(new Integer[] { 2, 4, 6, 7 });

		boolean res = isPatternContainedInGrid(grid, pattern);
		System.out.println(res);
	}

}
