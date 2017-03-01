package bean;

public class Record {
	private java.util.Date date;
	private String description;
	private double sum;
	private int mode;//支付方式，0表示现金，1表示信用卡，2表示支付宝或者微信，3表示其他支付方式
	private java.util.Date addtime;
	private String comment;
	public Record(){}
	public Record(java.util.Date date,String desc,double su,int mo,String com){
		this.date = date;
		description = desc;
		sum = su;
		mode = mo;
		comment = com;
	}
	public void setDate(java.util.Date newDate){date = newDate;}
	@SuppressWarnings("deprecation")
	public void setDate(int y,int m,int d){date = new java.util.Date(y,m,d);}
	public void setDescription(String desc){description = desc;}
	public void setSum(double newsum){sum = newsum;}
	public void setMode(int newdata){mode = newdata;}
	public void setAddtime(java.util.Date newtime){addtime = newtime;}
	public void setComment(String data){comment = data;}
	
	public java.util.Date getDate(){return date;}
	public String getDescription(){return description;}
	public double getSum(){return sum;}
	public int	getMode(){return mode;}
	public java.util.Date getAddtime(){return addtime;}
	public String getComment(){return comment;}
}
