
public class ArrayCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int myArray[] = {1,2,3,4,5,6};               //��ʼ��һ������
		int yourArray[] = {10,9,8,7,6,5,4,3,2,1,0};  //��ʼ����һ������
		
		//�������ǰ�ĵ�һ�������е�Ԫ��
		System.out.println("����ǰmyArray��");
		for(int i = 0; i < myArray.length; i++)
			System.out.print(myArray[i]+" ");
		System.out.println();
		
		//�������ǰ�ڶ��������е�Ԫ��
		System.out.println("����ǰyourArray��");
		for(int i = 0; i < yourArray.length; i++)
			System.out.print(yourArray[i]+" ");
		System.out.println();
		
		//����System��ĺ���arraycopy()������myArray���ִ�λ��0��ʼ5��Ԫ��
		//���Ƶ�yourArray�����λ��Ϊ0��ʼ��5��Ԫ���С�
		System.arraycopy(myArray, 0, yourArray, 0, 5);
		
		//������ƺ��yourArray���顣
		System.out.println("���ƺ�yourArray��");
		for(int i=0; i < yourArray.length; i++)
			System.out.print(yourArray[i]+" ");
		System.out.println();
	}

}
