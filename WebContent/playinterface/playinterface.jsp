<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,Login.src.domain.User,
search.domain.Search" %>
    <%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="playinterface/css/stylesheets/style.css">
<script src="playinterface/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">



</script>
</head>
<body>
<div id="index"><span></span>
  <div class="button1" onkeypress=""align="center" ><a href="#">音乐铺</a></div>
  <div class="button2" align="center"><a href="#" >我的音乐馆</a></div>

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
  <p><a href="homePage.jsp" style="text-align:justify; text-decoration:blink; position:absolute;top:130px;left:480px;font-size:24px">首页</a></p>
  <p><a href="../singer/singer.jsp"style="text-align:justify; text-decoration:blink; position:absolute;top:130px;left:570px;font-size:24px">歌手</a></p>
  <p><a href="../phb/phb.jsp"style="text-align:justify; text-decoration:blink; position:absolute;top:130px;left:660px;font-size:24px">排行榜</a></p>
  <p><a href="#" style="text-align:justify; text-decoration:blink; position:absolute;top:130px;left:780px;font-size:24px">MV</a></p>
</div>

</div>
<div id="background">

<div id="player">
	<div class="cover"></div>
	<div class="ctrl">
		<div class="tag">
			<strong>Title</strong>
			<span class="artist">歌手</span>
			<span class="album">专辑</span>
		</div>
		<div class="control">
			<div class="left">
				<div class="rewind icon"></div>
				<div class="playback icon"></div>
				<div class="fastforward icon"></div>
			</div>
			<div class="volume right">
				<div class="mute icon left"></div>
				<div class="slider left">
					<div class="pace"></div>
				</div>
			</div>
		</div>
		<div class="progress">
			<div class="slider">
				<div class="loaded"></div>
				<div class="pace"></div>
			</div>
			<div class="timer left">0:00</div>
			<div class="right">
				<div class="repeat icon"></div>
				<div class="shuffle icon"></div>
			</div>
		</div>
	</div>
</div>

<ul id="playlist"></ul>
</div>
</div>







<%
String songname="";
String singername="";
String songurl="";
String songtype="";
Search song=(Search) request.getAttribute("songs");
songname=song.getSongname();
singername=song.getSongsinger();
songurl=song.getSongurl();
songtype=song.getSongtype();

%>



<input type="hidden" id="songname" value="<%=songname %> " />
<input type="hidden" id="songsinger" value="<%=singername %>" />
<input type="hidden" id="songtype" value="<%=songtype %>" />
<input type="hidden" id="songurl" value="<%=songurl %>" />
<input type="hidden" id="path" value="<%= request.getContextPath()%>" />

<script src="playinterface/js/jquery-ui-1.8.17.custom.min.js"></script>
<script src="playinterface/js/script.js"></script>
<script type="text/javascript" src="playinterface/js/test.js"></script>
<div id="footer">
<p ><a herf="#">关于我们|<a herf="#">联系方式|<a herf="#">意见建议</a></a></a></p>
</div>

</body>
</html>