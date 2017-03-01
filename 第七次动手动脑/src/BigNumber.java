import java.io.*;
public class BigNumber {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BigNumber a;
		System.out.println("����һ����������");
		a = inputInteger();
		System.out.println("������һ����������");
		int b[] = inputArray();
		System.out.println("�������ĺ��ǣ�");
		display(a.add(b));
		
	}
	public static int[] inputArray()throws IOException{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		String number = input.readLine();
		
		char temp[] = number.toCharArray();
		int array[] = new int[temp.length];
		for(int i=0; i<temp.length; i++){
			if(temp[i] < '0' || temp[i] > '9'){
				System.out.println("�������");
				System.exit(1);
			}
			array[i] = temp[i]-'0';
		}
		return array;
	}
	public static BigNumber inputInteger()throws IOException{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		String number = input.readLine();
		
		char temp[] = number.toCharArray();
		int array[] = new int[temp.length];
		for(int i=0; i<temp.length; i++){
			if(temp[i] < '0' || temp[i] > '9'){
				System.out.println("�������");
				System.exit(1);
			}
			array[i] = temp[i]-'0';
		}
		BigNumber a = new BigNumber(array);
		return a;
	}
	public static void display(int[] a){
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i]);
		System.out.println();
	}
	public BigNumber(){}
	public BigNumber(int[] array){
		for(int i=0;i < array.length && i < this.array.length;i++){
			this.array[i] = array[i];
			len++;
		}
	}
	public void display(){
		for(int i = 0; i < len;i++){
			System.out.print(array[i]);
		}
	}
	public void setIneger(int[] array){
		len=0;
		for(int i=0; i < this.array.length && i < array.length; i++){
			this.array[i] = array[i];
			len++;
		}
		
	}
	public int[] getInteger(){return this.array;}
	public int getLength(){return this.len;}
	public int[] add(int[] addend){
		int firstlen = len;//��һ�������ĳ��ȡ�
		int secondlen = (int) addend.length;//�ڶ��������ĳ��ȡ�
		int gap = Math.abs(firstlen-secondlen);//���������Ȳ
		int thirdlen = firstlen > secondlen? firstlen:secondlen;
		int result[] = new int[thirdlen+1];		//��ӹ���
		int temp=0; //��λ����
		for(int i = thirdlen-1; i >=gap;i--){
			if(firstlen < secondlen){
				result[i+1] = (array[i-gap]+addend[i])%10 +temp;
				temp = (array[i-gap]+addend[i])/10;
			}else{
				result[i+1] = (array[i]+addend[i-gap])%10 +temp;
				temp = (array[i]+addend[i-gap])/10;
			}
		}
		int j = 1;
		do{
			if(firstlen < secondlen){
				result[j] = addend[j-1];
			}else if(firstlen > secondlen){
				result[j] = array[j-1];
			}j++;
		}while(j < gap);
		if(temp != 0){
			result[0] = temp;
		}else{
			int s[] = new int[thirdlen];
			for(int i=0; i < thirdlen; i++)
				s[i] = result[i+1];
			return s;
		}
		return result;
	}
	
	private int array[] = new int[20];
	private int len = 0;
}
