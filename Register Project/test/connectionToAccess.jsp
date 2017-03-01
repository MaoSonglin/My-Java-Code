<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Connection con=null;
Statement sql = null;
ResultSet rs = null;
try{
	//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
	Class.forName("com.hxtt.sql.access.AccessDriver");
	con=DriverManager.getConnection("jdbc:Access:/D:/Users/acer-pc/Documents/databaseone.accdb");
	sql=con.createStatement();
	rs = sql.executeQuery("select * from register_table");
	out.print("<table border style='font-size:10xp'>");
	out.print("<tr><td colspan=9 align=center>用户数据</td></tr>");
	out.print("<tr>");
		out.print("<td width=60>用户名</td>");
		out.print("<td width=50>密码</td>");
		out.print("<td width=40>性别</td>");
		out.print("<td width=40>学历</td>");
		out.print("<td width=100>备注</td>");
	out.print("</tr>");
	while(rs.next()){
		out.print("<tr>");
			out.print("<td>"+rs.getString(1)+"</td>");
			out.print("<td>"+rs.getString(2)+"</td>");
			out.print("<td>"+rs.getString(3)+"</td>");
			out.print("<td>"+rs.getString(4)+"</td>");
			out.print("<td>"+rs.getString(5)+"</td>");
		out.print("</tr>");
	}
	out.print("</table>");
	con.close();
}catch(SQLException e){
	out.print(e);
}
%>
</body>
</html>