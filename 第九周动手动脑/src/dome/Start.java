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
		System.out.println("调用了父类的构造方法！");
	}
	public void doSomething(){
		System.out.println("调用了父类的成员方法！");
	}
}

class DerivedClass extends SuperClass{
	public DerivedClass(){
		System.out.println("调用了子类的构造方法！");
	}
	public void doSomething(){
		super.doSomething();
		System.out.println("调用了子类的成员变量！");
	}
}