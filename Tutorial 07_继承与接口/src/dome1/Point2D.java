package dome1;

public class Point2D {

	public Point2D() {
		// TODO Auto-generated constructor stub
		x = 0;
		y = 0;
	}
	public Point2D(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public void  offset(int a, int b)
	{
		x += a;
		y += b;
	}
	
	public double lengthTo(Point2D p)
	{
		double len = 0;
		double len1 = (p.x-x)*(p.x-x);
		double len2 = (p.y-y)*(p.y-y);
		len = Math.sqrt(len1+len2);
		return len;
	}

	public void print(){
		System.out.print("("+x+","+y+")");
	}
	public int getX(){return x;}
	public int getY(){return y;}
	public void setX(int a){x=a;}
	public void setY(int b){y=b;}
	protected int x,y;
}
