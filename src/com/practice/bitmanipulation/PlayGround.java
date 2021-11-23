package com.practice.bitmanipulation;

public class PlayGround {

	public static void main(String[] args) {

		int x = 116;
		int y = ~(x-1);
		int z = x & ~(x-1);
		int p = z & ~(z-1);
		int q = p & ~(p-1);
//		System.out.println(Integer.toBinaryString(x));
//		System.out.println(Integer.toBinaryString(x-1));
//		System.out.println(Integer.toBinaryString(y));
//		System.out.println(z);
//		System.out.println(Integer.toBinaryString(p));
//		System.out.println(Integer.toBinaryString(q));
//		
//		int res = (int) (Math.log(4)/Math.log(2));
//		System.out.println(res);
		
//		for(int i = 0; i < (1 << x); i++) {
//			System.out.println(i);
//		}
		
//		System.out.println((int)(Math.log(4)/Math.log(2)));
		
		int abc = 123;
		while(abc!=0) {
			System.out.println(abc);
			abc &= abc-1;
		}
	}

}

