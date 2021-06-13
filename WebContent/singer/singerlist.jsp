<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="search2.domain.Search2" %>
     <%@ page import="Login.src.domain.User,java.util.*" %>
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
<script type="text/javascript" src=""WebContent/singer/js/jquery.js""></script>
<style> 
/*导航栏*/
#index{
	height: 175px;
	margin:auto;
	border-bottom: #39C solid 2px;
	overflow: hidde;
	background:#CCC url(singer/images/index.png) no-repeat;
	box-shadow:#39C 2px 2px 4px;
}
.button1{
	border-radius: 25px;
	position: absolute;
	top: 20px;
	left: 450px;
	height: 65px;
	width: 150px;
	background-color: #09F;
	margin: 3px;
	color: #666;
	border: 2px solid  #CCC;
	font-style: normal;
	font-size: 40px;
}
.button1:hover{
	color: #600;
	background-position: center center;
	text-decoration: blink;
}
.button2{
	border-radius: 25px;
	position: absolute;
	left: 630px;
	height: 65px;
	width: 230px;
	background-color:#09F;
	margin: 3px;
	top: 20px;
	float: none;
	color:#333;
    border: 2px solid  #CCC;
	font-style:normal;
	font-size:40px;
	text-decoration: blink;
}
.button2:hover{
	color: #600;
	background-position: center center;
	text-decoration: blink;
	}

/*超链接去下划线*/
a{
	text-decoration:none;
} 


</style>


<script type="text/javascript">
    $(function(){
 $("table").each(function(){
  $(this).find("tr:even").addClass("stripe");
 })
});
 
</script>
<style>
.stripe{
   background-color:#C1E0FF;
    width:100px;
    height:21px;
    font-size:12px;
    text-align:center;
}
</style>
</head>


<body>
<div id="index"><span></span>
  <div class="button1" align="center" ><a href="#">音乐铺</a></div>
  <div class="button2" align="center"><a href="#" >我的音乐馆</a></div>

<!-- /*使用JS实现搜索框显示默认字体*/ -->
<form action="homePage/searchServlet" method="post"> 
<input type="search" value="请输入关键词" onfocus="if(value=='请输入关键词') {value=''}" onblur="if (value=='') {value='请输入关键词'}" name="searchname" size="30" style="width:180px; height:45px; position:absolute;top:35px;left:880px" /> 

  </form>
  
 <%
    List<User> users2=(List<User>)session.getAttribute("users");
if(users2!=null&&users2.size()>0){
	for(User user:users2){
	
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
  <p><a href="../homePage/homePage,jsp" style="text-align:justify; text-decoration:blink; position:absolute;top:130px;left:480px;font-size:24px">首页</a></p>
  <p><a href="../singer/singer.jsp" style="text-align:justify; text-decoration:blink; position:absolute;top:130px;left:570px;font-size:24px">歌手</a></p>
  <p><a href="../the charts/the charts.jsp" style="text-align: justify; text-decoration: blink; position: absolute; top: 130px; left: 660px; font-size: 24px;">排行榜</a></p>
  <p><a href="#" style="text-align:justify; text-decoration:blink; position:absolute;top:130px;left:780px;font-size:24px">MV</a></p>
</div>
    
    <%
List<Search2> users=(List<Search2>)request.getAttribute("customers2");
%>
     <table width="738"  >
	<tr align="center" >
	<th width="350"><h2> 歌手 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h2></th>
	
	<th width="350"><h2> 歌曲名 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h2></th>
 
	<%
	if(users2!=null && users2.size()>0){
		%>
		<th width="350"><h2>DOWNLOAD&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h2></th>
		<%
	}else{
		
	}
	%>
	<th width="350"><h2> PLAY  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h2></th>
    
	</tr>
	

    <%
    
for(Search2 user:users){
	%>
	
	
	
	<tr id="one" align="center" >
	<td width="350"><%=user.getSongsinger() %></td>
	
	<td width="350"><%=user.getSongname() %></td>
  <%
   
if(users2!=null&&users2.size()>0){
	
	
	%>
	
	<form action="downloadServlet?songid=<%=user.getSongid() %>" method="post">

    <td><input type="submit" id="download" value="Download"/></td>
    
    </form>
	<%
	
	
}else{
	
}
%>  


	<td width="350"><a href="searchSinger/Servlet2Servlet?songid=<%=user.getSongid() %>">播放</a></td>
	</tr>

	

	<%
}
%>
    </table>
    
   
</body>
</html>