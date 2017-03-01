import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean tag = true;	
		Scanner scan = new Scanner(System.in);
		int size=0 ,big=0,end=0;//= scan.nextInt();
		while(tag){
			try{
				System.out.print("输入需要得到的计算机数目：");
				size = scan.nextInt();
				System.out.println("输入最小值：");
				big = scan.nextInt();
				System.out.println("输入最大值：");
				end = scan.nextInt();
				tag = false;
			}catch(Exception e){
				System.out.println("输入错误，请重新输入！");
				tag = true;
			}
		}
		String array[] = new String[size];//存放题目的字符串数组，每个字符串为一道题
		for(int i = 0; i < size; i++){
			array[i] = function(big,end);
			int j = i-1;
			while(j >= 0){//避免出现重复的题目
				if(array[j].equals(array[i])){//如果之前的题目中出现了一样的题目
					array[i] = function(big,end);
					j = i;
				}
				j--;
			}
			System.out.println((i+1)+": "+array[i]);
		}
		scan.close();
	}

	public static String function(int big,int size){//生成一道题目
		
		String[] operator = new String[5];
		operator[0] = "+";
		operator[1] = "-";
		operator[2] = "*";
		operator[3] = "/";
		operator[4] = "+";
		
		int index  = (int)(Math.random() * 4);
		int num1 = (int)(Math.random() * (size-big))+big;
		int num2 = (int)(Math.random() * (size-big))+big;
		while(num2==0 && index==3)
			num2 = (int)(Math.random() * (size-big))+big;
		return num1 + " " + operator[index] + " " + num2 + " =";
	}
}
