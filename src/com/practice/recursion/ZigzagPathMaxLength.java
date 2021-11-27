package com.practice.recursion;

import com.practice.recursion.AllBinaryTrees.BinaryTreeNode;

public class ZigzagPathMaxLength {
	
	static enum TraversedPath{
		LEFT,
		RIGHT
	}
	
	private static int zigzagPathMaxLength = 1;
	
	public static int getZigzagPathMaxLength(BinaryTreeNode node) {
		
		if(node == null) {
			return 0;
		}
		
		getZigzagPathMaxLengthHelper(node.left, TraversedPath.LEFT, zigzagPathMaxLength);
		getZigzagPathMaxLengthHelper(node.right, TraversedPath.RIGHT, zigzagPathMaxLength);
		
		return zigzagPathMaxLength;
	}

	private static void getZigzagPathMaxLengthHelper(BinaryTreeNode node, TraversedPath traversedPath,
			int zigzagPathLengthCount) {

		if(node == null) {
			return;
		}
		
		if(node.left == null && node.right == null) {
			zigzagPathMaxLength = Math.max(zigzagPathMaxLength, zigzagPathLengthCount);
			return;
		}
		
		if(node.left != null && traversedPath == TraversedPath.RIGHT) {
			zigzagPathLengthCount++;
			getZigzagPathMaxLengthHelper(node.left, TraversedPath.LEFT, zigzagPathLengthCount);
			return;
		}
		
		if(node.right != null && traversedPath == TraversedPath.LEFT) {
			zigzagPathLengthCount++;
			getZigzagPathMaxLengthHelper(node.right, TraversedPath.RIGHT, zigzagPathLengthCount);
			return;
		}
		
		getZigzagPathMaxLengthHelper(node.left, TraversedPath.LEFT, 1);
		getZigzagPathMaxLengthHelper(node.right, TraversedPath.RIGHT, 1);
	}

	public static void main(String[] args) {

		BinaryTreeNode node = new BinaryTreeNode(1, new BinaryTreeNode(2, new BinaryTreeNode(3, new BinaryTreeNode(4, null, null), new BinaryTreeNode(5, new BinaryTreeNode(6, null, new BinaryTreeNode(7, null, null)), new BinaryTreeNode(8, null, null))), null), new BinaryTreeNode(9, null, new BinaryTreeNode(10, new BinaryTreeNode(11, null, new BinaryTreeNode(12, new BinaryTreeNode(13, null, new BinaryTreeNode(14, null, null)), null)), new BinaryTreeNode(15, null, new BinaryTreeNode(16, null, new BinaryTreeNode(17, null, null))))));
//		System.out.println(node);
		int zigzagPathMaxLength = getZigzagPathMaxLength(node);
		System.out.println(zigzagPathMaxLength);
	}

}
