package test4;
//import java.util.Scanner;
public class Main {
	
	public static void main(String arg[])
	{
		Account credit = new CrashAccount(0);
		Account debit = new CreditAccount(0);
		
		//将两个账户存款500元
		credit.deposit(500);
		debit.deposit(500);
		
		//取款200后再取款400元
		try {
			credit.withdraw(200);
			debit.withdraw(200);
			credit.withdraw(400);
			debit.withdraw(400);
			
		} catch (WirhdrawException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println("CreditAccountUser透支额为："+((CreditAccount)debit).findOverdraw());
	}
}
