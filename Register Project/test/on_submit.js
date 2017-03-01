/**
 * 
 */
function on_submit(form){
	if(form.username.value.length < 6){
		alert("用户名不能小于六位！");
		form.username.focus();
		return false;
	}
	if(form.userpassword.value.length < 6){
		alert("密码不能小于六位！");
		form.userpassword.focus();
		return false;
	}
	if(form.reuserpassword.value != form.userpassword.value){
		alert("两次输入密码不同！");
		form.reuserpassword.focus();
		return false;
	}
	if(form.sex.value!="男"&&form.sex.value!="女"){
		alert("性别错误！");
		form.sex.focus();
		return false;
	}
	if(form.degree.value!="专科" && form.degree.value!="本科"&&form.degree.value!="研究生"&&form.degree.value!="其他"){
		alert("学历错误！");
		form.sex.focus();
		return false;
	}
	return true;
}