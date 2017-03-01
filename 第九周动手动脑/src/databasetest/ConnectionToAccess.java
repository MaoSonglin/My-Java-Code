package databasetest;
import java.sql.*;
public class ConnectionToAccess {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection con;
		Statement sql;
		ResultSet rs;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8","root","123456");
		sql = con.createStatement();
		rs = sql.executeQuery("SELECT * FROM student");
		while(rs.next()){
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getBoolean(4)+" "+rs.getDouble(5));
		}
	}

}
