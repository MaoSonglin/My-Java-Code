package test4;

public class CreditAccount extends Account{

	public CreditAccount() {					//Ĭ�Ϲ��췽��
		// TODO Auto-generated constructor stub
		type = lineOfCredit.A;					//���õȼ�Ĭ��Ϊ��ߵȼ�A
		username = "CreditAccountUser";			//�û���Ĭ��ΪCreditAccountUser
		aid = "58475487124";					//�û��˺�
	}
	public CreditAccount(double amount){
		this();									//����Ĭ�Ϲ��췽��
		balance = amount;						//����ʼ��
	}
	@Override
	public void deposit(double amount) {		//����
		// TODO Auto-generated method stub
		if(amount < 0)							//�����С��0����ʾ��������
			System.out.println("��������");
		else{									//���ɹ�
			balance += amount;
			System.out.println("���ɹ�");
		}
	}

	@Override
	public void withdraw(double amount) throws WirhdrawException{
		// TODO Auto-generated method stub
		double aa=0;				//��ʾ�˺ŵĳ�֧���
		switch(type){				//��ͬ���˻��ȼ���֧��Ȳ�ͬ
		case A:aa = 10000;break;
		case B:aa = 5000;break;
		case C:aa = 2000;break;
		case D:aa = 1000;break;
		}
		if(balance - amount < aa){			//�û�ȡ����С��������δ����֧�����
			balance -= amount;
			System.out.println("ȡ��ɹ�"+"  ȡ���ˣ�"+username+" �˻���"+balance);
		}else{								//�û���ȡ��������֧�����
			throw new WirhdrawException("ȡ���ˣ�"+username+""
					+ "	�˻���"+balance+"	ȡ��"+amount+"ԭ��"+"����");
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
enum lineOfCredit{			//ö�����ͱ�ʾ�˻������ö�
	A,						//��߼�A
	B,
	C,
	D
}