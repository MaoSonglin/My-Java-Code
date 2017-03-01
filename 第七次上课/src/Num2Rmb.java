

public class Num2Rmb
{
	private String[] hanArr = {"��" , "Ҽ" , "��" , "��" , "��" , 
		"��" , "½" , "��" , "��" , "��"};
	private String[] unitArr = {"ʮ" , "��" , "ǧ","��","ʮ��","����"};

	

	/**
	 * ��һ����λ�������ַ�����ɺ����ַ���
	 * @param numStr ��Ҫ��ת������λ�������ַ���
	 * @return ��λ�������ַ�����ת���ɵĺ����ַ�����
	 */
	private String toHanStr(String numStr)
	{
		String result = "";
		int numLen = numStr.length();
		//���α��������ַ�����ÿһλ����
		for (int i = 0 ; i < numLen ; i++ )
		{
			//��char������ת���ɵ�int�����֣���Ϊ���ǵ�ASCII��ֵǡ�����48
			//��˰�char�����ּ�ȥ48�õ�int�����֣�����'4'��ת����4��
			int num = numStr.charAt(i) - 48;
			//����������һλ���֣��������ֲ����㣬����Ҫ��ӵ�λ��ǧ���١�ʮ��
			if ( i != numLen - 1 && num != 0)
			{
				result += hanArr[num] + unitArr[numLen - 2 - i];
			}
			//����Ҫ��ӵ�λ
			else
			{
				
				//��һ�����Ƿ�Ϊ���㡱����Ϊ���㡱ʱ�����
				if(result.length()>0 && hanArr[num].equals("��") && result.charAt(result.length()-1)=='��')
					continue;
				result += hanArr[num];
			}
		}
		//ֻ�и�λ����ֱ�ӷ���
		if(result.length()==1)
			return result;
		
		int index=result.length()-1;
		while(result.charAt(index)=='��'){
			index--;
		}
		if(index!=result.length()-1)
			return result.substring(0,index+1);
		else {
			return result;
		}
	}

    public static void main(String[] args) 
    {        
		Num2Rmb nr = new Num2Rmb();
		System.out.println("ֻ֧��������0~����");
		//���԰�һ����λ�������ַ�����ɺ����ַ���
		System.out.println(nr.toHanStr("0"));
		System.out.println(nr.toHanStr("1"));
		System.out.println(nr.toHanStr("10"));
		System.out.println(nr.toHanStr("15"));
		System.out.println(nr.toHanStr("110"));
		System.out.println(nr.toHanStr("123"));
		System.out.println(nr.toHanStr("105"));
		System.out.println(nr.toHanStr("1000"));
		System.out.println(nr.toHanStr("1100"));
		System.out.println(nr.toHanStr("1110"));
		System.out.println(nr.toHanStr("1005"));
		System.out.println(nr.toHanStr("1105"));
		System.out.println(nr.toHanStr("1111"));
		System.out.println(nr.toHanStr("10000"));
		System.out.println(nr.toHanStr("10001"));
		System.out.println(nr.toHanStr("10011"));
		System.out.println(nr.toHanStr("10111"));
		System.out.println(nr.toHanStr("11111"));
		System.out.println(nr.toHanStr("11000"));
		System.out.println(nr.toHanStr("11100"));
		System.out.println(nr.toHanStr("11110"));
		System.out.println(nr.toHanStr("101110"));
		System.out.println(nr.toHanStr("1001110"));
		
    }
}
