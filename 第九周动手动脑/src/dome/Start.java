package dome;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DerivedClass test = new DerivedClass();
		test.doSomething();
	}

}

class SuperClass{
	public SuperClass(){
		System.out.println("�����˸���Ĺ��췽����");
	}
	public void doSomething(){
		System.out.println("�����˸���ĳ�Ա������");
	}
}

class DerivedClass extends SuperClass{
	public DerivedClass(){
		System.out.println("����������Ĺ��췽����");
	}
	public void doSomething(){
		super.doSomething();
		System.out.println("����������ĳ�Ա������");
	}
}