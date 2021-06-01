<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="java.util.*,
admin.domain.Admin,admin.domain.Songs,admin.domain.Singers,admin.domain.Users" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <script src='http://codepen.io/assets/libs/fullpage/jquery.js'></script>

<script src="js/index.js"></script>
<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
<script src="/follow.js" type="text/javascript"></script>
<head>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/" %>"/>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Iconos -->
	<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

  <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" /> 
    <style type="text/css">
    body,td,th {
	font-family: "Open Sans", Arial, Helvetica, Sans-serif, Verdana, Tahoma;
	color: #5A7EB4;
}
    </style>
<!--<script type="text/javascript" src=""></script>/<link href="" type="text/css" rel="stylesheet" />/-->
</head>
<body>

<%

String aa=null;

List<Admin> adminsroot=(List<Admin>)session.getAttribute("adminuser");
if(adminsroot!=null&&adminsroot.size()>0){

for(Admin admin:adminsroot){
	
	String adminname=admin.getAdminname();
	aa=adminname;
}
	%>
	
	
<div id="index" >
<div class="b1"><strong>后台管理系统</strong></div>

<div class="b2" action="" ><strong><a href="home.jsp">退出</a></strong></div>
<div class="b3">欢迎你，<%=aa%></div>
 
</div> 



<!-- Contenedor -->
	<ul id="accordion" class="accordion">
		<li>
			<div class="link"><i class="fa fa-paint-brush"></i>管理员管理<i class="fa fa-chevron-down"></i></div>
			<ul class="submenu">
			
				<li><a href="query.do">查询管理</a></li>
				
				<li><a href="newcustomer.jsp">添加管理</a></li>
				
			</ul>
		</li>
		<li>
			<div class="link"><i class="fa fa-code"></i>用户管理<i class="fa fa-chevron-down"></i></div>
			<ul class="submenu">
				<li><a href="query.co">查询管理</a></li>
				<li><a href="newcustomer4.jsp">添加管理</a></li>
			</ul>
		</li>
		<li>
			<div class="link"><i class="fa fa-mobile"></i>歌曲管理<i class="fa fa-chevron-down"></i></div>
			<ul class="submenu">
				<li><a href="query1.ao">查询管理</a></li>
				<li><a href="newcustomer2.jsp">添加管理</a></li>
			</ul>
		</li>
		<li><div class="link"><i class="fa fa-globe"></i>歌手管理<i class="fa fa-chevron-down"></i></div>
			<ul class="submenu">
				<li><a href="query.bo">查询管理</a></li>
				<li><a href="newcustomer3.jsp">添加管理</a></li>
			</ul>
		</li>
	</ul>
    <div class="b4"><%
List<Admin> admins=(List<Admin>)request.getAttribute("admins");
if(admins!=null&&admins.size()>0){
	%>
	<hr>
	<br><br>
	<table border="1" cellpadding="10" cellspacing="0">
	<tr>
	<th>ID</th>
	<th>管理员用户名</th>
	<th>密码</th>
	<th>修改</th>
	<th>删除</th>
	</tr>
	<%
	for(Admin admin:admins){
		%>
		<tr>
		<td><%=admin.getAdminid() %></td>
		<td><%=admin.getAdminname() %></td>
		<td><%=admin.getAdminpassword() %></td>
		<td><a href="edit.do?id=<%=admin.getAdminid() %>">UPDATE</a></td>
		<td><a href="delete.do?id=<%=admin.getAdminid() %>" class="delete">DELETE</a></td>
		</tr>
		<%
	}
	%>
	</table>
	<%
	
	
}
%>



<%
List<Songs> songs=(List<Songs>)request.getAttribute("songs");
if(songs!=null&&songs.size()>0){
	%>
	<hr>
	<br><br>
	<table border="1" cellpadding="10" cellspacing="0">
	<tr>
	<th>SONGID</th>
	<th>歌名</th>
	<th>歌手</th>
	<th>歌曲类型</th>
	
	<th>姓氏首字母</th>
	<th>SINGERID</th>
	<th>FILE_DESC</th>
	<th>歌曲地址</th>
	
	<th>修改</th>
	<th>删除</th>
	</tr>
	<%
	for(Songs song:songs){
		%>
		<tr>
		<td><%=song.getSongid()%></td>
		<td><%=song.getSongname()%></td>
		<td><%=song.getSongsinger() %></td>
		<td><%=song.getSongtype() %></td>
	
		<td><%=song.getSongen() %></td>
		<td><%=song.getSingerid() %></td>
		<td><%=song.getFile_desc() %></td>
			<td><%=song.getSongurl() %></td>
		<td><a href="edit1.ao?id=<%=song.getSongid()%>">UPDATE</a></td>
		<td><a href="delete1.ao?id=<%=song.getSongid()%>" class="delete">DELETE</a></td>
		</tr>
		<%
	}
	%>
	</table>
	<%
	
	
}
%>

<%
List<Singers> singers=(List<Singers>)request.getAttribute("singers");
if(singers!=null&&singers.size()>0){
	%>
	<hr>
	<br><br>
	<table border="1" cellpadding="10" cellspacing="0">
	<tr>
	<th>SINGERID</th>
	<th>歌手</th>
	
	
	<th>修改</th>
	<th>删除</th>
	</tr>
	<%
	for(Singers singer:singers){
		%>
		<tr>
		<td><%=singer.getSingerid()%></td>
		<td><%=singer.getSingername()%></td>
		
		<td><a href="edit.bo?id=<%=singer.getSingerid()%>">UPDATE</a></td>
		<td><a href="delete.bo?id=<%=singer.getSingerid()%>" class="delete">DELETE</a></td>
		</tr>
		<%
	}
	%>
	</table>
	<%
	
	
}
%>

<%
List<Users> users=(List<Users>)request.getAttribute("users");
if(users!=null&&users.size()>0){
	%>
	<hr>
	<br><br>
	<table border="1" cellpadding="10" cellspacing="0">
	<tr>
	<th>ID</th>
	<th>用户名</th>
	<th>密码</th>
	
	
	<th>修改</th>
	<th>删除</th>
	</tr>
	<%
	for(Users user:users){
		%>
		<tr>
		<td><%=user.getId() %></td>
		<td><%=user.getName()%></td>
		<td><%=user.getPassword()%></td>
		
		<td><a href="edit.co?id=<%=user.getId()%>">UPDATE</a></td>
		<td><a href="delete.co?id=<%=user.getId()%>" class="delete">DELETE</a></td>
		</tr>
		<%
	}
	%>
	</table>
	<%
	
	
}
%>

</div>
<%
}

%>
</body>
</html>