import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean tag = true;	
		Scanner scan = new Scanner(System.in);
		int size=0 ,big=0,end=0;//= scan.nextInt();
		while(tag){
			try{
				System.out.print("������Ҫ�õ��ļ������Ŀ��");
				size = scan.nextInt();
				System.out.println("������Сֵ��");
				big = scan.nextInt();
				System.out.println("�������ֵ��");
				end = scan.nextInt();
				tag = false;
			}catch(Exception e){
				System.out.println("����������������룡");
				tag = true;
			}
		}
		String array[] = new String[size];//�����Ŀ���ַ������飬ÿ���ַ���Ϊһ����
		for(int i = 0; i < size; i++){
			array[i] = function(big,end);
			int j = i-1;
			while(j >= 0){//��������ظ�����Ŀ
				if(array[j].equals(array[i])){//���֮ǰ����Ŀ�г�����һ������Ŀ
					array[i] = function(big,end);
					j = i;
				}
				j--;
			}
			System.out.println((i+1)+": "+array[i]);
		}
		scan.close();
	}

	public static String function(int big,int size){//����һ����Ŀ
		
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
