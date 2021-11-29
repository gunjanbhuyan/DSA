package com.practice.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextPermutation {

	public static List<Integer> findNextPermutation(List<Integer> list) {

		int k = list.size() - 2;
		while (k >= 0 && list.get(k) >= list.get(k + 1)) {
			k--;
		}

		if (k == -1) {
			return Collections.emptyList();
		}

		for (int i = list.size() - 1; i > k; i--) {
			if (list.get(i) > list.get(k)) {
				Collections.swap(list, i, k);
				break;
			}
		}

		Collections.reverse(list.subList(k + 1, list.size()));

		return list;
	}

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(7);
		list.add(3);
		list = findNextPermutation(list);
		System.out.println(list);
		list = findNextPermutation(list);
		System.out.println(list);
		list = findNextPermutation(list);
		System.out.println(list);
	}

}
