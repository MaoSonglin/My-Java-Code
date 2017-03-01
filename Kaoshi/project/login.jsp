<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登录</title>
</head>
<body>
<form name="form1" action="loginServlet" method="post" onsubmit="return on_submit(form1)">
	<table align="center">
		<tr>
			<td colspan="2" align="center"><font  color="green">欢迎登录</font></td>
		</tr>
		<tr>
			<td>用户名：</td>
			<td><input name="username" type="text" size="20"></td>
		</tr>
		<tr>
			<td>密&nbsp;&nbsp;码：</td>
			<td><input type="password" name="userpass" size="20"></td>
		</tr>
		<tr>
			<td align="right"><input type="reset" value="重置"></td>
			<td align="left"><input type="submit" value="登录"></td>
		</tr>
		<%String checkInfo = (String)request.getAttribute("checkInfo"); 
			if(checkInfo != null){
				out.print("<tr><td colspan='2' align='right'>"+checkInfo+"</td></tr>");
			}
		%>
	</table>
</form>
<script type="text/javascript">
	function on_submit(form){
		if(form.username.value.length == 0){
			alert("用户名不能为空！");
			form.username.focus();
			return false;
		}
		if(form.userpass.value.length == 0){
			alert("密码不能为空！");
			form.userpass.focus();
			return false;
		}
		if(form.username.value.length < 8){
			alert("用户名不能小于8位！");
			form.username.focus();
			return false;
		}
		if(form.username.value.length > 16){
			alert("用户名不能大于16位！");
			form.username.focus();
			return false;
		}
		if(form.userpass.value.length < 8){
			alert("密码不能小于8位！");
			form.userpass.focus();
			return false;
		}
		if(form.userpass.value.length >16){
			alert("密码不能大于16位！");
			form.userpass.focus();
			return false;
		}
		return true;
	}
</script>
</body>
</html>