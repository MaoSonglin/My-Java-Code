package test4;

public class CrashAccount extends Account {

	public CrashAccount() {							//默认构构造方法
		// TODO Auto-generated constructor stub
		type = TypeOfCard.Debit_ard;				//账户类型默认为借记卡
		username = "CrashAccountUser";				//用户名默认为CrashAccountUser
		aid = "2013521478";							//默认账号ID
	}
	public CrashAccount(double amount){			//带参数构造方法
		this();										//调用默认构造方法
		balance = amount;							//初始化余额
	}

	@Override
	public void deposit(double amount){			//存款方法
		// TODO Auto-generated method stub
		if(amount < 0)								//如果存款金额为负
			System.out.println("存款金额不能为负");
		else	{								//存款成功
			balance += amount;
			System.out.println("存款成功");
		}
	}

	@Override
	public void withdraw(double amount) 
			throws WirhdrawException {
		// TODO Auto-generated method stub
		if(amount <= balance){						//如果取款金额小于余额，取款成功
			balance -= amount;
			System.out.println("取款成功"+"  取款人："+username+" 账户余额："+balance);
		}
		else										//如果取款金额大于余额，抛出取款异常。
			throw new WirhdrawException("取款人："+username+"	"
					+ "账户余额："+balance+"	取款额："+amount+"原因"+"余额不足");
	}
	
	public TypeOfCard getType() {					//返回银行卡的类型
		return type;
	}

	public void setType(TypeOfCard type) {			//设置银行卡的类型
		this.type = type;
	}

	private TypeOfCard type;						//银行卡的类型
}
//枚举类型用来表示现金卡的类型（工资卡、借记卡、理财卡）
enum TypeOfCard{
	pay_card,				//工资卡
	Debit_ard,				//借记卡
	wealth_manager_card	//理财卡
}
