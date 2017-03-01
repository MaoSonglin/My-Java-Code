package test3;
import java.util.Date;

import java.text.SimpleDateFormat;
public class CrashAccount extends Account {
	private TypeOfCard type;						//���п�������
	public CrashAccount() {							//Ĭ�Ϲ����췽��
		
	}

	
	
	public CrashAccount(String id,String name,TypeOfCard type)
	{
		super.setUername(name);
		super.setAid(id);
		this.type=type;
		balance = 0;
		date = new Date();
	}

	public void deposit(double amount){			//����
		// TODO Auto-generated method stub
		if(amount < 0)								//��������Ϊ��
			System.out.println("������Ϊ��");
		else	{								//���ɹ�
			balance += amount;
			Main.addRecord(this, amount);		//�����ˮ��¼
			Main.updateAccount(this.aid, this.ToString());//�޸��û���Ϣ
		}
	}

	@Override
	public void withdraw(double amount) 
			throws WithdrawException {
		// TODO Auto-generated method stub
		if(amount <= balance){						//���ȡ����С����ȡ��ɹ�
			balance -= amount;
			Main.addRecord(this, -1*amount);		//�����ˮ��¼
			Main.updateAccount(username, this.ToString());//�޸��û���Ϣ
			System.out.println("ȡ��ɹ�"+"  ȡ���ˣ�"+username+" �˻���"+balance);
		}
		else										//���ȡ����������׳�ȡ���쳣��
			throw new WithdrawException("ȡ��ʧ��"+"ȡ���ˣ�"+username+"	"
					+ "�˻���"+balance+"	ȡ��"+amount+"ԭ��"+"����");
	}
	
	public TypeOfCard getType() {					//�������п�������
		return type;
	}

	public void setType(TypeOfCard type) {			//�������п�������
		this.type = type;
	}

	

	
	public String ToString() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd|HH:mm:ss");
		String str = ""+balance;
		StringBuilder b = new StringBuilder(str);
		b.setLength(10);
		String s = "�˻�ID:"+aid+"\t����:"+username+"\t�ͻ�����:�ֽ�"+"\t�˻�"
				+ "����:"+type+"\t���:"+b.toString()+"\t����:"+sdf.format(date);
		return s;
	}
	public String ToRecord(double a){
		String s = new String();
		String t = new String();
		if(a < 0)
			t="ȡ��  ";
		if(a > 0)
			t="���  ";
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		s = "�˻�ID:"+aid+"\t����:"+username+"\t����:"+sdf.format(new Date())+"\t��ˮ����:"+t+"\t���:"+Math.abs(a);
		return s;
	}
}
//ö������������ʾ�ֽ𿨵����ͣ����ʿ�����ǿ�����ƿ���
enum TypeOfCard{
	���ʿ�,				//���ʿ�
	��ǿ�,				//��ǿ�
	��ƿ�	//��ƿ�
}
