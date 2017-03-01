
public class TaskThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//初始化一个字符串
		String name = new String("My name is Networkcrazy");
		//调用String类的length()方法输出字符串的长度：
		System.out.println(name+"的长度是"+name.length());
		//调用String类的charAt()方法得到字符串name的第一个字符：
		System.out.println("第一个字符时："+name.charAt(0));
		//调用String类的charAt()方法得到字符串name的最后一个字符：
		System.out.println("最后一个字符时："+name.charAt(name.length()-1));
		//调用String类的substring函数，截取字符串name从位置“0”到第一个空格符前的字符：
		System.out.println("第一个单词是"+name.substring(0,name.indexOf(" ")));
		//调用String类的indexOf()函数返回crazy的位置。
		System.out.println("crazy的位置是："+(name.indexOf("crazy")+1));
	}

}
