package dongshoudongnao;
import java.util.Scanner;
public class Achievement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		String str;
		try{
			System.out.println("��������ĳɼ���");
			str = input.nextLine();
			for(int i = 0; i < str.length();i++){
				if(str.charAt(i)<'0' || str.charAt(i) > '9')
					throw new Exception("��������ȷ�����֣�");
			}
			int score = Integer.parseInt(str);
			if(score < 0 || score > 100)
				throw new Exception("����ɼ�����");
			if(score < 60)
				throw new Exception("������!");
			else if(score < 70)
				throw new Exception("����!");
			else if(score < 80)
				throw new Exception("��!");
			else if(score < 90)
				throw new Exception("��!");
			else
				throw new Exception("��!");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			input.close();
		}
	}

}
