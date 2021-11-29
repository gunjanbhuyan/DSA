package com.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class AllBinaryTrees {
	
	static class BinaryTreeNode {
		int data;
		BinaryTreeNode left;
		BinaryTreeNode right;
		
		public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "\n data=" + data + ", left=" + left + ", right=" + right;
		}
	}
	
	public static List<BinaryTreeNode> generateAllBinaryTrees(int nodeCount) {
		List<BinaryTreeNode> res = new ArrayList<>();
		
		if(nodeCount == 0) {
			res.add(null);
		}
		
		for(int leftNodeCount = 0; leftNodeCount < nodeCount; leftNodeCount++) {
			int rightNodeCount = nodeCount - 1 - leftNodeCount;
			List<BinaryTreeNode> leftTrees = generateAllBinaryTrees(leftNodeCount);
			List<BinaryTreeNode> rightTrees = generateAllBinaryTrees(rightNodeCount);
			
			for(BinaryTreeNode leftTree : leftTrees) {
				for(BinaryTreeNode rightTree : rightTrees) {
					res.add(new BinaryTreeNode(0, leftTree, rightTree));
				}
			}
		}
		
		return res;
	}

	public static void main(String[] args) {

		List<BinaryTreeNode> res = generateAllBinaryTrees(3);
		System.out.println(res);
	}

}
