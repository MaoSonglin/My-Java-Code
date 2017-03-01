/*����д����ѯ�ܵ���ˮ���*/

//��1505-1��   20153144    ë����
package test3;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Main {

	public static void main(String[] args) throws WithdrawException {

		String a[] = selectAccount("liu");				//����һ���û�
		for(String aa:a)									//����û���Ϣ
			System.out.println(aa+" "+aa.length());
		Account client =null;								//����һ���˻�����
		if(a[0]!=null&&a[0]!="")client=tramslate(a[0]);		//���鵽���û���Ϣת���ɶ���
		else{
			System.out.println("�޴��û���");
			client = new CreditAccount("12345678910","�û���",lineOfCredit.A��);
			addAccount(client);
		}
		client.deposit(5000);								//���û����д�����
		client.withdraw(3000);								//���û�����ȡ�����
		client.deposit(200);
		client.withdraw(3000);
		client.deposit(4000);
		client.withdraw(8000);
		client.withdraw(2000);
		client.deposit(30000);
		
		String s[] = selectRecord(client.getAid());			//�����û�����ˮ��¼
		for(String ss:s)									//����û������ż�¼
			System.out.println(ss);
		
		System.out.println(calculate(client.aid,"���"));	//ͳ�ƴ���
		System.out.println(calculate(client.aid,"ȡ��"));	//ͳ��ȡ��
		
	}
	public static boolean addAccount(Account a){			//��һ���˻��Ļ�����Ϣ������ļ�ClientInforTable.txt�С�
		File f = new File("ClientInfoTable.txt");			//���ļ�����
		try {
			if(!f.exists())									//�ж��ļ��Ƿ���ڣ�����ļ������ڣ�����һ���µ��ļ�
				f.createNewFile();
			FileWriter fos = new FileWriter(f,true);		//�����ļ�������󣬲�����ļ���ԭ�е�����
			PrintWriter pw = new PrintWriter(fos);			//��PrintWriter�����װFileWriter����
			int n=a.getAccountNubmer();						//ÿ����һ���û���ʾ�û������ľ�̬����һ
			n++;
			a.setAccountNubmer(n);
			
			pw.println(a.ToString());						//���û�����Ϣת��Ϊ�ַ���������ļ��С�
			pw.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//�����û�������
	public static boolean updateAccount(String target,String replaced)
	{//targetΪ��Ҫ�������ݵ��˻����˺š�������������������Ϣ��replaced�Ǹ��û��µ�������Ϣת�����ַ���
		boolean tag = true;									//���³ɹ���־
		File  f = new File("ClientInfoTable.txt");				//���ļ�
		try{
			RandomAccessFile arf = new RandomAccessFile(f,"rw");//�������������
			String in = null;
			while((in=arf.readLine())!=null){					//��ȡ�ļ��е�һ�м�¼���жϸ�����¼�Ƿ�Ϊ��
				byte b[] = in.getBytes("iso-8859-1");			//��������¼ת��Ϊbyte���飬����������������
				String temp = new String(b);					//��byte�����ʼ��һ���õ�ǰ�ַ���������ַ���
				if(temp.indexOf(target)>=0){					//�ж϶�����ַ������Ƿ����target�ַ���
					arf.seek(arf.getFilePointer()-b.length-2);	//�������target�ַ��������������ָ���ƶ����ϴζ���Ŀ�ʼλ��
					arf.write(replaced.getBytes());		//��replacedת��Ϊbyte����д���ļ���
					//arf.writeChar('\n');
				}
			}
			arf.close();										//�ر����������
		}catch(IOException e){									//�쳣����
			e.printStackTrace();
			tag = false;
		}
		return tag;
	}
	public static boolean addRecord(Account a,double m){//Ϊ�˻�a���һ����ˮ��Ϣ
		
		File f =new File("BankInfoTable.txt");				//�����ļ�����
		try {
			if(!f.exists())									//�ж��ļ��Ƿ���ڣ�����ļ������ڣ�����һ���µ��ļ���
				f.createNewFile();
			FileWriter fos = new FileWriter(f,true);		//�����ļ������FileWriter���󣬴��ļ�ʱ�����ļ���ԭ�е�����
			PrintWriter pw = new PrintWriter(fos);			//��PrintWriter���װFileWriter����
			int n=a.getRecordNubmer();						//������ˮ��¼����һ��
			n++;
			a.setRecordNumber(n);;
			
			pw.println(n+"\t"+a.ToRecord(m));				//���û�����ˮ��¼��ӵ��ļ�ĩβ
			pw.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static String[] selectAccount(String target){
		//�����ַ���target�����û���Ϣ��target�������κ��ַ���
		//���ҵ������ݿ�������������Է�������Ӧ�����ַ�������
		String result = "";
		try {
			FileReader fr = new FileReader("ClientInfoTable.txt");	//�����ļ���ȡ����
			BufferedReader br = new BufferedReader(fr);				//��BufferedReader���װ�ļ���ȡ����
			String s=null;
			while((s=br.readLine())!=null){						//���ļ��ж���һ����¼���ж��Ƿ�Ϊ�ռ�¼
				if(s.indexOf(target)>=0)							//�жϸ�����¼���Ƿ���target�ַ���
					result +=s+ ";";								//����н�������¼��ӵ��ַ���result�У�����ĳλ���һ��������������󽫼�¼�ֿ�
			}
			br.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return result.split(";");//��split�������ַ����ֿ�
	}
	//��ѯ�˻���ˮ��Ϣ
	public static String[] selectRecord(String target){
		
		String result = "";	//��ѯ����ַ���
		String temp ="";	//�м�����ַ���
		try {
			FileReader fr = new FileReader("BankInfoTable.txt");	//�����ļ������ַ�������
			BufferedReader br = new BufferedReader(fr);				//��BufferedReader��װ�ļ��������
			
			do{
				result = br.readLine();//����һ����¼
				if(result!=null&&result.indexOf(target)>=0)//�жϸü�¼�Ƿ��������
					temp += result+"|";						//���������������������¼��ӵ��м�����ַ�����
			}while(result!=null);							//�����¼Ϊ���˳�ѭ��
			br.close();
		} catch (IOException e) {//
			e.printStackTrace();
		}
		if(temp != null)
		return temp.split("[|]");							//���м�����ָ�Ϊ������¼����
		else 												//����м����Ϊ�շ���null
			return null;
	}
	//ͳ���˻���ˮ��Ϣ
	public static String calculate(String target,String type){
		//target��ʾͳ�Ƶ��˻���־��typeΪͳ�����ͣ���ȡ����߳���֧����
		String array[] = selectRecord(target);				//���ö�ȡ�˻���ˮ��¼�ķ����õ�һ���ַ�������
		double balan=0;										//ͳ�ƵĽ��
		int len = array.length;								//��ˮ��¼����
		for(int i = 0; i < len; i++)						//ѭ���жϼ�¼�Ƿ��������
		{
			String curStr = array[i];						//curStr��ʾ��¼�����еĵ�ǰ��¼
			if(curStr.indexOf(type)>=0){					//�����ǰ��¼����ͳ�Ƶ�����
				String s = array[i].substring(69);			//��ȡ��¼�б�ʾ�����ַ���
				for(int j = 0; j < s.length(); j++)			//�жϽ�ȡ�Ƿ�����
					if(s.charAt(j)<'0'||s.charAt(j)>'9')
						s.replace(s.charAt(j), '\0');
				balan +=  Double.parseDouble(s.trim());		//����ȡ�Ľ���ַ���ת��Ϊdouble��������ͳ�ƽ��
			}
		}
		return "��"+type+balan+"Ԫ";						//����ͳ�ƽ��
	}
	//����¼���ļ��е�һ����Ϣת��Ϊһ���˻�����
	public static Account tramslate(String target) {
		//�÷������Խ��ļ��е�һ����¼��ȡ������ŵ�Account������
		String str = target;										//����¼�˸�����һ���ַ�������
		if(str==null||str=="")										//�жϱ����Ƿ�Ϊ�գ����Ϊ�ս���
			return null;
		String temp = str.replaceAll("[\\D]{2,4}:", "\t");			//ȥ����Ϣtarget�е��ֶ����ͱ�����
		String sar[] = temp.split("[\\s]+");						//���ַ����ָ�Ϊ�������Ե���
		SimpleDateFormat sdf = new 
				SimpleDateFormat("yyyy-MM-dd|HH:mm:ss");			//SimpleDateFormat�����������ַ���ת��Ϊ����
		Date date = new Date();										//���ڶ���
		try {
			date = sdf.parse(sar[6]);								//����¼�б�ʾ���ڵ��ַ�������ת��Ϊ����
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(sar[3].equals("���ÿ�")){								//�ж��˻�����
			CreditAccount  account = new CreditAccount();			//�����˻�
			account.setAid(sar[1]);									//�����˻���
			account.setUername(sar[2]);								//�����û���
			account.setBalance(Double.parseDouble(sar[5].trim()));	//�������
			if(sar[4].equals("A��"))								//�������õȼ�
				account.setType(lineOfCredit.A��);
			else if(sar[4].equals("B��"))
				account.setType(lineOfCredit.B��);
			else if(sar[4].equals("C��"))
				account.setType(lineOfCredit.C��);
			else 
				account.setType(lineOfCredit.D��);
			account.setDate(date);									//��������
			return account;											//���ظ��˻�
		}
		else if(sar[3].equals("�ֽ�")){							//�ж��˻�����
			CrashAccount account = new CrashAccount();				//�����û�����
			account.setAid(sar[1]);									//�����˻���
			account.setUername(sar[2]);								//�����˻���
			account.setBalance(Double.parseDouble(sar[5].trim()));	//�������
			if(sar[4].equals("���"))								//���ÿ�����
				account.setType(TypeOfCard.��ǿ�);
			else if(sar[4].equals("����"))
				account.setType(TypeOfCard.���ʿ�);
			else 
				account.setType(TypeOfCard.��ƿ�);
			account.setDate(date);									//��������
			return account;											//���ظ��˻�
		}
		return null;
	}
}
