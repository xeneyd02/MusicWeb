<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*,
Login.src.domain.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/" %>"/>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

<script type="text/javascript" src="scripts/jquery-1.3.2.js"></script>
<script type="text/javascript">

$(function(){
	$(".mess").change(function(){
		var content=$(this).text();
		var flag=confirm(content);
		return flag;
	});
})

</script>

<!--<script type="text/javascript" src=""></script><link href="" type="text/css" rel="stylesheet" />-->
</head>
<body>

<%
    List<User> users=(List<User>)session.getAttribute("users");
if(users!=null&&users.size()>0){
	for(User user:users){
	
	%>
	<form action="messages/messagePane.jsp" method="post" name="form">
  <p>输入你的名字：
  <input type="text" name="peopleName" value="<%=user.getName() %>" />
  <br>
  
  <p>输入你的留言：
  <br>
  <textarea rows="10" cols="36" name="messages" wrap="physical"></textarea>
  <br>
  <input type="submit" value="提交信息" name="submit" />

</form>
	 <form action="messages/showMessage.jsp" method="post" name="forml">
  <input type="submit" value="查看留言版" name="look">
</form>
	<%
	
	}
}else{
	%>
     <font id="mess">请登录</font>
	<%
}
%>





</body>
</html>