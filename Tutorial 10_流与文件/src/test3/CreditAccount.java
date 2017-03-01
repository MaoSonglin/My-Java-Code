package test3;
import java.util.Date;
import java.text.SimpleDateFormat;
public class CreditAccount extends Account{
	private lineOfCredit type;
	
	public CreditAccount(){}
	public CreditAccount(String id,String name,lineOfCredit type){
		super.setUername(name);
		super.setAid(id);
		this.type=type;
		balance = 0;
		date = new Date();
	}
	
	public void deposit(double amount) {		//存款方法
		// TODO Auto-generated method stub
		if(amount < 0)							//存款金额小于0，提示存款金额错误
			System.out.println("存款金额错误");
		else{									//存款成功
			balance += amount;
			Main.addRecord(this, amount);
			Main.updateAccount(aid, this.ToString());//修改用户信息
			System.out.println("存款成功");
		}
	}

	
	public void withdraw(double amount){
		// TODO Auto-generated method stub
		double aa=0;				//表示账号的超支额度
		switch(type){				//不同的账户等级超支额度不同
		case A级:aa = 10000;break;
		case B级:aa = 5000;break;
		case C级:aa = 2000;break;
		case D级:aa = 1000;break;
		}
		try{
			if(balance - amount >= -1*aa){			//用户取款金额小于余额或者未超过支出额度
				balance -= amount;
				Main.addRecord(this, amount*-1);//添加流水记录
				Main.updateAccount(aid, this.ToString());//修改用户信息
				System.out.println("取款成功"+"  取款人："+username+" 账户余额："+balance);
			}else{								//用户的取款金额超出最大支出金额
				throw new WithdrawException("取款人："+username+""
						+ "	账户余额："+balance+"	取款额："+amount+"原因"+"余额不足");
			}
		}catch(WithdrawException e){System.out.println(e.getMessage());}
	}
	
	public lineOfCredit getType() {
		return type;
	}

	public void setType(lineOfCredit type) {
		this.type = type;
		//Main.updateAccount(aid, this.ToString());//修改用户信息
	}
	
	public double findOverdraw(){
		if(balance < 0)
			return balance;
		else return 0;
	}
	
	public String ToString() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd|HH:mm:ss");
		String str = ""+balance;
		StringBuilder b = new StringBuilder(str);
		b.setLength(10);
		String s="账户ID:"+aid+"\t姓名:"+username+"\t客户类型:信用卡"+"\t信用等级"
				+ ":"+type+" \t余额:"+b.toString()+"\t日期:"+sdf.format(date);
		return s;
	}
	public String ToRecord(double a){
		String s = new String();
		String t = new String();
		if(a < 0 && balance >=0)
			t="取款  ";
		if(a < 0 && balance < 0)
			t="透支";
		if(a > 0)
			t="存款  ";
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		s = "账户ID:"+aid+"\t姓名:"+username+"\t日期:"+sdf.format(new Date())+"\t流水类型:"+t+"\t金额:"+Math.abs(a);
		return s;
	}
}
enum lineOfCredit{			//枚举类型表示账户的信用度
	A级,						//最高级A
	B级,
	C级,
	D级
}