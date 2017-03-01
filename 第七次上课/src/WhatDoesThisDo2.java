
public class WhatDoesThisDo2 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		StringBuilder sbBuilder=new StringBuilder();
		someFunction(a, 0, sbBuilder);
		System.out.println(sbBuilder);
	}
	public static void someFunction(int b[], int x, StringBuilder out) {
		if (x < b.length) {
			someFunction(b, x + 1, out);
			out.append(b[x] + "  ");
		}
	}
}
