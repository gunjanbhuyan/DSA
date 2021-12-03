package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClimbingTheLeaderboard {

	public static List<Integer> getClimbingRanks(List<Integer> ranked, List<Integer> player) {
		
		List<Integer> res = new ArrayList<>();
		List<Integer> rankedRanks = new ArrayList<>();

		if (!ranked.isEmpty()) {
			rankedRanks.add(1);
		}

		for (int i = 1; i < ranked.size(); i++) {
			if (ranked.get(i) == ranked.get(i - 1)) {
				rankedRanks.add(rankedRanks.get(rankedRanks.size() - 1));
			} else {
				rankedRanks.add(rankedRanks.get(rankedRanks.size() - 1) + 1);
			}
		}

		// System.out.println(rankedRanks);

		int i = ranked.size() - 1;
		int j = 0;
		while (j < player.size()) {

			if (i < 0) {
				res.add(1);
				j++;
				continue;
			}
			if (player.get(j) < ranked.get(i)) {
				res.add(rankedRanks.get(i) + 1);
				j++;
				continue;
			}
			if (player.get(j) == ranked.get(i)) {
				res.add(rankedRanks.get(i));
				j++;
				continue;
			}
			if (player.get(j) > ranked.get(i)) {
				i--;
				continue;
			}
		}

		return res;
	}

	public static void main(String[] args) {

		List<Integer> ranked = Arrays.asList(new Integer[] {100, 90, 90, 80, 75, 60});
		List<Integer> player = Arrays.asList(new Integer[] {50, 65, 77, 90, 102});
		
		List<Integer> res = getClimbingRanks(ranked, player);
		System.out.println(res);
	}

}
