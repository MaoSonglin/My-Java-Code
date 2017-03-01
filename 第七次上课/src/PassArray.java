// PassArray.java
// Passing arrays and individual array elements to methods

public class PassArray {
	
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5 };
		String output = "The values of the original array are:\n";

		for (int i = 0; i < a.length; i++)
			output += "   " + a[i];

		output += "\n\nEffects of passing array " + "element call-by-value:\n"
				+ "a[3] before modifyElement: " + a[3];

		modifyElement(a[3]);

		output += "\na[3] after modifyElement: " + a[3];

		output += "\n Effects of passing entire array by reference";

		modifyArray(a); // array a passed call-by-reference

		output += "\n\nThe values of the modified array are:\n";

		for (int i = 0; i < a.length; i++)
			output += "   " + a[i];
		
		System.out.println(output);
	}

	public static void modifyArray(int b[]) {
		for (int j = 0; j < b.length; j++)
			b[j] *= 2;
	}

	public static void modifyElement(int e) {
		e *= 2;
	}

}
