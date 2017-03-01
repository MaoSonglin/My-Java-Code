package test2;

public class Account {

	public Account() {
		// TODO Auto-generated constructor stub
		balance = (int)(Math.random()*10000+3000);
	}
	public Account(double f)throws NegativeAmountException{
		if(f > 0)
			balance = f;
		else
			throw new NegativeAmountException("��ʼ����쳣");
	}
	public double getBalance(){return balance;}							//���ؽ��
	public void deposit(double amount)throws NegativeAmountException{	//���
		if(amount > 0)
			balance += amount;
		else
			throw new NegativeAmountException("��������");
	}
	public void withdrawl(double amount)throws NegativeAmountException{	//ȡ��
		if(amount > balance)
			throw new NegativeAmountException("����");
		else if(amount < 0)
			throw new NegativeAmountException("��������");
		else
			balance-=amount;
	}
	
	private double balance;
}
