public class ArrayInRam {
	public static void main(String[] args) {
		// ���岢��ʼ�����飬ʹ�þ�̬��ʼ��
		int[] a = { 5, 7, 20 };
		System.out.println("a�����е�Ԫ�أ�");
		// ѭ�����a�����Ԫ��
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		// ���岢��ʼ������b��ʹ�ö�̬��ʼ��
		int[] b = new int[4];
		// ���b����ĳ���
		System.out.println("\nb����ĳ�ʼ����Ϊ��" + b.length);
		// ��Ϊa��int[]���ͣ�bҲ��int[]���ͣ����Կ��Խ�a��ֵ����b��
		// Ҳ������b����ָ��a����ָ�������
		b = a;
		System.out.println("b=a,��ֵ֮��b�����Ԫ��Ϊ��");
		// ѭ�����b�����Ԫ��
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + ",");
		}

		// �ٴ����b����ĳ���
		System.out.println("\n��ֵ֮��b����ĳ���Ϊ��" + b.length);
	}
}
