package dome1;
import java.io.*;
//Point3D �̳�point2D
public class Point3D extends Point2D{

	public static void main(String[] args)throws IOException{
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(read);
		
		//��������һ����ά��
		System.out.println("����һ����ά�㣺");
		int a = Integer.parseInt(input.readLine().trim());
		int b = Integer.parseInt(input.readLine().trim());
		Point2D p2d1 = new Point2D(a,b);
		
		//��������һ����ά��
		System.out.println("����һ����ά�㣺");
		int x = Integer.parseInt(input.readLine().trim());
		int y = Integer.parseInt(input.readLine().trim());
		Point2D p2d2 = new Point2D(x,y);
		
		//�������������֮��ľ���
		p2d1.print();
		System.out.print("��");
		p2d2.print();
		System.out.println("�ľ����ǣ�"+p2d1.lengthTo(p2d2));
		
		int z;
		//����һ����ά��
		System.out.println("����һ����ά��");
		x = Integer.parseInt(input.readLine().trim());
		y = Integer.parseInt(input.readLine().trim());
		z = Integer.parseInt(input.readLine().trim());
		Point3D p3d1 = new Point3D(x,y,z);
		
		//������һ����ά��
		System.out.println("����һ����ά��");
		x = Integer.parseInt(input.readLine().trim());
		y = Integer.parseInt(input.readLine().trim());
		z = Integer.parseInt(input.readLine().trim());
		Point3D p3d2 = new Point3D(x,y,z);
		
		//�������������֮��ľ���
		p3d1.print();
		System.out.print("��");
		p3d2.print();
		System.out.println("�ľ����ǣ�"+p3d1.lengthTo(p3d2));
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
	
	public void print(){//����һ����
		System.out.print("("+x+","+y+","+z+")");
	}
	public void offset(int a, int b,int c){
		x += a;
		y += b;
		z += c;
	}
	public double lengthTo(Point3D p){
		//�ռ���ܼ���������ľ���
		double len = 0;
		double len1 = (p.x-x)*(p.x-x);
		double len2 = (p.y-y)*(p.y-y);
		double len3 = (p.z-z)*(p.z-z);
		len = Math.sqrt(len1+len2+len3);
		return len;
	}
	private int z;
}
