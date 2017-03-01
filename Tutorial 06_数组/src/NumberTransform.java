import javax.swing.JOptionPane;
public class NumberTransform {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberTransform read = new NumberTransform();
		String number1 = JOptionPane.showInputDialog(null,"请输入一个正整数");
		JOptionPane.showMessageDialog(null, read.readInteger(number1));
		String number2 = JOptionPane.showInputDialog(null,"请输入一个小数表示的金额");
		JOptionPane.showMessageDialog(null, read.readMoney(number2));
	}
	private String unit[] = {"","十","百","千","万","十","百","千"};
	private String number[] = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
	
	String readInteger(String beform){
		String result = "";
		
		boolean last = false;//上一位是否为“零”
		int mun;             // 字符串中的数字
		for(short i = 0; i < beform.length(); i++){
			mun = beform.charAt(i)-'0';//将数字字符转化成数字
			if(!(mun <= 9 || mun >= 0))//如果出现非数字字符，返回false，结束程序
				return "false";
			if(mun != 0){             //如果该位上的数字不为零
				result = result+number[mun]+unit[beform.length()-i-1];
				last = false;         //加上对应的单位和汉字并将last值赋为false表示该位上的数字不为零
			}
			//如果该位上的数字为零而且上一位数字不为零
			else if(mun == 0 && last == false){
				//如果是万位上的数字，加“万”不加“零”
				if(unit[beform.length()-1-i].equals("万"))
					result += unit[beform.length()-i-1];
				//如果是其他位上的数字，加“零”不加“万”，并将last的值赋为true，表示这位上的数字为零
				else{
					result = result+number[mun];
					last=true;
				}
			}
			//如果该位上的数字是零，而且是万位上的数字，加上单位“万”
			else if(mun == 0 && unit[beform.length()-1-i].equals("万"))
			{
				if(result.charAt(result.length()-1)=='零'){
					result = result.substring(0,result.length()-1) + "万";
					last = true;
				}else
					result += unit[beform.length()-i-1];
			}
			//如果该位上的数字是零且上一位数字也是零，什么也不做。
		}
		//如果读取的字符串中，最后一个汉字是“零”，返回零之前的部分
		if(result.charAt(result.length()-1) == '零')
			return result.substring(0,result.length()-1);
		return result;
	}
	
	String readMoney(String money){
		String result = "";
		int index = money.indexOf(".");//找到小数点“.”
		if(index == -1)//如果没有小数点，直接调用读整数的方法加上单位“元”
			return readInteger(money) + "元";
		//取出小数部分和整数部分
		String integerPart = money.substring(0, index);
		String decimalPart = money.substring(index+1);
		//整数部分调用读整数的方法读
		result += readInteger(integerPart);
		if(result.equals(""))
			result+="零";
		result += "元";
		//声明表示钱的单位数组
		String jf[] = {"角","分"};
		int num;
		for(int i = 0; i < decimalPart.length() && i < 2; i++){
			num = decimalPart.charAt(i) - '0';//取出数字
			if(!(num >= 0 && num <= 9))//如果不是数字字符返回false
				return "false";
			if(num!=0)//如果不是零，加上数字和单位。
				result += (number[num] + jf[i]);
		}
		return result;
	}
}
