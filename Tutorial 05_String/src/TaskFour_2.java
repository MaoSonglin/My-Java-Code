
public class TaskFour_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = new String("There are moments in life when you"
				+ " miss someone so much that you just want to pick "
				+ "them from your dreams and hug them for real! Dream"
				+ " what you want to dream;go where you want to go;be "
				+ "what you want to be,because you have only one life"
				+ " and one chance to do all the things you want to do.");
		int upper_count = 0;
		int lower_count = 0;
		int mumber_count = 0;
		int none_count = 0;
		int else_count = 0;
		int i = 0;
		while(i < str.length()&&str.charAt(i) != '\n'){
			char temp = str.charAt(i);
			if(temp >= 'A' && temp <= 'Z')
				upper_count++;
			else if(temp >= 'a' && temp <= 'z')
				lower_count++;
			else if(temp >= '0' && temp <= '9')
				mumber_count++;
			else if(temp == ' ')
				none_count++;
			else
				else_count++;
			i++;
		}
		System.out.println("���ı���д��ĸ����Ϊ��"+upper_count);
		System.out.println("Сд��ĸ����Ϊ��"+lower_count);
		System.out.println("���ָ���Ϊ��"+mumber_count);
		System.out.println("�ո���Ϊ��"+none_count);
		System.out.println("�����ַ�����Ϊ��"+else_count);
	}

}
