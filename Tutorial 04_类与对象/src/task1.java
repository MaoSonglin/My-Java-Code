class StaticDemo{
	//TODO
	static int x;
	int y;
	static public int getX(){return x;}
	static public void setX(int newX){x = newX;}
	public int getY(){return y;}
	public void setY(int newY){y = newY;}
}

public class task1{
	//TODO
	@SuppressWarnings("static-access")
	public static void main(String args[]){
		System.out.println("��̬����X="+StaticDemo.getX());
		
		StaticDemo a = new StaticDemo();
		StaticDemo b = new StaticDemo();
		
		a.setX(1);
		a.setY(2);
		b.setX(3);
		b.setY(4);
		
		System.out.println("��̬����a.x="+a.getX());
		System.out.println("ʵ������a.y="+a.getY());
		System.out.println("��̬����b.x="+b.getX());
		System.out.println("ʵ������b.y="+b.getY());
		
	}
}