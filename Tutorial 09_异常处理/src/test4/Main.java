package test4;
//import java.util.Scanner;
public class Main {
	
	public static void main(String arg[])
	{
		Account credit = new CrashAccount(0);
		Account debit = new CreditAccount(0);
		
		//�������˻����500Ԫ
		credit.deposit(500);
		debit.deposit(500);
		
		//ȡ��200����ȡ��400Ԫ
		try {
			credit.withdraw(200);
			debit.withdraw(200);
			credit.withdraw(400);
			debit.withdraw(400);
			
		} catch (WirhdrawException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println("CreditAccountUser͸֧��Ϊ��"+((CreditAccount)debit).findOverdraw());
	}
}
