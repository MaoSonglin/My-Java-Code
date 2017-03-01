package bean;
import java.sql.*;
import java.util.*;
public class UserBean {
	private String username;
	private String password;
	private String sex;
	private String degree;
	private String comment;
	
	public String getUsername(){return username;}
	public String getPassword(){return password;}
	public String getSex(){return sex;}
	public String getDegree(){return degree;}
	public String getComment(){return comment;}
	
	public void setUsername(String username){this.username=username;}
	public void setPassword(String password){this.password = password;}
	public void setSex(String sex){this.sex = sex;}
	public void setDegree(String degree){this.degree= degree;}
	public void setComment(String comment){this.comment=comment;}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList findAllUser(){
		ArrayList userlist = new ArrayList();
		Connection con = null;							//连接对象
		Statement st = null;							//语句对象
		ResultSet rs = null;							//结果集对象
		String sql = "select * from register_table";	//查询语句
		String url = "jdbc:Access:/D:/Users/acer-pc/Documents/databaseone.accdb";	//数据库URL
		
		try{
			Class.forName("com.hxtt.sql.access.AccessDriver");
			con = DriverManager.getConnection(url);
			st = con.createStatement();
			rs =st.executeQuery(sql);
			while(rs.next()){
				UserBean user = new UserBean();
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setSex(rs.getString(3));
				user.setDegree(rs.getString(4));
				user.setComment(rs.getString(5));
				userlist.add(user);
			}
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}catch(SQLException el){
			System.out.println("数据库连接异常："+el.getMessage());
		}finally{
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return userlist;
	}
}
