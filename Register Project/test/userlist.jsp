<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示所有用户</title>
</head>
<body>
<table align="center" border="1" cellspacing="0" cellpadding="0" width=80%>
	<tr>
		<td>用户名</td><td>密码</td><td>性别</td><td>学位</td><td>备注</td>
	</tr>
	<c:forEach items="${userlist }" var = "cur" varStatus="curStatus">
		<tr>
			<td>cur.username</td><td>cur.password</td><td>user.sex</td><td>user.degree</td><td>user.comment</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>