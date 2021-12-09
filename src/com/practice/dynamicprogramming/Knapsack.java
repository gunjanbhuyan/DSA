package com.practice.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Knapsack {

	static class Item {
		int value, weight;

		public Item(int value, int weight) {
			super();
			this.value = value;
			this.weight = weight;
		}
	}

	public static int getOptimumObjectToCapacityA(List<Item> items, int capacity) {

		if (items == null)
			return 0;

		int[][] cache = new int[items.size()][capacity + 1];

		for (int[] row : cache) {
			Arrays.fill(row, -1);
		}

		int res = getOptimumObjectToCapacityHleper(items, items.size() - 1, capacity, cache);

//		for (int[] row : cache) {
//			for (int a : row) {
//				System.out.print(a + "\t");
//			}
//			System.out.println();
//		}

		return res;
	}

	private static int getOptimumObjectToCapacityHleper(List<Item> items, int k, int currentCapacity, int[][] cache) {

		if (k < 0) {
			return 0;
		}

		if (cache[k][currentCapacity] == -1) {
			int withoutCurrentItem = getOptimumObjectToCapacityHleper(items, k - 1, currentCapacity, cache);

			int withCurrentItem = currentCapacity < items.get(k).weight ? 0
					: items.get(k).value + getOptimumObjectToCapacityHleper(items, k - 1,
							currentCapacity - items.get(k).weight, cache);

			cache[k][currentCapacity] = Math.max(withoutCurrentItem, withCurrentItem);
		}

		return cache[k][currentCapacity];
	}

	public static int getOptimumObjectToCapacityB(List<Item> items, int capacity) {
		int[] cache = new int[capacity + 1];

		for (int i = 1; i <= items.size(); i++) {
			for (int w = capacity; w >= 0; w--) {
				if (w >= items.get(i - 1).weight) {
					cache[w] = Math.max(cache[w], cache[w - items.get(i - 1).weight] + items.get(i - 1).value);
				}
			}
			for (int a : cache) {
				System.out.print(a + "\t");
			}
			System.out.println();
		}

		return cache[capacity];
	}

	public static void main(String[] args) {

		List<Item> items = new ArrayList<>();
		items.add(new Item(60, 5));
		items.add(new Item(50, 3));
		items.add(new Item(70, 4));
		items.add(new Item(30, 2));

		int res = getOptimumObjectToCapacityA(items, 5);
		System.out.println(res);
		
		res = getOptimumObjectToCapacityB(items, 5);
		System.out.println(res);
	}

}
