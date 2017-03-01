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
			System.out.println("1-------【查询】");
			System.out.println("2-------【取款】");
			System.out.println("3-------【存款】");
			System.out.println("4-------【退出】");
			System.out.print("请选择：");
			try{
				
				option = opSe.nextInt();
				switch(option){
				case 1:
					System.out.println("您的余额为："+account.getBalance()+"元");
					break;
				case 2:
					System.out.println("输入取款金额：");
					double amount = read.nextDouble();
					account.withdrawl(amount);
					System.out.println("取款成功");
					break;
				case 3:
					System.out.println("输入存款金额：");
					double amount2 = read.nextDouble();
					account.deposit(amount2);
					System.out.println("存款成功");
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
