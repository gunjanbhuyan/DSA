package com.practice.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TowerOfHanoi {

	public static final int NUM_OF_PEGS = 3;

	static class Metadata {
		int numOfRingsRemaining;
		int fromRing;
		int toRing;
		int useRing;

		public Metadata(int numOfRingsRemaining, int fromRing, int toRing, int useRing) {
			super();
			this.numOfRingsRemaining = numOfRingsRemaining;
			this.fromRing = fromRing;
			this.toRing = toRing;
			this.useRing = useRing;
		}

		@Override
		public String toString() {
			return "Metadata [numOfRingsRemaining=" + numOfRingsRemaining + ", fromRing=" + fromRing + ", toRing="
					+ toRing + ", useRing=" + useRing + "]";
		}

	}

	public static void solveTowerOfHanoi(int numOfRings) {

		// Setup the pegs
		List<Stack<Integer>> pegs = new ArrayList<>();
		for (int i = 0; i < NUM_OF_PEGS; i++) {
			pegs.add(new Stack<Integer>());
		}

		// Fill the first peg
		for (int i = numOfRings; i >= 1; i--) {
			pegs.get(0).add(i);
		}

		System.out.println(pegs.get(0));
		System.out.println(pegs.get(1));
		System.out.println(pegs.get(2));

		solveTowerOfHanoiHelper(numOfRings, pegs, 0, 1, 2);

//		pegs.add(0, (pegs.remove(1)));
//		not working yet
//		solveTowerOfHanoiWithoutUsingRecursion(numOfRings, pegs, 0, 1, 2);

	}

	private static void solveTowerOfHanoiWithoutUsingRecursion(int numOfRingsRemaining, List<Stack<Integer>> pegs,
			int fromRing, int toRing, int useRing) {

		int totalSteps = 2 ^ numOfRingsRemaining - 1;

		for (int i = 1; i <= totalSteps; i++) {
			if (i % 3 == 0) {
				pegs.get(toRing).push(pegs.get(fromRing).pop());
			}
			if (i % 3 == 1) {
				pegs.get(toRing).push(pegs.get(fromRing).pop());
			}
			if (i % 3 == 2) {
				pegs.get(toRing).push(pegs.get(fromRing).pop());
			}
		}
	}

	private static void solveTowerOfHanoiHelper(int numOfRingsRemaining, List<Stack<Integer>> pegs, int fromRing,
			int toRing, int useRing) {

		if (numOfRingsRemaining > 0) {
			solveTowerOfHanoiHelper(numOfRingsRemaining - 1, pegs, fromRing, useRing, toRing);
			pegs.get(toRing).push(pegs.get(fromRing).pop());
			System.out.println("remaining : " + numOfRingsRemaining + ", from : " + fromRing + ", to : " + toRing
					+ ", use : " + useRing);
			System.out.println(pegs.get(0));
			System.out.println(pegs.get(1));
			System.out.println(pegs.get(2));
			solveTowerOfHanoiHelper(numOfRingsRemaining - 1, pegs, useRing, toRing, fromRing);
		}
	}

	public static void main(String[] args) {

		solveTowerOfHanoi(4);
	}

}
