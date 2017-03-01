<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册界面</title>
<script type="text/javascript" src="on_submit.js"></script>
</head>
<body>
<form name="from1" action="register_confire.jsp" method="post" onsubmit="return on_submit(from1)">
<table >
	<tr><td colspan="2" ><h4 align="center">注册</h4></td></tr>
	<tr>
		<td>
			用户名
		</td>
		<td>
			<input type= "text" maxlength="12" size = "20" name = "username">
		</td>
	</tr>
	<tr>
		<td>
			密码
		</td>
		<td>
			<input type="password" maxlength="18" size = "22" name="userpassword">
		</td>
	</tr>
	<tr>
		<td>
			确认密码
		</td>
		<td>
			<input type="password" maxlength="18" size="22" name="reuserpassword">
		</td>
	</tr>
	<tr>
		<td>
			性别
		</td>
		<td>
			 男<input type="radio" name = "sex" value="false" checked="checked"> &nbsp;&nbsp;
			 女<input type="radio" name="sex" value="true">
		</td>
	</tr>
	<tr>
		<td>
			学历
		</td>
		<td>
			<select name="degree">
				<option value="专科">专科</option>
				<option value="本科">本科</option>
				<option value="研究生">研究生</option>
				<option value="其他">其他</option>
			</select>
		</td>
	</tr>
	<tr>
		<td valign="top">
			备注
		</td>
		<td>
			<textarea name="comment" cols="20" rows="5">一百字以内</textarea>
		</td>
	</tr>
	<tr>
		<td></td><td><input type="submit" value="提交"><input type="reset" value="重置"></td>
	</tr>
</table>
</form>
</body>
</html>