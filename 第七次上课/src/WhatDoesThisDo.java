
public class WhatDoesThisDo {
	static int result;
	static String output;

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		result = whatIsThis(a, a.length);
		output = "Result is: " + result;
		System.out.println(output);
	}

	public static int whatIsThis(int b[], int size) {
		if (size == 1)
			return b[0];
		else
			return b[size - 1] + whatIsThis(b, size - 1);
	}
}
