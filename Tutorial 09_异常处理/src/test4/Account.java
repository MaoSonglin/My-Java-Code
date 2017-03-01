package test4;

public abstract class Account {

	public Account() {
		// TODO Auto-generated constructor stub
	}
	public abstract void deposit(double amount);		//存款
	public abstract void withdraw(double amount)
			throws WirhdrawException;					//取款
	
	public double getBalance(){return balance;}			//返回余额
	public String getUername(){return username;}		//返回用户名
	public String getAid(){return aid;}					//返回用户id
	public void setUername(String newusername)			//设置用户名
	{
		username=newusername;
	}
	public void setAid(String newaid){					//设置用户账号
		aid = newaid;
	}
	protected String username;			//用户姓名
	protected String aid;				//用户号码
	protected double balance;			//余额
}
