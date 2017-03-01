package atm;
import java.util.Date;
import java.util.Scanner;
@SuppressWarnings("serial")
class MyException extends Exception{
	public MyException(String s){
		message = s;
	}
	public void printMessage(){
		System.out.println(message);
	}
	private String message;
}
@SuppressWarnings("serial")
class SumInputErrorException extends Exception{				//�쳣�࣬��ʾ�������Ľ��
	public void printMessage(){
		System.out.println("����������");
	}
}
@SuppressWarnings("serial")
class PasswordErrorThreeTimesException extends Exception{   //�쳣�࣬��ʾ����������󳬹�����
	public PasswordErrorThreeTimesException(){
		message = "3��������������������п���������";
	}
	public void printMessage(){
		System.out.println(message);
	}
	private String message = new String();
}
public class ATM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IDinput();
		passwordInput();
		@SuppressWarnings("resource")
		Scanner opin = new Scanner(System.in);
		int oper;											//����ѡ��
		boolean tag = true;                                 //�˿���־��false��ʾ�˳�
		do{
			operationSelectFrame();//��ӡ����ѡ�����
			oper = opin.nextInt();
			switch(oper){
			case 1://����1��ȡ��
				int value = withdrawl();
				if(value == 1)
					System.out.println("ȡ��ɹ���");
				else if(value == 0)
					System.out.println("���㣡");
				break;
			case 2://����2��ת��
				if(transfer())
					System.out.println("ת�˳ɹ���");
				else
					System.out.println("ת��ʧ�ܣ�");
				break;
			case 3://����3����ѯ
				lookOut();break;
			case 4://����4���޸�����
				if(update())
					System.out.println("�޸ĳɹ���");
				else
					System.out.println("�޸�ʧ�ܣ�");
				break;
			case 5:tag = false;break;//�˿�
			default:System.out.println("�޴˲�����");
			}
			
		}while(tag);
	}
	private static String IDinput(){							//�����˺�
		@SuppressWarnings("resource")
		Scanner inputid = new Scanner(System.in);
		System.out.println("�����������˺�");
		String id_inputed = inputid.nextLine();
		return id_inputed;
	}
	private static boolean passwordInput(){						//��������
		@SuppressWarnings("resource")
		Scanner inputpassword = new Scanner(System.in);
		String pw = null;
		int count = 0; 											//��¼�������������
		boolean tag = true;
		try{
			do{
				System.out.println("�������������룬��ע���ڵ�!");
				pw = inputpassword.nextLine();
				count++;
				tag = true;
				if(pw.equals(password)){
					tag = false;
				}else{
					System.out.println("�����������");
				}
				if(count==3&&tag==true){
					throw new PasswordErrorThreeTimesException();
				}
			}while(tag);
		}catch(PasswordErrorThreeTimesException e){
			e.printMessage();
			System.exit(1);
		}
		if(pw.equals(password))
			return true;
		else 
			return false;
	}
	private static void lookOut(){								//��ѯ
		System.out.println("�������Ϊ��"+money);
	}
	private static boolean transfer(){							//ת��
		@SuppressWarnings("resource")
		Scanner idinput = new Scanner(System.in);
		@SuppressWarnings("resource")
		Scanner idinput2 = new Scanner(System.in);
		boolean tag = true;
		do{
			System.out.println("����ת���˻�");
			String userid1 = idinput.nextLine();
			System.out.println("�ٴ�����ת���˻�");
			String userid2 = idinput2.nextLine();
			if(userid1.equals(userid2))
			{	
				tag = false;
			}
			else 
				System.out.println("���������˻���ͬ��");
		}while(tag);
		System.out.print("������ת�˽�");
		float e = idinput.nextFloat();
		if(e <= money){
			money -= e;
			return true;
		}
		else 
			return false;
	}
	private static boolean update(){
		@SuppressWarnings("resource")
		Scanner inpw = new Scanner(System.in);
		System.out.print("������ԭ���룺");
		String bp = inpw.nextLine();
		
		if(!bp.equals(password)){
			System.out.println("�������");
			return false;
		}
		System.out.print("���������룺");
		String np = inpw.nextLine();
		System.out.print("ȷ�����룺");
		String renp = inpw.nextLine();
		
		if(!renp.equals(np)){
			System.out.println("�����������벻ͬ");
			return false;
		}
		password = np;
		return true;
	}	
	private static int withdrawl(){								//ȡ�����
		moneySelectFrame();
		int option = 0;										//ѡ��Ҫȡ��Ǯ
		@SuppressWarnings("resource")
		Scanner optioninput=new Scanner(System.in);
		option = optioninput.nextInt();
		int needmoney = 0;									//��Ҫȡ����Ǯ
		switch(option){
		case 1:needmoney = 100;break;
		case 2:needmoney = 500;break;
		case 3:needmoney = 1000;break;
		case 4:needmoney = 1500;break;
		case 5:needmoney = 2000;break;
		case 6:											//�Զ���ȡǮ��������������100�ı���
			Scanner moneyinput =new Scanner(System.in);
			boolean tag = true;
			do{
				System.out.println("������ȡ����");
				try{
					String nm = moneyinput.nextLine();	
					if(nm.equals("A"))
						throw new MyException("���㣡");
					boolean fag = false;
					for(int i = 0; i < nm.length(); i++){//�ж��Ƿ��������ַ�
						if(nm.charAt(i) < '0' || nm.charAt(i) > '9')
						{
							fag = true;
							break;
						}
					}
					
					if(needmoney % 100 != 0||fag)
						throw new SumInputErrorException();
					needmoney = Integer.parseInt(nm);
					tag = false;
				}catch(SumInputErrorException e){
					e.printMessage();
					tag = true;
				}catch(MyException el){
					el.printMessage();
				}
			}while(tag);
			break;
		case 7:return -1;							//����7���˳�ȡ��
		default:System.out.println("���������������ȷѡ��");
		}
		if(needmoney <= money){						//ȡ��ɹ�����1
			money -= needmoney;
			return 1;
		}else{										//�˻���û���㹻��������0
			return 0;
		}
	}
	private static void operationSelectFrame(){
		System.out.println("��ȡ�---------------------1");
		System.out.println("��ת�ˡ�---------------------2");
		System.out.println("����ѯ��---------------------3");
		System.out.println("���޸����롿 -----------------4");
		System.out.println("��ȡ����---------------------5");
	}
	private static void moneySelectFrame(){
		System.out.println("��100��---------------------1");
		System.out.println("��500��---------------------2");
		System.out.println("��1000��--------------------3");
		System.out.println("��1500��--------------------4");
		System.out.println("��2000��--------------------5");
		System.out.println("��������� ��----------------6");	
		System.out.println("�����ء� --------------------7");
	}

	
	
	@SuppressWarnings("unused")
	private static final String UERID = "11111111111";      		//�û�ID
	@SuppressWarnings("unused")
	private static final String UERNAME = "***";					//�û���
	private static String password = "000000";						//�û����� 
	private static double money = (int)(Math.random()*10000)+1000;  //�û����
	@SuppressWarnings("unused")
	private static Date date = new Date();							//����ʱ��
}
