/*读入写出查询总的流水情况*/

//信1505-1班   20153144    毛松林
package test3;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Main {

	public static void main(String[] args) throws WithdrawException {

		String a[] = selectAccount("liu");				//查找一个用户
		for(String aa:a)									//输出用户信息
			System.out.println(aa+" "+aa.length());
		Account client =null;								//声明一个账户对象
		if(a[0]!=null&&a[0]!="")client=tramslate(a[0]);		//将查到的用户信息转化成对象
		else{
			System.out.println("无此用户！");
			client = new CreditAccount("12345678910","用户名",lineOfCredit.A级);
			addAccount(client);
		}
		client.deposit(5000);								//对用户进行存款操作
		client.withdraw(3000);								//对用户进行取款操作
		client.deposit(200);
		client.withdraw(3000);
		client.deposit(4000);
		client.withdraw(8000);
		client.withdraw(2000);
		client.deposit(30000);
		
		String s[] = selectRecord(client.getAid());			//查找用户的流水记录
		for(String ss:s)									//输出用户的流逝记录
			System.out.println(ss);
		
		System.out.println(calculate(client.aid,"存款"));	//统计存款额
		System.out.println(calculate(client.aid,"取款"));	//统计取款
		
	}
	public static boolean addAccount(Account a){			//将一个账户的基本信息输出到文件ClientInforTable.txt中。
		File f = new File("ClientInfoTable.txt");			//打开文件对象
		try {
			if(!f.exists())									//判断文件是否存在，如果文件不存在，建立一个新的文件
				f.createNewFile();
			FileWriter fos = new FileWriter(f,true);		//建立文件输出对象，不清空文件中原有的类容
			PrintWriter pw = new PrintWriter(fos);			//用PrintWriter对象包装FileWriter对象
			int n=a.getAccountNubmer();						//每建立一个用户表示用户数量的静态量加一
			n++;
			a.setAccountNubmer(n);
			
			pw.println(a.ToString());						//将用户的信息转化为字符串输出到文件中。
			pw.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//更新用户的数据
	public static boolean updateAccount(String target,String replaced)
	{//target为需要更新数据的账户的账号、姓名或者其他任意信息，replaced是该用户新的所有信息转化的字符串
		boolean tag = true;									//更新成功标志
		File  f = new File("ClientInfoTable.txt");				//打开文件
		try{
			RandomAccessFile arf = new RandomAccessFile(f,"rw");//建立随机流对象
			String in = null;
			while((in=arf.readLine())!=null){					//读取文件中的一行记录，判断该条记录是否为空
				byte b[] = in.getBytes("iso-8859-1");			//将该条记录转化为byte数组，用来处理中文乱码
				String temp = new String(b);					//用byte数组初始化一个用当前字符集编码的字符串
				if(temp.indexOf(target)>=0){					//判断读入的字符串中是否存在target字符串
					arf.seek(arf.getFilePointer()-b.length-2);	//如果存在target字符串，将随机流的指针移动到上次读入的开始位置
					arf.write(replaced.getBytes());		//将replaced转化为byte数组写到文件中
					//arf.writeChar('\n');
				}
			}
			arf.close();										//关闭随机流对象
		}catch(IOException e){									//异常处理
			e.printStackTrace();
			tag = false;
		}
		return tag;
	}
	public static boolean addRecord(Account a,double m){//为账户a添加一条流水信息
		
		File f =new File("BankInfoTable.txt");				//建立文件对象
		try {
			if(!f.exists())									//判断文件是否存在，如果文件不存在，建立一个新的文件。
				f.createNewFile();
			FileWriter fos = new FileWriter(f,true);		//建立文件输出的FileWriter对象，打开文件时保存文件中原有的内容
			PrintWriter pw = new PrintWriter(fos);			//用PrintWriter类包装FileWriter对象
			int n=a.getRecordNubmer();						//设置流水记录增加一条
			n++;
			a.setRecordNumber(n);;
			
			pw.println(n+"\t"+a.ToRecord(m));				//将用户的流水记录添加到文件末尾
			pw.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static String[] selectAccount(String target){
		//按照字符串target查找用户信息，target可以是任何字符串
		//查找到的内容可能输多条，所以返回类型应该是字符串数组
		String result = "";
		try {
			FileReader fr = new FileReader("ClientInfoTable.txt");	//建立文件读取对象
			BufferedReader br = new BufferedReader(fr);				//用BufferedReader类包装文件读取对象
			String s=null;
			while((s=br.readLine())!=null){						//从文件中读入一条记录并判断是否为空记录
				if(s.indexOf(target)>=0)							//判断该条记录中是否有target字符串
					result +=s+ ";";								//如果有将该条记录添加到字符串result中，并在某位添加一个“；”方便最后将记录分开
			}
			br.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return result.split(";");//用split方法将字符串分开
	}
	//查询账户流水信息
	public static String[] selectRecord(String target){
		
		String result = "";	//查询结果字符串
		String temp ="";	//中间变量字符串
		try {
			FileReader fr = new FileReader("BankInfoTable.txt");	//建立文件读入字符串变量
			BufferedReader br = new BufferedReader(fr);				//用BufferedReader封装文件读入对象
			
			do{
				result = br.readLine();//读入一条记录
				if(result!=null&&result.indexOf(target)>=0)//判断该记录是否符合条件
					temp += result+"|";						//如果符合条件，将该条记录添加到中间变量字符串中
			}while(result!=null);							//如果记录为空退出循环
			br.close();
		} catch (IOException e) {//
			e.printStackTrace();
		}
		if(temp != null)
		return temp.split("[|]");							//将中间变量分割为多条记录返回
		else 												//如果中间变量为空返回null
			return null;
	}
	//统计账户流水信息
	public static String calculate(String target,String type){
		//target表示统计的账户标志，type为统计类型（存款、取款或者超额支出）
		String array[] = selectRecord(target);				//调用读取账户流水记录的方法得到一个字符串数组
		double balan=0;										//统计的金额
		int len = array.length;								//流水记录条数
		for(int i = 0; i < len; i++)						//循环判断记录是否符合类型
		{
			String curStr = array[i];						//curStr表示记录数组中的当前记录
			if(curStr.indexOf(type)>=0){					//如果当前记录符合统计的类型
				String s = array[i].substring(69);			//截取记录中表示金额的字符串
				for(int j = 0; j < s.length(); j++)			//判断截取是否有误
					if(s.charAt(j)<'0'||s.charAt(j)>'9')
						s.replace(s.charAt(j), '\0');
				balan +=  Double.parseDouble(s.trim());		//将截取的金额字符串转化为double变量记入统计金额
			}
		}
		return "共"+type+balan+"元";						//返回统计结果
	}
	//将记录在文件中的一条信息转化为一个账户对象。
	public static Account tramslate(String target) {
		//该方法可以将文件中的一条记录提取出来存放到Account对象中
		String str = target;										//将记录了赋给另一个字符串变量
		if(str==null||str=="")										//判断变量是否为空，如果为空结束
			return null;
		String temp = str.replaceAll("[\\D]{2,4}:", "\t");			//去掉信息target中的字段名和标点符号
		String sar[] = temp.split("[\\s]+");						//将字符串分割为各个属性的相
		SimpleDateFormat sdf = new 
				SimpleDateFormat("yyyy-MM-dd|HH:mm:ss");			//SimpleDateFormat对象用来将字符串转化为日期
		Date date = new Date();										//日期对象
		try {
			date = sdf.parse(sar[6]);								//将记录中表示日期的字符串部分转化为日期
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(sar[3].equals("信用卡")){								//判断账户类型
			CreditAccount  account = new CreditAccount();			//构造账户
			account.setAid(sar[1]);									//设置账户号
			account.setUername(sar[2]);								//设置用户名
			account.setBalance(Double.parseDouble(sar[5].trim()));	//设置余额
			if(sar[4].equals("A级"))								//设置信用等级
				account.setType(lineOfCredit.A级);
			else if(sar[4].equals("B级"))
				account.setType(lineOfCredit.B级);
			else if(sar[4].equals("C级"))
				account.setType(lineOfCredit.C级);
			else 
				account.setType(lineOfCredit.D级);
			account.setDate(date);									//设置日期
			return account;											//返回该账户
		}
		else if(sar[3].equals("现金卡")){							//判断账户类型
			CrashAccount account = new CrashAccount();				//创建用户对象
			account.setAid(sar[1]);									//设置账户号
			account.setUername(sar[2]);								//设置账户名
			account.setBalance(Double.parseDouble(sar[5].trim()));	//设置余额
			if(sar[4].equals("借记"))								//设置卡类型
				account.setType(TypeOfCard.借记卡);
			else if(sar[4].equals("工资"))
				account.setType(TypeOfCard.工资卡);
			else 
				account.setType(TypeOfCard.理财卡);
			account.setDate(date);									//设置日期
			return account;											//返回该账户
		}
		return null;
	}
}
