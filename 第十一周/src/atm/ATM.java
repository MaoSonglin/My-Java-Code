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
class SumInputErrorException extends Exception{				//异常类，表示输入错误的金额
	public void printMessage(){
		System.out.println("金额输入错误！");
	}
}
@SuppressWarnings("serial")
class PasswordErrorThreeTimesException extends Exception{   //异常类，表示输入密码错误超过三次
	public PasswordErrorThreeTimesException(){
		message = "3次输入密码错误，您的银行卡被锁死！";
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
		int oper;											//操作选项
		boolean tag = true;                                 //退卡标志，false表示退出
		do{
			operationSelectFrame();//打印操作选项界面
			oper = opin.nextInt();
			switch(oper){
			case 1://操作1，取款
				int value = withdrawl();
				if(value == 1)
					System.out.println("取款成功！");
				else if(value == 0)
					System.out.println("余额不足！");
				break;
			case 2://操作2，转账
				if(transfer())
					System.out.println("转账成功！");
				else
					System.out.println("转账失败！");
				break;
			case 3://操作3，查询
				lookOut();break;
			case 4://操作4，修改密码
				if(update())
					System.out.println("修改成功！");
				else
					System.out.println("修改失败！");
				break;
			case 5:tag = false;break;//退卡
			default:System.out.println("无此操作！");
			}
			
		}while(tag);
	}
	private static String IDinput(){							//输入账号
		@SuppressWarnings("resource")
		Scanner inputid = new Scanner(System.in);
		System.out.println("请输入您的账号");
		String id_inputed = inputid.nextLine();
		return id_inputed;
	}
	private static boolean passwordInput(){						//输入密码
		@SuppressWarnings("resource")
		Scanner inputpassword = new Scanner(System.in);
		String pw = null;
		int count = 0; 											//记录输入密码次数。
		boolean tag = true;
		try{
			do{
				System.out.println("请输入您的密码，请注意遮挡!");
				pw = inputpassword.nextLine();
				count++;
				tag = true;
				if(pw.equals(password)){
					tag = false;
				}else{
					System.out.println("密码输入错误！");
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
	private static void lookOut(){								//查询
		System.out.println("您的余额为："+money);
	}
	private static boolean transfer(){							//转账
		@SuppressWarnings("resource")
		Scanner idinput = new Scanner(System.in);
		@SuppressWarnings("resource")
		Scanner idinput2 = new Scanner(System.in);
		boolean tag = true;
		do{
			System.out.println("输入转入账户");
			String userid1 = idinput.nextLine();
			System.out.println("再次输入转入账户");
			String userid2 = idinput2.nextLine();
			if(userid1.equals(userid2))
			{	
				tag = false;
			}
			else 
				System.out.println("两次输入账户不同！");
		}while(tag);
		System.out.print("请输入转账金额：");
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
		System.out.print("请输入原密码：");
		String bp = inpw.nextLine();
		
		if(!bp.equals(password)){
			System.out.println("密码错误！");
			return false;
		}
		System.out.print("输入新密码：");
		String np = inpw.nextLine();
		System.out.print("确认密码：");
		String renp = inpw.nextLine();
		
		if(!renp.equals(np)){
			System.out.println("两侧输入密码不同");
			return false;
		}
		password = np;
		return true;
	}	
	private static int withdrawl(){								//取款操作
		moneySelectFrame();
		int option = 0;										//选择要取得钱
		@SuppressWarnings("resource")
		Scanner optioninput=new Scanner(System.in);
		option = optioninput.nextInt();
		int needmoney = 0;									//需要取出的钱
		switch(option){
		case 1:needmoney = 100;break;
		case 2:needmoney = 500;break;
		case 3:needmoney = 1000;break;
		case 4:needmoney = 1500;break;
		case 5:needmoney = 2000;break;
		case 6:											//自定义取钱数量，但必须是100的倍数
			Scanner moneyinput =new Scanner(System.in);
			boolean tag = true;
			do{
				System.out.println("请输入取款金额");
				try{
					String nm = moneyinput.nextLine();	
					if(nm.equals("A"))
						throw new MyException("余额不足！");
					boolean fag = false;
					for(int i = 0; i < nm.length(); i++){//判断是否有其他字符
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
		case 7:return -1;							//输入7，退出取款
		default:System.out.println("输入错误！请输入正确选项");
		}
		if(needmoney <= money){						//取款成功返回1
			money -= needmoney;
			return 1;
		}else{										//账户中没有足够的余额，返回0
			return 0;
		}
	}
	private static void operationSelectFrame(){
		System.out.println("【取款】---------------------1");
		System.out.println("【转账】---------------------2");
		System.out.println("【查询】---------------------3");
		System.out.println("【修改密码】 -----------------4");
		System.out.println("【取卡】---------------------5");
	}
	private static void moneySelectFrame(){
		System.out.println("【100】---------------------1");
		System.out.println("【500】---------------------2");
		System.out.println("【1000】--------------------3");
		System.out.println("【1500】--------------------4");
		System.out.println("【2000】--------------------5");
		System.out.println("【其它金额 】----------------6");	
		System.out.println("【返回】 --------------------7");
	}

	
	
	@SuppressWarnings("unused")
	private static final String UERID = "11111111111";      		//用户ID
	@SuppressWarnings("unused")
	private static final String UERNAME = "***";					//用户名
	private static String password = "000000";						//用户密码 
	private static double money = (int)(Math.random()*10000)+1000;  //用户余额
	@SuppressWarnings("unused")
	private static Date date = new Date();							//操作时间
}
