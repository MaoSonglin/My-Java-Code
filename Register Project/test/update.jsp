<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="on_submit.js"></script>
<title>修改记录</title>
</head>
<body>
<%
Connection con= null;
Statement st = null;
ResultSet rs = null;
String user = new String(request.getParameter("user").getBytes("ISO-8859-1"));
out.print("<h4>"+user+"</h4>");
String username="";
String userpassword="";
String sex="";
String degree="";
String comment="";
try{
	con = DriverManager.getConnection("jdbc:Access:/D:/Users/acer-pc/Documents/databaseone.accdb");
	st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rs = st.executeQuery("select * from register_table where 用户名="+user);
	rs.next();
}catch(SQLException e){
	e.printStackTrace();
}
//out.print(username+" 密码：  "+userpassword+"  "+sex+"  "+degree+"  "+comment);
%>
<form action="update2.jsp" name="form1" onsubmit="return on_submit(form1)" method="post">
<table border="1" width="80%" height="40" align="center">
<tr>
	<td colspan=2 align="center"><font size=30>修改用户资料</font></td>
</tr>
<tr>
	<td width="40%">用户名</td><td><input type="text" name="username" value="<%=rs.getString(1)%>"></td>
</tr>
<tr>
	<td>密码</td><td><input type="text" name="userpassword" value="<%=rs.getString(2)%>"></td>
</tr>
<tr>
	<td>性别</td><td><input type="text" name="sex" value="<%=rs.getString(3)%>"></td>
</tr>
<tr>
	<td>学历</td><td><input type="text" name="degree" value="<%=rs.getString(4)%>"></td>
</tr>
<tr>
	<td>备注</td><td><textarea name="comment"><%=rs.getString(5) %>></textarea>
</tr>
<tr>
	<td colspan=2 align="center"><input type="submit" value="提交"><input type="reset" value="重置"></td>
</tr>
</table>
<input type="hidden" name="id" value=user>
</form>
</body>
</html>