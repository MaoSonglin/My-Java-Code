import javax.swing.JOptionPane;
public class NumberTransform {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberTransform read = new NumberTransform();
		String number1 = JOptionPane.showInputDialog(null,"������һ��������");
		JOptionPane.showMessageDialog(null, read.readInteger(number1));
		String number2 = JOptionPane.showInputDialog(null,"������һ��С����ʾ�Ľ��");
		JOptionPane.showMessageDialog(null, read.readMoney(number2));
	}
	private String unit[] = {"","ʮ","��","ǧ","��","ʮ","��","ǧ"};
	private String number[] = {"��","Ҽ","��","��","��","��","½","��","��","��"};
	
	String readInteger(String beform){
		String result = "";
		
		boolean last = false;//��һλ�Ƿ�Ϊ���㡱
		int mun;             // �ַ����е�����
		for(short i = 0; i < beform.length(); i++){
			mun = beform.charAt(i)-'0';//�������ַ�ת��������
			if(!(mun <= 9 || mun >= 0))//������ַ������ַ�������false����������
				return "false";
			if(mun != 0){             //�����λ�ϵ����ֲ�Ϊ��
				result = result+number[mun]+unit[beform.length()-i-1];
				last = false;         //���϶�Ӧ�ĵ�λ�ͺ��ֲ���lastֵ��Ϊfalse��ʾ��λ�ϵ����ֲ�Ϊ��
			}
			//�����λ�ϵ�����Ϊ�������һλ���ֲ�Ϊ��
			else if(mun == 0 && last == false){
				//�������λ�ϵ����֣��ӡ��򡱲��ӡ��㡱
				if(unit[beform.length()-1-i].equals("��"))
					result += unit[beform.length()-i-1];
				//���������λ�ϵ����֣��ӡ��㡱���ӡ��򡱣�����last��ֵ��Ϊtrue����ʾ��λ�ϵ�����Ϊ��
				else{
					result = result+number[mun];
					last=true;
				}
			}
			//�����λ�ϵ��������㣬��������λ�ϵ����֣����ϵ�λ����
			else if(mun == 0 && unit[beform.length()-1-i].equals("��"))
			{
				if(result.charAt(result.length()-1)=='��'){
					result = result.substring(0,result.length()-1) + "��";
					last = true;
				}else
					result += unit[beform.length()-i-1];
			}
			//�����λ�ϵ�������������һλ����Ҳ���㣬ʲôҲ������
		}
		//�����ȡ���ַ����У����һ�������ǡ��㡱��������֮ǰ�Ĳ���
		if(result.charAt(result.length()-1) == '��')
			return result.substring(0,result.length()-1);
		return result;
	}
	
	String readMoney(String money){
		String result = "";
		int index = money.indexOf(".");//�ҵ�С���㡰.��
		if(index == -1)//���û��С���㣬ֱ�ӵ��ö������ķ������ϵ�λ��Ԫ��
			return readInteger(money) + "Ԫ";
		//ȡ��С�����ֺ���������
		String integerPart = money.substring(0, index);
		String decimalPart = money.substring(index+1);
		//�������ֵ��ö������ķ�����
		result += readInteger(integerPart);
		if(result.equals(""))
			result+="��";
		result += "Ԫ";
		//������ʾǮ�ĵ�λ����
		String jf[] = {"��","��"};
		int num;
		for(int i = 0; i < decimalPart.length() && i < 2; i++){
			num = decimalPart.charAt(i) - '0';//ȡ������
			if(!(num >= 0 && num <= 9))//������������ַ�����false
				return "false";
			if(num!=0)//��������㣬�������ֺ͵�λ��
				result += (number[num] + jf[i]);
		}
		return result;
	}
}
