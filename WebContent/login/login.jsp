<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/" %>"/>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
<script src="login/js/jquery-1.3.2.js"></script>

<script type="text/javascript" src="login/js/login.js"></script>

<link href="login/css/login.css" rel="stylesheet" type="text/css" /> 

</head>
<body>
<div class="main-login">
<div class="login-content">	
<h2>用户登录</h2>
<form action="userServlet" method="post">  
  
    <div class="login-info"><span class="user" >&nbsp;</span>
	<input name="username" id="username" type="text"  value="" class="login-input"/>
	</div>
    <div class="login-info">
	<span class="pwd">&nbsp;</span>
	<input name="password" id="password" type="password"  value="" class="login-input"/>
	</div>
    <div class="login-in">
    <input name="validateCode" id="captcha" type="captcha"  value="" class="login-cap"/>
    <span class="cap"><img id="validateCode_img" src="login/validateCode" />
    <%
    Object msg=request.getAttribute("message");
    if(msg!=null){
    	%>
    	<font color="red"><%= msg %></font>
    	<%
    }
    
    %>
    </span></div>
    
    <div class="login-oper">
	<input style="margin:1px 10px 0px 2px; float:left;" name="" type="checkbox" value="" checked="checked" /><span>记住密码</span>
	</div>
    <div class="login-oper">
	<input name="" type="submit" value="登 录"  class="login-btn"/>
	<input type="submit"value="注册" formaction="../register/register.html"class="login-reset"/>
	</div>
  </form>
    </div>
 
</div>  
 <canvas id="canvas"></canvas>
<script type="text/javascript" src="login/js/dhtx.js"></script>


</body>
</html>