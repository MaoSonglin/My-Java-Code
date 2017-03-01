<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请注册</title>
<script type="text/javascript" src="on_submit.js"></script>
</head>
<body>
<%request.setCharacterEncoding("UTF-8"); %>
<form name="from1" action="register_confire.jsp" method="post" onsubmit="return on_submit(from1)">
<table align="center">
	<tr><td colspan="2"><h4 align="center">注册</h4></td></tr>
	<tr>
		<td>
			用户名
		</td>
		<td>
			<input type= "text" maxlength="12" size = "20" name = "username" value="${param.username }">
		</td>
	</tr>
	<tr>
		<td>
			密码
		</td>
		<td>
			<input type="password" maxlength="18" size = "22" name="userpassword" value="${param.userpassword }">
		</td>
	</tr>
	<tr>
		<td>
			确认密码
		</td>
		<td>
			<input type="password" maxlength="18" size="22" name="reuserpassword" value="${param.userpassword }">
		</td>
	</tr>
	<tr>
		<td>
			性别
		</td>
		<td>
			 男<input type="radio" name="sex" value="false" <c:if test="${param.sex==false}">checked="checked"</c:if>> &nbsp;&nbsp;
			 女<input type="radio" name="sex" value="true"<c:if test="${param.sex==true}">checked="checked"</c:if>>
		</td>
	</tr>
	<tr>
		<td>
			学历
		</td>
		<td>
			<select name="degree">
				<option value="专科"<c:if test="${param.degree==\"专科\" }">selected</c:if>>专科</option>
				<option value="本科"<c:if test="${param.degree==\"本科\" }">selected</c:if>>本科</option>
				<option value="研究生"<c:if test="${param.degree==\"研究生\" }">selected</c:if>>研究生</option>
				<option value="其他"<c:if test="${param.degree==\"其他\" }">selected</c:if>>其他</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>
			备注
		</td>
		<td>
			<textarea name="comment" cols="20" rows="5">${param.comment }</textarea>
		</td>
	</tr>
	<tr>
		<td></td><td><input type="submit" name="hand_in" value="提交">
		<input type="reset" name="rewrite" value="重置"></td>
	</tr>
</table>
</form>
</body>
</html>