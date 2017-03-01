public class ArrayInRam {
	public static void main(String[] args) {
		// 定义并初始化数组，使用静态初始化
		int[] a = { 5, 7, 20 };
		System.out.println("a数组中的元素：");
		// 循环输出a数组的元素
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		// 定义并初始化数组b，使用动态初始化
		int[] b = new int[4];
		// 输出b数组的长度
		System.out.println("\nb数组的初始长度为：" + b.length);
		// 因为a是int[]类型，b也是int[]类型，所以可以将a的值赋给b。
		// 也就是让b引用指向a引用指向的数组
		b = a;
		System.out.println("b=a,赋值之后，b数组的元素为：");
		// 循环输出b数组的元素
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + ",");
		}

		// 再次输出b数组的长度
		System.out.println("\n赋值之后，b数组的长度为：" + b.length);
	}
}
