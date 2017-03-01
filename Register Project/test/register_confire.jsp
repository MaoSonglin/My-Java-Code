<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>确认</title>
</head>
<body>
<%!
	public String codeToString(String str){
		
		String s = str;
		try{
			byte tempB[] = s.getBytes("ISO-8859-1");
			s = new String(tempB);
			return s;
		}catch(Exception e){
			return s;
		}
	}
%>
<%request.setCharacterEncoding("UTF-8"); %>
<table align="center">
	<tr>
		<td>用户名</td><td>${param.username }</td>
	</tr>
	<tr>
		<td>性别</td>
		<td>
			<c:if test="${param.sex==false }">男</c:if>
			<c:if test="${param.sex==true }">女</c:if>
		</td>
	</tr>
	<tr>
		<td>学历</td><td>${param.degree }</td>
	</tr>
	<tr>
		<td>备注<td><td align="left"> ${param.comment }</td>
</table>
<form name="form2" action="success.jsp" method="post" >
	<input type="hidden" name ="username" value="${param.username }">
	<input type="hidden" name="userpassword" value="${param.userpassword }">
	<input type="hidden" name="sex" value="${param.sex }">
	<input type="hidden" name="degree" value="${param.degree }">
	<input type="hidden" name="comment" value="${param.comment }">
<table align="center">
	<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>
		<input type="button" name="action1" value="确定" onclick="this.form.action='success.jsp';this.form.submit()">
		<input type="button" name="action2" value="修改" onclick="this.form.action='re_register.jsp';this.form.submit()">
		</td>
	</tr>
</table>
</form>
</body>
</html>