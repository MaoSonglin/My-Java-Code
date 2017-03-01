

public class Num2Rmb
{
	private String[] hanArr = {"零" , "壹" , "贰" , "叁" , "肆" , 
		"伍" , "陆" , "柒" , "捌" , "玖"};
	private String[] unitArr = {"十" , "百" , "千","万","十万","百万"};

	

	/**
	 * 把一个四位的数字字符串变成汉字字符串
	 * @param numStr 需要被转换的四位的数字字符串
	 * @return 四位的数字字符串被转换成的汉字字符串。
	 */
	private String toHanStr(String numStr)
	{
		String result = "";
		int numLen = numStr.length();
		//依次遍历数字字符串的每一位数字
		for (int i = 0 ; i < numLen ; i++ )
		{
			//把char型数字转换成的int型数字，因为它们的ASCII码值恰好相差48
			//因此把char型数字减去48得到int型数字，例如'4'被转换成4。
			int num = numStr.charAt(i) - 48;
			//如果不是最后一位数字，而且数字不是零，则需要添加单位（千、百、十）
			if ( i != numLen - 1 && num != 0)
			{
				result += hanArr[num] + unitArr[numLen - 2 - i];
			}
			//否则不要添加单位
			else
			{
				
				//上一个数是否为“零”，不为“零”时就添加
				if(result.length()>0 && hanArr[num].equals("零") && result.charAt(result.length()-1)=='零')
					continue;
				result += hanArr[num];
			}
		}
		//只有个位数，直接返回
		if(result.length()==1)
			return result;
		
		int index=result.length()-1;
		while(result.charAt(index)=='零'){
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
		System.out.println("只支持整数（0~百万）");
		//测试把一个四位的数字字符串变成汉字字符串
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
