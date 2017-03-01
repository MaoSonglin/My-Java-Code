package test4;

public class CreditAccount extends Account{

	public CreditAccount() {					//默认构造方法
		// TODO Auto-generated constructor stub
		type = lineOfCredit.A;					//信用等级默认为最高等级A
		username = "CreditAccountUser";			//用户名默认为CreditAccountUser
		aid = "58475487124";					//用户账号
	}
	public CreditAccount(double amount){
		this();									//调用默认构造方法
		balance = amount;						//余额初始化
	}
	@Override
	public void deposit(double amount) {		//存款方法
		// TODO Auto-generated method stub
		if(amount < 0)							//存款金额小于0，提示存款金额错误
			System.out.println("存款金额错误");
		else{									//存款成功
			balance += amount;
			System.out.println("存款成功");
		}
	}

	@Override
	public void withdraw(double amount) throws WirhdrawException{
		// TODO Auto-generated method stub
		double aa=0;				//表示账号的超支额度
		switch(type){				//不同的账户等级超支额度不同
		case A:aa = 10000;break;
		case B:aa = 5000;break;
		case C:aa = 2000;break;
		case D:aa = 1000;break;
		}
		if(balance - amount < aa){			//用户取款金额小于余额或者未超过支出额度
			balance -= amount;
			System.out.println("取款成功"+"  取款人："+username+" 账户余额："+balance);
		}else{								//用户的取款金额超出最大支出金额
			throw new WirhdrawException("取款人："+username+""
					+ "	账户余额："+balance+"	取款额："+amount+"原因"+"余额不足");
		}
	}
	
	public lineOfCredit getType() {
		return type;
	}

	public void setType(lineOfCredit type) {
		this.type = type;
	}
	
	public double findOverdraw(){
		if(balance < 0)
			return balance;
		else return 0;
	}
	private lineOfCredit type;
}
enum lineOfCredit{			//枚举类型表示账户的信用度
	A,						//最高级A
	B,
	C,
	D
}