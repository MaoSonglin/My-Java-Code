package test3;

import java.util.Date;

public abstract class Account {

	public Account() {
		// TODO Auto-generated constructor stub
	}
	public abstract void deposit(double amount);		//���
	public abstract void withdraw(double amount)
			throws WithdrawException;					//ȡ��
	public abstract String ToString();
	public abstract String ToRecord(double a);					//���һ����ˮ��¼
	public double getBalance(){return balance;}			//�������
	public String getUername(){return username;}		//�����û���
	public Date getDate(){
		return date;
		}
	public String getAid(){return aid;}					//�����û�id
	public void setUername(String name)					//�����û���
	{
		StringBuilder builder = null;
        if(name != null) 
            builder = new StringBuilder(name); 
        else 
            builder = new StringBuilder(15); 
 
        builder.setLength(10); // � 15 �ַ�
        this.username = builder.toString();
        //Main.updateAccount(aid, this.toString());//�޸��û���Ϣ
	}
	public void setAid(String name){					//�����û��˺�
		StringBuilder builder = null;
        if(name != null) 
            builder = new StringBuilder(name); 
        else 
            builder = new StringBuilder(11); 
 
        builder.setLength(11); // � 15 �ַ�
        this.aid = builder.toString();
        //Main.updateAccount(username, this.toString());//�޸��û���Ϣ
	}
	public void setBalance(double d){
		balance = d;
		//Main.updateAccount(aid, this.toString());//�޸��û���Ϣ
	}
	
	public void setDate(Date d){
		date = d;
		//Main.updateAccount(aid, this.toString());//�޸��û���Ϣ
	}
	public void setAccountNubmer(int i){account_number=i;}
	public int getAccountNubmer(){return account_number;}
	public int getRecordNubmer(){return record_number;}
	public void setRecordNumber(int i){record_number=i;}
	public int getSize(){return size;}
	public int getRecordSize(){return recordsize;}
	protected String username;			//�û�����
	protected String aid;				//�û�����
	protected double balance;			//���
	protected Date date;				//�����˻�������
	protected static final int size = 80;					//ÿ���û�����󳤶�
	protected static final int recordsize = 77;
	protected static int account_number = 0;	//�˻�����
	protected static int record_number=0;		//��¼����
}
