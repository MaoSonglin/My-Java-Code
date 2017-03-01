package dongshoudongnao;
import java.util.Scanner;
public class Achievement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		String str;
		try{
			System.out.println("请输入你的成绩：");
			str = input.nextLine();
			for(int i = 0; i < str.length();i++){
				if(str.charAt(i)<'0' || str.charAt(i) > '9')
					throw new Exception("请输入正确的数字！");
			}
			int score = Integer.parseInt(str);
			if(score < 0 || score > 100)
				throw new Exception("输入成绩错误！");
			if(score < 60)
				throw new Exception("不及格!");
			else if(score < 70)
				throw new Exception("及格!");
			else if(score < 80)
				throw new Exception("中!");
			else if(score < 90)
				throw new Exception("良!");
			else
				throw new Exception("优!");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			input.close();
		}
	}

}
