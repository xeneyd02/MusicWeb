<%@ page language="Java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
  <%@ page import="search.domain.Search,Login.src.domain.User" %>
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <base href="<%=basePath%>">    
    <title>标题</title>        
     <link rel="stylesheet" type="text/css" href="searchSinger/css/ydt.css"/>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
 </head>
<body>
  <div id="index"><span></span>
  <div class="button2" onkeypress=""align="center" ><a href="#">音乐铺</a></div>
  <div class="button3" align="center"><a href="#" >我的音乐馆</a></div>

<!-- /*使用JS实现搜索框显示默认字体*/ -->
<form action="homePage/searchServlet" method="post"> 
<input type="search" value="请输入关键词" onfocus="if(value=='请输入关键词') {value=''}" onblur="if (value=='') {value='请输入关键词'}" name="searchname" size="30" style="width:180px; height:45px; position:absolute;top:35px;left:880px" /> 

  </form>
  
  <%
    List<User> users=(List<User>)session.getAttribute("users");
if(users!=null&&users.size()>0){
	for(User user:users){
	
	%>
	
	<p><a  target="_blank" style="text-align:justify; text-decoration:blink; position:absolute;top:45px;left:1070px; font-size:25px; font-family:'Times New Roman', Times, serif">当前用户：<%=user.getName() %></a></p>
	<%
	
	}
}else{
	%>
  <p><a href="<%=request.getContextPath() %>/login/login.jsp" target="_blank" style="text-align:justify; text-decoration:blink; position:absolute;top:45px;left:1070px; font-size:25px; font-family:'Times New Roman', Times, serif">登录</a></p>
  <p><a href="<%=request.getContextPath() %>/register/register.jsp"  target="_blank"style="text-align:justify; text-decoration:blink; position:absolute;top:45px;left:1150px; font-size:25px; font-family:'Times New Roman', Times, serif">注册</a></p>
	<%
}
%>  
  <p><a href="#" style="text-align:justify; text-decoration:blink; position:absolute;top:130px;left:480px;font-size:24px">首页</a></p>
  <p><a href="#" style="text-align:justify; text-decoration:blink; position:absolute;top:130px;left:570px;font-size:24px">歌手</a></p>
  <p><a href="#" style="text-align:justify; text-decoration:blink; position:absolute;top:130px;left:660px;font-size:24px">排行榜</a></p>
  <p><a href="#" style="text-align:justify; text-decoration:blink; position:absolute;top:130px;left:780px;font-size:24px">MV</a></p>
</div>
<div class="ww">
<div id="y1"><a>歌曲</a></div>
<div id="y2"><a>歌手</a></div>
<div id="y3"><a>PLAY</a></div>
</div>
<hr />
 <%
 List<Search> customers=(List<Search>)request.getAttribute("customers");

	

 String songurl="";
 String songname="";
 String songtype="";
 String songsinger="";
 String songid="";
 
 
 for(Search customer:customers){
	 songurl=customer.getSongurl();
	 songname=customer.getSongname();
	 songtype=customer.getSongtype();
	 songsinger=customer.getSongsinger();
	 songid=customer.getSongid()+"";
	 %>

<table>
  <tr>
    <td>&nbsp;<%= songname %></td>
    <td>&nbsp;<%= songsinger %></td>
    
     <%
   
if(users!=null&&users.size()>0){
	for(User user:users){
	
	%>
	
	<form action="downloadServlet?songid=<%=songid %>" method="post">

    <td>&nbsp;<input type="submit" id="download" value="Download"/></td>
    
    </form>
	<%
	
	}
}else{
}
%>  
    
    
   <!-- <td class="b1"><a href="<%=path %>/playinterface/playinterface.jsp">播放</a></td> -->  
      <td class="b1"><a href="searchSinger/Servlet2Servlet?songid=<%=songid %>">播放</a></td>
      
     
  </tr>
  
 
</table>
<%
 }

%>
<div id="footer">
<p ><a herf="#">关于我们|<a herf="#">联系方式|<a herf="#">意见建议</a></a></a></p>
</div>



</body>
</html>