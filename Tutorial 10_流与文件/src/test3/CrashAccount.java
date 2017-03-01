package test3;
import java.util.Date;

import java.text.SimpleDateFormat;
public class CrashAccount extends Account {
	private TypeOfCard type;						//银行卡的类型
	public CrashAccount() {							//默认构构造方法
		
	}

	
	
	public CrashAccount(String id,String name,TypeOfCard type)
	{
		super.setUername(name);
		super.setAid(id);
		this.type=type;
		balance = 0;
		date = new Date();
	}

	public void deposit(double amount){			//存款方法
		// TODO Auto-generated method stub
		if(amount < 0)								//如果存款金额为负
			System.out.println("存款金额不能为负");
		else	{								//存款成功
			balance += amount;
			Main.addRecord(this, amount);		//添加流水记录
			Main.updateAccount(this.aid, this.ToString());//修改用户信息
		}
	}

	@Override
	public void withdraw(double amount) 
			throws WithdrawException {
		// TODO Auto-generated method stub
		if(amount <= balance){						//如果取款金额小于余额，取款成功
			balance -= amount;
			Main.addRecord(this, -1*amount);		//添加流水记录
			Main.updateAccount(username, this.ToString());//修改用户信息
			System.out.println("取款成功"+"  取款人："+username+" 账户余额："+balance);
		}
		else										//如果取款金额大于余额，抛出取款异常。
			throw new WithdrawException("取款失败"+"取款人："+username+"	"
					+ "账户余额："+balance+"	取款额："+amount+"原因"+"余额不足");
	}
	
	public TypeOfCard getType() {					//返回银行卡的类型
		return type;
	}

	public void setType(TypeOfCard type) {			//设置银行卡的类型
		this.type = type;
	}

	

	
	public String ToString() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd|HH:mm:ss");
		String str = ""+balance;
		StringBuilder b = new StringBuilder(str);
		b.setLength(10);
		String s = "账户ID:"+aid+"\t姓名:"+username+"\t客户类型:现金卡"+"\t账户"
				+ "类型:"+type+"\t余额:"+b.toString()+"\t日期:"+sdf.format(date);
		return s;
	}
	public String ToRecord(double a){
		String s = new String();
		String t = new String();
		if(a < 0)
			t="取款  ";
		if(a > 0)
			t="存款  ";
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		s = "账户ID:"+aid+"\t姓名:"+username+"\t日期:"+sdf.format(new Date())+"\t流水类型:"+t+"\t金额:"+Math.abs(a);
		return s;
	}
}
//枚举类型用来表示现金卡的类型（工资卡、借记卡、理财卡）
enum TypeOfCard{
	工资卡,				//工资卡
	借记卡,				//借记卡
	理财卡	//理财卡
}
