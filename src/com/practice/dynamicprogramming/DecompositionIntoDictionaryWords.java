package com.practice.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DecompositionIntoDictionaryWords {

	public static List<String> decomposeIntoDictionaryWords(Set<String> dictionary, String domain) {

		int[] lastIndex = new int[domain.length()];
		Arrays.fill(lastIndex, -1);

		for (int i = 0; i < domain.length(); i++) {
			if (dictionary.contains(domain.substring(0, i + 1))) {
				lastIndex[i] = i + 1;
			}

			if (lastIndex[i] == -1) {
				for (int j = 0; j < i; j++) {
					if (lastIndex[j] != -1 && dictionary.contains(domain.substring(j + 1, i + 1))) {
						lastIndex[i] = i - j;
						break;
					}
				}
			}
		}
//		for(int a : lastIndex) {
//			System.out.print(a + "\s");
//		}
//		System.out.println();

		List<String> decompositions = new ArrayList<>();
		int index = domain.length() - 1;
		
		if (lastIndex[index] != -1) {
			while (index >= 0) {
				decompositions.add(domain.substring(index + 1 - lastIndex[index], index + 1));
				index -= lastIndex[index];
			}
		}

		return decompositions;
	}

	public static void main(String[] args) {

		Set<String> dicstionary = new HashSet<>();
		dicstionary.add("bed");
		dicstionary.add("bath");
		dicstionary.add("hand");
		dicstionary.add("bat");
		dicstionary.add("beyond");
		
		List<String> decompositions = decomposeIntoDictionaryWords(dicstionary, "bedbathandbeyond");
		System.out.println(decompositions);
	}

}
