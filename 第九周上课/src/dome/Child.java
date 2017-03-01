package dome;

public class Child extends Parent {

	public Child() {
		// TODO Auto-generated constructor stub
		System.out.println("Child Created.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child child = new Child();
		System.out.println(child);
		System.out.println(new A());
	}

}
class A{}