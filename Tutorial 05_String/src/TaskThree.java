
public class TaskThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��ʼ��һ���ַ���
		String name = new String("My name is Networkcrazy");
		//����String���length()��������ַ����ĳ��ȣ�
		System.out.println(name+"�ĳ�����"+name.length());
		//����String���charAt()�����õ��ַ���name�ĵ�һ���ַ���
		System.out.println("��һ���ַ�ʱ��"+name.charAt(0));
		//����String���charAt()�����õ��ַ���name�����һ���ַ���
		System.out.println("���һ���ַ�ʱ��"+name.charAt(name.length()-1));
		//����String���substring��������ȡ�ַ���name��λ�á�0������һ���ո��ǰ���ַ���
		System.out.println("��һ��������"+name.substring(0,name.indexOf(" ")));
		//����String���indexOf()��������crazy��λ�á�
		System.out.println("crazy��λ���ǣ�"+(name.indexOf("crazy")+1));
	}

}
