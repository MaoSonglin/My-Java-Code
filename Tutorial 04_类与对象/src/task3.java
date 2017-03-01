import java.util.Scanner;
public class task3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("输入年份：");
		int year = input.nextInt();
		Exercise2010 firstYear = new Exercise2010(year);
		if(firstYear.isLeap())
			System.out.println(firstYear.getYear()+"是闰年！");
		else
			System.out.println(firstYear.getYear()+"不是闰年！");
		input.close();
	}

}

class Exercise2010{
	private int year;
	
	public Exercise2010(int y){year = y;}
	public Exercise2010(){year = 2010;}
	
	public void setYear(int y){year = y;}
	public int getYear(){return year;}
	public boolean isLeap(){
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
			return true;
		else
			return false;
	}
}