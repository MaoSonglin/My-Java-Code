package test4;

public class CrashAccount extends Account {

	public CrashAccount() {							//Ĭ�Ϲ����췽��
		// TODO Auto-generated constructor stub
		type = TypeOfCard.Debit_ard;				//�˻�����Ĭ��Ϊ��ǿ�
		username = "CrashAccountUser";				//�û���Ĭ��ΪCrashAccountUser
		aid = "2013521478";							//Ĭ���˺�ID
	}
	public CrashAccount(double amount){			//���������췽��
		this();										//����Ĭ�Ϲ��췽��
		balance = amount;							//��ʼ�����
	}

	@Override
	public void deposit(double amount){			//����
		// TODO Auto-generated method stub
		if(amount < 0)								//��������Ϊ��
			System.out.println("������Ϊ��");
		else	{								//���ɹ�
			balance += amount;
			System.out.println("���ɹ�");
		}
	}

	@Override
	public void withdraw(double amount) 
			throws WirhdrawException {
		// TODO Auto-generated method stub
		if(amount <= balance){						//���ȡ����С����ȡ��ɹ�
			balance -= amount;
			System.out.println("ȡ��ɹ�"+"  ȡ���ˣ�"+username+" �˻���"+balance);
		}
		else										//���ȡ����������׳�ȡ���쳣��
			throw new WirhdrawException("ȡ���ˣ�"+username+"	"
					+ "�˻���"+balance+"	ȡ��"+amount+"ԭ��"+"����");
	}
	
	public TypeOfCard getType() {					//�������п�������
		return type;
	}

	public void setType(TypeOfCard type) {			//�������п�������
		this.type = type;
	}

	private TypeOfCard type;						//���п�������
}
//ö������������ʾ�ֽ𿨵����ͣ����ʿ�����ǿ�����ƿ���
enum TypeOfCard{
	pay_card,				//���ʿ�
	Debit_ard,				//��ǿ�
	wealth_manager_card	//��ƿ�
}
