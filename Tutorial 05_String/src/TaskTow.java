
public class TaskTow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = new String("You are a student");
		String s2 = new String("How are you");
		if(s1.equals(s2))
			System.out.println("s1与s2相同");
		else
			System.out.println("s1与s2不相同");
		
		String s3 = new String("22030219851022024");
		if(s3.substring(0,6).equals("220302"))
			System.out.println("吉林省的身份证");
		
		int position = 0;
		String path="C:\\java\\jsp\\A.java";
		
		position = path.lastIndexOf("\\");
		System.out.println(path+"中最后出现\\的位置是："+position);
		
		String fileName=path.substring(12);
		System.out.println(path+"中含有的文件名："+fileName);
		
		String s6 = new String("100");
		String s7 = new String("123.678");
		int n1 = Integer.parseInt(s6);
		double n2 = Double.parseDouble(s7);
		
		double m = n1+n2;
		System.out.println(m);
		
		String s8 = String.valueOf(m);
		position = s8.indexOf(".");
		String temp = s8.substring(position+1);
		System.out.println("数字"+m+"有"+temp.length()+"位小数");
		String s9 = new String("ABCDEF");
		char a[] = s9.toCharArray();
		for(int i = a.length-1; i >= 0; i--)
			System.out.print(" "+a[i]);
	}

}
