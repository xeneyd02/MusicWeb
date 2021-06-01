<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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


<div id="index" >
<div class="b1"><strong>后台管理系统</strong></div>



 
</div>  
<br><br>
<%
Object msg=request.getAttribute("message");
if(msg!=null){
	%>
	<br>
	<font color="red" ><%=msg %></font>
	<br>
	<%
}
%>
<br><br>
<center>
<form action="addCustomer1.ao" method="post">
<table>
<tr>
<td>歌名</td>
<td><input type="text" name="songname" value=<%=request.getParameter("songname")==null ? "" : request.getParameter("songname")  %>></td>

</tr>
<tr>
<td>歌手</td>
<td><input type="text" name="songsinger" value=<%=request.getParameter("songsinger")==null ? "" : request.getParameter("songsinger")  %>></td>

</tr>
<tr>
<td>歌曲类型</td>
<td><input type="text" name="songtype" value=<%=request.getParameter("songtype")==null ? "" : request.getParameter("songtype")  %>></td>

</tr>
<tr>
<td>歌曲地址</td>
<td><input type="text" name="songurl" value=<%=request.getParameter("songurl")==null ? "" : request.getParameter("songurl")  %>></td>

</tr>
<tr>
<td>姓氏首字母</td>
<td><input type="text" name="songen" value=<%=request.getParameter("songen")==null ? "" : request.getParameter("songen")  %>></td>

</tr>
<tr>
<td>SINGERID</td>
<td><input type="text" name="singerid" value=<%=request.getParameter("singerid")==null ? "" : request.getParameter("singerid")  %>></td>

</tr>
<tr>
<td>FILE_DESC</td>
<td><input type="text" name="file_desc" value=<%=request.getParameter("file_desc")==null ? "" : request.getParameter("file_desc")  %>></td>

</tr>
<tr>
<td colspan="2"><input type="submit" value="submit" /></td>
</tr>
</table>
</form>
</center>
</body>
</html>