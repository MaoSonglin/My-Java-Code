package dome1;
import java.io.*;
//Point3D 继承point2D
public class Point3D extends Point2D{

	public static void main(String[] args)throws IOException{
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(read);
		
		//定义输入一个二维点
		System.out.println("输入一个二维点：");
		int a = Integer.parseInt(input.readLine().trim());
		int b = Integer.parseInt(input.readLine().trim());
		Point2D p2d1 = new Point2D(a,b);
		
		//定义输入一个二维点
		System.out.println("输入一个二维点：");
		int x = Integer.parseInt(input.readLine().trim());
		int y = Integer.parseInt(input.readLine().trim());
		Point2D p2d2 = new Point2D(x,y);
		
		//计算输出两个点之间的距离
		p2d1.print();
		System.out.print("到");
		p2d2.print();
		System.out.println("的距离是："+p2d1.lengthTo(p2d2));
		
		int z;
		//输入一个三维点
		System.out.println("输入一个三维点");
		x = Integer.parseInt(input.readLine().trim());
		y = Integer.parseInt(input.readLine().trim());
		z = Integer.parseInt(input.readLine().trim());
		Point3D p3d1 = new Point3D(x,y,z);
		
		//输入另一个三维点
		System.out.println("输入一个三维点");
		x = Integer.parseInt(input.readLine().trim());
		y = Integer.parseInt(input.readLine().trim());
		z = Integer.parseInt(input.readLine().trim());
		Point3D p3d2 = new Point3D(x,y,z);
		
		//计算输出两个点之间的距离
		p3d1.print();
		System.out.print("到");
		p3d2.print();
		System.out.println("的距离是："+p3d1.lengthTo(p3d2));
	}
	public Point3D() {
		// TODO Auto-generated constructor stub
	}
	public Point3D(int a,int b,int c){
		x = a;
		y = b;
		z = c;
	}
	public Point3D(Point2D p,int z){
		x = p.x;
		y = p.y;
		this.z = z;
	}
	
	public int getZ(){return z;}
	public void setZ(int c){z = c;}
	
	public void print(){//输入一个点
		System.out.print("("+x+","+y+","+z+")");
	}
	public void offset(int a, int b,int c){
		x += a;
		y += b;
		z += c;
	}
	public double lengthTo(Point3D p){
		//空间汇总计算两个点的距离
		double len = 0;
		double len1 = (p.x-x)*(p.x-x);
		double len2 = (p.y-y)*(p.y-y);
		double len3 = (p.z-z)*(p.z-z);
		len = Math.sqrt(len1+len2+len3);
		return len;
	}
	private int z;
}
