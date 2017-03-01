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
			throw new NegativeAmountException("初始金额异常");
	}
	public double getBalance(){return balance;}							//返回金额
	public void deposit(double amount)throws NegativeAmountException{	//存款
		if(amount > 0)
			balance += amount;
		else
			throw new NegativeAmountException("存款金额错误");
	}
	public void withdrawl(double amount)throws NegativeAmountException{	//取款
		if(amount > balance)
			throw new NegativeAmountException("余额不足");
		else if(amount < 0)
			throw new NegativeAmountException("操作错误");
		else
			balance-=amount;
	}
	
	private double balance;
}
