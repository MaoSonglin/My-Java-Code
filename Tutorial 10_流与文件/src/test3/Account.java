package test3;

import java.util.Date;

public abstract class Account {

	public Account() {
		// TODO Auto-generated constructor stub
	}
	public abstract void deposit(double amount);		//存款
	public abstract void withdraw(double amount)
			throws WithdrawException;					//取款
	public abstract String ToString();
	public abstract String ToRecord(double a);					//组成一条流水记录
	public double getBalance(){return balance;}			//返回余额
	public String getUername(){return username;}		//返回用户名
	public Date getDate(){
		return date;
		}
	public String getAid(){return aid;}					//返回用户id
	public void setUername(String name)					//设置用户名
	{
		StringBuilder builder = null;
        if(name != null) 
            builder = new StringBuilder(name); 
        else 
            builder = new StringBuilder(15); 
 
        builder.setLength(10); // 最长 15 字符
        this.username = builder.toString();
        //Main.updateAccount(aid, this.toString());//修改用户信息
	}
	public void setAid(String name){					//设置用户账号
		StringBuilder builder = null;
        if(name != null) 
            builder = new StringBuilder(name); 
        else 
            builder = new StringBuilder(11); 
 
        builder.setLength(11); // 最长 15 字符
        this.aid = builder.toString();
        //Main.updateAccount(username, this.toString());//修改用户信息
	}
	public void setBalance(double d){
		balance = d;
		//Main.updateAccount(aid, this.toString());//修改用户信息
	}
	
	public void setDate(Date d){
		date = d;
		//Main.updateAccount(aid, this.toString());//修改用户信息
	}
	public void setAccountNubmer(int i){account_number=i;}
	public int getAccountNubmer(){return account_number;}
	public int getRecordNubmer(){return record_number;}
	public void setRecordNumber(int i){record_number=i;}
	public int getSize(){return size;}
	public int getRecordSize(){return recordsize;}
	protected String username;			//用户姓名
	protected String aid;				//用户号码
	protected double balance;			//余额
	protected Date date;				//创建账户的日期
	protected static final int size = 80;					//每个用户的最大长度
	protected static final int recordsize = 77;
	protected static int account_number = 0;	//账户个数
	protected static int record_number=0;		//记录个数
}
