package test2;
import java.util.Scanner;
public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws NegativeAmountException {
		// TODO Auto-generated method stub
		Scanner opSe = new Scanner(System.in);
		Scanner read = new Scanner(System.in);
		
		Account account = null;
		account = new Account((int)(Math.random()*3000+2000));
		boolean endTag = true;
		int option;
		do{
			System.out.println("1-------����ѯ��");
			System.out.println("2-------��ȡ�");
			System.out.println("3-------����");
			System.out.println("4-------���˳���");
			System.out.print("��ѡ��");
			try{
				
				option = opSe.nextInt();
				switch(option){
				case 1:
					System.out.println("�������Ϊ��"+account.getBalance()+"Ԫ");
					break;
				case 2:
					System.out.println("����ȡ���");
					double amount = read.nextDouble();
					account.withdrawl(amount);
					System.out.println("ȡ��ɹ�");
					break;
				case 3:
					System.out.println("�������");
					double amount2 = read.nextDouble();
					account.deposit(amount2);
					System.out.println("���ɹ�");
					break;
				case 4:
					endTag = false;
				}
				
			}catch(NegativeAmountException e1){
				System.out.println(e1.getMessage());
			}
		}while(endTag);
	}

}
