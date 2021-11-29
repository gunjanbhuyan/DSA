package com.practice.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.practice.array.NextPermutation;

public class AllPermutations {

	public static List<List<Integer>> findAllPermutions(List<Integer> list) {

		List<List<Integer>> result = new ArrayList<>();

		Collections.sort(list);
		result.add(new ArrayList<>(list));

		while (!list.isEmpty()) {
			list = NextPermutation.findNextPermutation(list);
			if (!list.isEmpty()) {
				result.add(new ArrayList<>(list));
			}
		}
		return result;
	}
	
	public static List<List<Integer>> directedPermutation(int i, List<Integer> list, List<List<Integer>> result) {
		
		if(i == list.size() - 1) {
			result.add(new ArrayList<>(list));
		} else {
			for(int j = i; j < list.size(); j++) {
				Collections.swap(list, i, j);
				directedPermutation(i + 1, list, result);
				Collections.swap(list, i, j);
			}
		}
		return result;
	}

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(7);
		list.add(3);

		List<List<Integer>> result = findAllPermutions(list);
		System.out.println(result);
		
		result = new ArrayList<>();
		directedPermutation(0, list, result);
		
		System.out.println(result);
	}

}
