package com.practice.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSet {

	public static Set<List<Integer>> getPowerSetWithoutRecursion(List<Integer> list) {

		Set<List<Integer>> powerSet = new HashSet<>();

		for (int i = 0; i < (1 << list.size()); i++) {
			int bitArray = i;
			List<Integer> subset = new ArrayList<>();

			while (bitArray != 0) {
				subset.add(list.get((int) (Math.log(bitArray & ~(bitArray - 1)) / Math.log(2))));
				bitArray &= bitArray - 1;
			}
			powerSet.add(subset);
		}

		return powerSet;
	}

	public static Set<List<Integer>> getPowerSet(List<Integer> list) {
		Set<List<Integer>> powerSet = new HashSet<>();

		getPowerSetHelper(0, list, new ArrayList<Integer>(), powerSet);
		
		return powerSet;
	}

	private static void getPowerSetHelper(int i, List<Integer> list, List<Integer> listSoFar,
			Set<List<Integer>> powerSet) {
		
		if(i == list.size()) {
			powerSet.add(new ArrayList<>(listSoFar));
			return;
		}
		

		listSoFar.add(list.get(i));
		getPowerSetHelper(i + 1, list, listSoFar, powerSet);
		listSoFar.remove(listSoFar.size() - 1);
		getPowerSetHelper(i + 1, list, listSoFar, powerSet);
	}

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(1);
		list.add(2);

		Set<List<Integer>> powerSet = getPowerSetWithoutRecursion(list);
		System.out.println(powerSet);
		
		powerSet = getPowerSet(list);
		System.out.println(powerSet);
	}

}
