package test4;

public abstract class Account {

	public Account() {
		// TODO Auto-generated constructor stub
	}
	public abstract void deposit(double amount);		//���
	public abstract void withdraw(double amount)
			throws WirhdrawException;					//ȡ��
	
	public double getBalance(){return balance;}			//�������
	public String getUername(){return username;}		//�����û���
	public String getAid(){return aid;}					//�����û�id
	public void setUername(String newusername)			//�����û���
	{
		username=newusername;
	}
	public void setAid(String newaid){					//�����û��˺�
		aid = newaid;
	}
	protected String username;			//�û�����
	protected String aid;				//�û�����
	protected double balance;			//���
}
