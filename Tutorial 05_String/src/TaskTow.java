
public class TaskTow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = new String("You are a student");
		String s2 = new String("How are you");
		if(s1.equals(s2))
			System.out.println("s1��s2��ͬ");
		else
			System.out.println("s1��s2����ͬ");
		
		String s3 = new String("22030219851022024");
		if(s3.substring(0,6).equals("220302"))
			System.out.println("����ʡ�����֤");
		
		int position = 0;
		String path="C:\\java\\jsp\\A.java";
		
		position = path.lastIndexOf("\\");
		System.out.println(path+"��������\\��λ���ǣ�"+position);
		
		String fileName=path.substring(12);
		System.out.println(path+"�к��е��ļ�����"+fileName);
		
		String s6 = new String("100");
		String s7 = new String("123.678");
		int n1 = Integer.parseInt(s6);
		double n2 = Double.parseDouble(s7);
		
		double m = n1+n2;
		System.out.println(m);
		
		String s8 = String.valueOf(m);
		position = s8.indexOf(".");
		String temp = s8.substring(position+1);
		System.out.println("����"+m+"��"+temp.length()+"λС��");
		String s9 = new String("ABCDEF");
		char a[] = s9.toCharArray();
		for(int i = a.length-1; i >= 0; i--)
			System.out.print(" "+a[i]);
	}

}
