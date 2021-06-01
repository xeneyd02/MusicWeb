<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/" %>"/>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<!--<script type="text/javascript" src=""></script><link href="" type="text/css" rel="stylesheet" />-->
</head>
<body>
 <%! Vector<String> v=new Vector<String>();
     int i=0;
     ServletContext application;
     synchronized  void sendMessage(String s){
    	 application=getServletContext();
    	 v.add(s);
    	 application.setAttribute("Mess",v);
    	 
     }
     %>
<%
String name=request.getParameter("peopleName");
String message=request.getParameter("messages");
if(name==null)
	name="guest"+(int)(Math.random()*1000);
if(message==null)
	message="无信息";
SimpleDateFormat matter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String time=matter.format(new Date());
String s=name+"#"+message+"#"+time;
sendMessage(s);
out.print("你的消息已经提交");
%>     
<a href="messages/submit.jsp">返回留言板</a>
<a href="messages/showMessage.jsp">查看留言板</a>



</body>
</html>