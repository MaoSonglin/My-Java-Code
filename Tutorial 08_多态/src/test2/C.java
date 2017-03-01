package test2;
class A{
	public void func1(){
		System.out.println("A func is calling.");
	}
	public void func2(){
		func1();
	}
}
class B extends A{
	public void func1(){
		System.out.println("B func1 is calling.");
	}
	public void func3(){
		System.out.println("B func3 is calling.");
	}
}
public class C {
	public static void main(String[] args){
		B b = new B();
		A a = b;
		C c = new C();
		c.callA(a);
		c.callA(new B());
	}
	public void callA(A a){
		a.func1();
		a.func2();
	}
}
