import java.util.StringTokenizer;

//给文件中定义数据结构
public class Information {

	//无参数的构造方法
	public Information() {
		// TODO Auto-generated constructor stub
		infostate = 0;
	}
	//带参数的构造方法
	public Information(String id,String name,String content,double maney,int year)
	{
		infonumber = id;
		infoname = name;
		infocontent = content;
		infosum = maney;
		infoyear = year;
		infostate = 0;
	}
	private String infonumber;//信息编号
	private String infoname;//信息名称
	private String infocontent;//信息内容
	private double infosum;//投资金额
	private int infostate;//审核状态
	private int infoyear;//信息申请年号
	
	//get方法
	public String getInfoNumber(){return infonumber;}
	public String getInfoName(){return infoname;}
	public String getContent(){return infocontent;}
	public double getInfoSum(){return infosum;}
	public int getInfoState(){return infostate;}
	public int getInfoYear(){return infoyear;}
	
	//set方法
	public void setInfoNumber(String id){infonumber = id;}
	public void setInfoName(String name){infoname = name;}
	public void setInfoContent(String content){infocontent = content;}
	public void setInfoSum(double sum){infosum = sum;}
	public void setInfoState(int state){infostate = state;}
	public void setInfoYear(int year){infoyear = year;}
	
	public String toString(){//将信息的属性连接成为一条记录，方便写到文件中
		String s = infonumber+","+infoname+","+infocontent+","+infosum+","+infostate+","+infoyear;
		return s;
	}
	
	public boolean setValue(String target){//将文件中的一条记录转化为一个信息对象
		
		StringTokenizer token = new StringTokenizer(target);//构造解析器
		try{//为信息的属性复制
			infonumber = token.nextToken();
			infoname = token.nextToken();
			infocontent = token.nextToken();
			infosum = Double.parseDouble(token.nextToken());
			infostate = Integer.parseInt(token.nextToken());
			infoyear = Integer.parseInt(token.nextToken());
			return true;
		}catch(Exception e){//异常处理
			e.printStackTrace();
			return false;
		}
	}
	
	public void writeToFile(java.io.PrintWriter out){
//		out.println(this.toString());
		out.printf("%4s %-8s %-20s %10.2f %-4d %4d\r\n", infonumber,infoname,
				infocontent,infosum,infostate,infoyear);
	}
}
