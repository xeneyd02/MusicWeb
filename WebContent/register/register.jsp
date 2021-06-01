<%@ page language="Java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <link href="css/register.css" rel="stylesheet" type="text/css" /> 
    <base href="<%=basePath%>">    
    <title>注册界面</title>        
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
 </head>
 <body>
<div class="main-login">
<div class="login-content">	
<h2>用户注册</h2>
<form action="register/userServlet" method="post">  
  
     <div class="login-info"><span class="user" style="line-height: 30px; font-size: 14px;" border:1px>账号</span>
	<input name="username" id="username" type="text"  value="" class="login-input"/>
	</div>
    <div class="login-info">
	<span class="pwd"  style="line-height: 30px; font-size: 12px;" border:1px>密 码</span>
	<input name="password" id="password" type="password"  value="" class="login-input"/>
	</div>
    <div class="login-info">
	<span class="apwd"  style="line-height:30px; font-size: 10px;" border:1px >重复密码</span>
	<input name="again_pasword" id="password" type="password"  value="" class="login-input"/>
	</div>
    
    <div class="login-ope">
	<input style="margin:1px 10px 0px 2px; float:left;" name="" type="checkbox" value="" checked="checked" /><span>记住密码
	<%
	Object msg=request.getAttribute("message");
	if(msg!=null){
		%>
		<font color="red"><%= msg %></font>
		<%
	}
	%>
	</span>
	</div>
    <div class="login-oper" >	<input name="" type="submit" value="注 册" class="login-btn"/></div>
    </form>
    </div>
 
</div>
 <canvas id="canvas"></canvas>
<script type="text/javascript" src="register/js/dhtx.js"></script>
  
</body>
</html>