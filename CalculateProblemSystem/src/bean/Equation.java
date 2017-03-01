package bean;

public class Equation {

	private int firstOperand,secondOperand;
	private char operator;
	private String result;
	
	public Equation() {
		// TODO Auto-generated constructor stub
	}

	public int getFirstOperand(){return firstOperand;}
	public int getSecondOperand(){return secondOperand;}
	public char getOperator(){return operator;}
	public String getResult(){return result;}
	public void setResult(String re){result = re;}
	public void setFirstOperand(int num){firstOperand=num;}
	public void setSecondOperand(int num){secondOperand =num;}
	public void setOperator(char ch){operator = ch;}
	
	public String toString(){
		return firstOperand+" "+operator+" "+secondOperand+" = ";
	}
	public boolean equals(Equation another){
		if(this.firstOperand==another.firstOperand&&this.secondOperand==another.secondOperand
				&&this.operator==another.operator)
			return true;
		else
			return false;
	}
	public void Calculate(){
		String re = null;
		switch(operator){
		case '+':re = (firstOperand + secondOperand)+"";break;
		case '-':re = (firstOperand - secondOperand)+"";break;
		case '*':re = (firstOperand * secondOperand)+"";break;
		case '/':
			int temp = firstOperand / secondOperand;
			if(temp * secondOperand == firstOperand)
				re = temp+"";
			else
			{
				int div = Equation.maxComDiv(firstOperand, secondOperand);
				re = (firstOperand/div)+"/"+(secondOperand/div);
			}break;
		default:re = "system error !";
		}
		result = re;
		
	}
	public static int maxComDiv(int first,int second){//求两个数的最大公约数
		int sum = 1;
		int temp =first<second? first:second;
		for(int i = 2; i <= temp;i++)
		{
			if(first%i==0&&second%i==0)
				sum = i;
		}
		return sum;
	}
	
	public static Equation createEquation(int begin,int end){
		char[] oper = {'+','-','*','/','+'};
		Equation equa = new Equation();
		int operindex =(int) (Math.random()*4);
		int first = (int)(Math.random()*(end-begin))+begin;
		int second = (int)(Math.random()*(end-begin))+begin;
		while(second==0&&operindex==3)
			second = (int)(Math.random()*(end-begin))+begin;
		equa.operator = oper[operindex];
		equa.firstOperand = first;
		equa.secondOperand= second;
		equa.Calculate();//计算结果
		return equa;
	}
}
