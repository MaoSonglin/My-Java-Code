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
	
	public void deposit(double amount) {		//����
		// TODO Auto-generated method stub
		if(amount < 0)							//�����С��0����ʾ��������
			System.out.println("��������");
		else{									//���ɹ�
			balance += amount;
			Main.addRecord(this, amount);
			Main.updateAccount(aid, this.ToString());//�޸��û���Ϣ
			System.out.println("���ɹ�");
		}
	}

	
	public void withdraw(double amount){
		// TODO Auto-generated method stub
		double aa=0;				//��ʾ�˺ŵĳ�֧���
		switch(type){				//��ͬ���˻��ȼ���֧��Ȳ�ͬ
		case A��:aa = 10000;break;
		case B��:aa = 5000;break;
		case C��:aa = 2000;break;
		case D��:aa = 1000;break;
		}
		try{
			if(balance - amount >= -1*aa){			//�û�ȡ����С��������δ����֧�����
				balance -= amount;
				Main.addRecord(this, amount*-1);//�����ˮ��¼
				Main.updateAccount(aid, this.ToString());//�޸��û���Ϣ
				System.out.println("ȡ��ɹ�"+"  ȡ���ˣ�"+username+" �˻���"+balance);
			}else{								//�û���ȡ��������֧�����
				throw new WithdrawException("ȡ���ˣ�"+username+""
						+ "	�˻���"+balance+"	ȡ��"+amount+"ԭ��"+"����");
			}
		}catch(WithdrawException e){System.out.println(e.getMessage());}
	}
	
	public lineOfCredit getType() {
		return type;
	}

	public void setType(lineOfCredit type) {
		this.type = type;
		//Main.updateAccount(aid, this.ToString());//�޸��û���Ϣ
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
		String s="�˻�ID:"+aid+"\t����:"+username+"\t�ͻ�����:���ÿ�"+"\t���õȼ�"
				+ ":"+type+" \t���:"+b.toString()+"\t����:"+sdf.format(date);
		return s;
	}
	public String ToRecord(double a){
		String s = new String();
		String t = new String();
		if(a < 0 && balance >=0)
			t="ȡ��  ";
		if(a < 0 && balance < 0)
			t="͸֧";
		if(a > 0)
			t="���  ";
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		s = "�˻�ID:"+aid+"\t����:"+username+"\t����:"+sdf.format(new Date())+"\t��ˮ����:"+t+"\t���:"+Math.abs(a);
		return s;
	}
}
enum lineOfCredit{			//ö�����ͱ�ʾ�˻������ö�
	A��,						//��߼�A
	B��,
	C��,
	D��
}