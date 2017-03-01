import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		if(!login(scan)){//登录是否成功
			System.out.println("登录失败！");
			scan.close();
			return;
		}else
			System.out.println("登录成功！");
		
		int choice;//操作选择标志
		boolean endtag = false;//循环结束标志
		while(!endtag){
			Frame1();
			choice  = scan.nextInt();
			switch(choice){
			case 1:addInformation(scan);break;//录入信息
			case 2:deleteInformation(scan);break;//删除信息
			case 3:examInformation(scan);break;//审核
			case 4:showInformation();break;//显示所有信息
			case 5:selectInformation(scan);break;//查询
			case 6:countInformation();break;//统计
			case 7:endtag= true;break;//退出系统
			default:System.out.println("无此操作！");
			}
		}
		
		scan.close();
	}
	
	public static void Frame1(){//显示操作界面
		System.out.println("*******************************************");
		System.out.println("        河北省重大技术征集系统");
		System.out.println("*******************************************");
		System.out.println("          1、录入技术需求信息");
		System.out.println("          2、删除技术需求信息");
		System.out.println("          3、审核技术需求信息");
		System.out.println("          4、显示技术需求信息");
		System.out.println("          5、查询技术需求信息");
		System.out.println("          6、统计技术需求信息");
		System.out.println("          7、退出技术征集系统");
		System.out.println("********************************************");
		System.out.print("              请选择：");
	}
	public static void countInformation(){//统计审核状态
		
		Information array[] = readAll();
		
		int yes = 0,no = 0,un = 0;
		for(Information s:array){
			int state = s.getInfoState();
			switch(state){
			case 0:un++;break;
			case 1:yes++;break;
			default:no++;
			}
		}
		
		System.out.println("未审核的信息共有"+un+"条！");
		System.out.println("已通过审核的信息共有"+yes+"条！");
		System.out.println("未通过审核的信息共有"+no+"条！");
	}
	public static void selectInformation(Scanner scan){//查询指定信息
		
		System.out.println("输入编号:");
		String id = scan.next();
		
		Information[] array = readAll();
		for(Information s:array){
			if(s.getInfoNumber().equals(id)){
				
				String str[] = {"未审核","通过审核","未通过审核"};
				System.out.println("编号:"+s.getInfoNumber()+"\t名称:"+s.getInfoName()+""
						+ "\t内容:"+s.getContent()+"\t资金:"+s.getInfoSum()+"\t年份:"+s.getInfoYear()
						+"\t审核状态:"+str[s.getInfoState()]);
			}
		}
	}
	public static void showInformation(){
		
		Information[] array = readAll();
		String str[] = {"未审核","通过审核","未通过审核"};
		for(int i = 0; i <array.length; i++){
			
			System.out.println("编号:"+array[i].getInfoNumber()+"\t名称:"+array[i].getInfoName()+""
					+ "\t内容:"+array[i].getContent()+"\t资金:"+array[i].getInfoSum()+"\t年份:"+array[i].getInfoYear()
					+"\t审核状态:"+str[array[i].getInfoState()]);
		}
	}
	public static void addInformation(Scanner scan){
		//天家一个跳信息
		System.out.println("输入技术名称：");
		String name = scan.next();
		System.out.println("输入技术内容：");
		String content = scan.next();
		while(content.length()>20){
			System.out.println("内容不得超过20个字，重新输入：");
			content = scan.next();
		}
		System.out.println("请输入入投资金额：");
		double maney = scan.nextDouble();
		System.out.println("请输入技术需求年份：");
		int year = scan.nextInt();
		if(year>2016)
		{
			System.err.println("年份错误！");return;
		}
		Information array[] = readAll();//读入文件中所有的信息
		int id,len;
		if(array == null){
			id = 1;
			len = 0;
		}
		else{
			len = array.length;
			id = len+1;
		}
		Information temp = new Information(id+"",name,content,maney,year);//建立新的对象
		File f = new File(infofile);
		try{//将以前的对象和新建立的对象一起写入文件中
			if(!f.exists())
				f.createNewFile();
			PrintWriter out = new PrintWriter(new FileWriter(f));
			for(int i =0; i < len; i++)
				array[i].writeToFile(out);
			temp.writeToFile(out);
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}
			
	}

	public static void deleteInformation(Scanner scan){
		
		System.out.println("输入需要删除的编号：");
		String id = scan.next();
		boolean tag = false;//删除成功标志
		Information[] array = readAll();//读入信息
		for(int i = 0; i < array.length; i++){//查找信息
			if(array[i].getInfoNumber().equals(id)){
				for(int j = i; j <array.length-1;j++){
					array[j] = array[j+1];
				}break;
			}
		}
		
		try{
			PrintWriter out = new PrintWriter(new FileWriter(infofile));
			for(int i = 0; i < array.length-1; i++){
				array[i].setInfoNumber((i+1)+"");
				array[i].writeToFile(out);
			}
			tag = true;
			out.close();
		}catch(IOException e){e.printStackTrace();}
		
		if(tag)
			System.out.println("删除成功！");
		else
			System.out.println("删除失败！");
	}
	private static String infofile="src\\TeachInformation.txt";//存放Information的文件
	private static String userinfo="src\\users.txt";//存放user的文件
	
	
	public static boolean login(Scanner scan){
		//该方法用来登录系统
		try {
			File f = new File(userinfo);//建立文件对象
			if(!f.exists())//判断存放用户的文件是否存在
			{	
				f.createNewFile();
				throw new Exception("用户文件不存在！");
			}
			BufferedReader read = new BufferedReader(new FileReader(f));//文件输入流对象
			
			String s=read.readLine();//读入文件中的内容
			read.close();//关闭文件流
			String ss[] = s.split(",");
			System.out.println("请输入用户名：");//提示用户输入
			String username = scan.next();
			System.out.println("请输入密码：");//提示用户输入密码
			String password = scan.next();
			//判断是否正确
			if(ss[0].equals(username)&&ss[1].equals(password))
				return true;
			System.out.println("用户名或密码错误!");
			System.out.println("请输入用户名：");//提示用户输入
			username = scan.next();
			System.out.println("请输入密码：");//提示用户输入密码
			password = scan.next();
			//判断是否正确
			if(ss[0].equals(username)&&ss[1].equals(password))
				return true;
			System.out.println("用户名或密码错误!");
			System.out.println("请输入用户名：");//提示用户输入
			username = scan.next();
			System.out.println("请输入密码：");//提示用户输入密码
			password = scan.next();
			//判断是否正确
			if(ss[0].equals(username)&&ss[1].equals(password))
				return true;
			else 
				throw new Exception("三次输入密码错误，用户被锁死！");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static void addInformation(Information e){
		//向文件中添加一条信息
		File f = new File(infofile);//建立文件对象
		try{
			if(!f.exists())//判断文件是否存在,若不存在，建立新的文件
				f.createNewFile();
			PrintWriter out = new PrintWriter(new FileWriter(f,true));//建立文件输出流对象
			e.writeToFile(out);//向文件中写入信息
			out.close();//关闭文件流对象
		}catch(IOException e1){
			e1.printStackTrace();
		}//异常处理
	}

	public static Information[] readAll(){
		//读入文件汇总的所用记录
		File f = new File(infofile);//文件对象
		try{
			if(!f.exists())//如果文件不存在，返回null结束此方法
			{
				System.out.println("文件不存在！");
				return null;
			}
			BufferedReader read = new BufferedReader(new FileReader(f));//文件缓冲流对象
			ArrayList<Information> list = new ArrayList<Information>();//动态数组,存放读入的对象
			String temp;//字符串表示读入的一条记录
			while((temp=read.readLine())!=null){//循环读入记录
				Information newinfo = new Information();//创建一个细信息对象
				if(!newinfo.setValue(temp))//赋值失败，返回null
				{	
					read.close();
					return null;
				}
				list.add(newinfo);//将对象放入动态数组
			}
			read.close();
			//将动态数组转化为数组
			int size = list.size();
			Information[] array= new Information[size];
			for(int i = 0; i < size; i++){
				array[i] = list.get(i);
			}
			return array;
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}

	public static void examInformation(Scanner scan){
		
		System.out.println("输入信息编号：");
		String id = scan.next();
		boolean tag = false;//是否审核标志
		Information array[] = readAll();
		for(Information s:array){
			if(s.getInfoNumber().equals(id)){
				if(s.getInfoState()==0){
					
					System.out.println("1、返回主界面\t2、通过审核\t3、退回审核");
					System.out.println("编号:"+s.getInfoNumber());
					System.out.println("名称:"+s.getInfoName());
					System.out.println("内容:"+s.getContent());
					System.out.println("投资金额:"+s.getInfoSum());
					System.out.println("技术年份:"+s.getInfoYear());
					int choice = scan.nextInt();
					if(choice == 1)return;
					else if(choice == 2)s.setInfoState(1);
					else s.setInfoState(2);
					tag = true;
					break;
				}else if(s.getInfoState()==1){
					System.out.println("该信息已通过审核！");
				}
				else
					System.out.println("该信息已被退回！");
			}
		}
		
		if(tag)
		try {//将修改过后的信息输入到文件中.
			PrintWriter out = new PrintWriter(new FileWriter(infofile));
			for(Information s:array){
				s.writeToFile(out);
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
