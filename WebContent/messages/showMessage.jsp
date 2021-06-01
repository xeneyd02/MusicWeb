<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
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
<body >
 <%  
   Vector<String> v=(Vector)application.getAttribute("Mess");
  out.print("<table border=2>");
  out.print("<tr>");
  out.print("<td bagcolor=cyan>"+"留言者姓名"+"</td>");
 
  out.print("<td bagcolor=cyan>"+"留言者内容"+"</td>");
  out.print("<td bagcolor=cyan>"+"留言者时间"+"</td>");
   for(int i=0;i<v.size();i++){
	   out.print("<tr>");
	   String message=v.elementAt(i);
	  /*  byte bb[]=message.getBytes("UTF-8");
	   message=new String(bb); */
	   String a[]=message.split("#");
	   out.print("<tr>");
	   int number=a.length-1;
	   for(int k=0;k<a.length;k++){
		   if(k<number&&k>0){
			   out.print("<td><textarea rows=3 cols=12 >"+a[k]+"</textarea></td>");
		   }
			   else
				   out.print("<td bgcolor=cyan>"+a[k]+"</td>");
		   
		   }
		   out.print("<tr>");
	   }
	   out.print("</table>");
	   %>
   <a href="messages/submit.jsp">返回留言板</a>

 
  
</body>
</html>