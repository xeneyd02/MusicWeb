<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="Login.src.domain.User,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css"rel="stylesheet" type="text/css" /> 
</head>

<body>
<div class="index" style="background-color:redC;height:200px; margin:auto;float:top" >
  <div id="index"><span></span>
  <div class="button1" onkeypress=""align="center"><a href="#">音乐铺</a></div>
  <div class="button2" align="center"><a href="#">我的音乐馆</a></div>

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
  <p><a href="../login/login.jsp" target="_blank" style="text-align:justify; text-decoration:blink; position:absolute;top:45px;left:1070px; font-size:25px; font-family:'Times New Roman', Times, serif">登录</a></p>
  <p><a href="../register/register.jsp"  target="_blank"style="text-align:justify; text-decoration:blink; position:absolute;top:45px;left:1150px; font-size:25px; font-family:'Times New Roman', Times, serif">注册</a></p>
	<%
}
%>  
  <p><a href="homePage.jsp" style="text-align:justify; text-decoration:blink; position:absolute;top:130px;left:480px;font-size:24px">首页</a></p>
  <p><a href="../singer/singer.jsp"style="text-align:justify; text-decoration:blink; position:absolute;top:130px;left:570px;font-size:24px">歌手</a></p>
  <p><a href="../phb/phb.jsp"style="text-align:justify; text-decoration:blink; position:absolute;top:130px;left:660px;font-size:24px">排行榜</a></p>
  <p><a href="#" style="text-align:justify; text-decoration:blink; position:absolute;top:130px;left:780px;font-size:24px">MV</a></p>
  </div>

</div>
</div>
 <!--中间内容区 -->
 <div class="pc_rank_main" style="background-color:#EEEEEE;height:400px; margin:auto;align:right;">
 <!-- 侧栏 -->
 <div class="pc_rank_main_side" style="height:400px;width:250px;float:left;">  
			<!-- 热门榜单 -->
	<ul id="accordion" class="accordion">
		<li>
			<div class="link"><i class="fa fa-paint-brush"></i>热门歌单     <span>▼</span><i class="fa fa-chevron-down"></i></div>
			<ul class="submenu">
				<li><a href="#">华语新歌榜
                 </a></li>
				<li><a href="#">欧美新歌榜</a></li>
				<li><a href="#">日语新歌榜</a></li>
				<li><a href="#">韩语新歌榜</a></li>
			</ul>
		</li>
		<li>
			<div class="link"><i class="fa fa-code"></i>特色歌单    <span>▼</span><i class="fa fa-chevron-down"></i></div>
			<ul class="submenu">
				<li><a href="#">洗脑神曲</a></li>
				<li><a href="#">影视金曲</a></li>
				<li><a href="#">原创歌曲</a></li>
                <li><a href="#">KTV嗨曲</a></li>
			</ul>
		</li>
		<li>
			<div class="link"><i class="fa fa-mobile"></i>全球歌单    <span>▼</span><i class="fa fa-chevron-down"></i></div>
			<ul class="submenu">
				<li><a href="#">内地榜</a></li>
				<li><a href="#">港台榜</a></li>
				<li><a href="#">欧美榜</a></li>
				<li><a href="#">日韩榜</a></li>
			</ul>
		</li>

<script src='http://codepen.io/assets/libs/fullpage/jquery.js'> --></script>
<script src="js/index.js"></script>

<em></em>
</div>
   <div>
   <button class="button play"  ><a href="#"/>
   播放</button>
   <button class="button add" ><a href="#"/>
   添加 </button>
   <button class="button download" ><a href="#"/>
   下载   </button>
    
 	<div class="ondisplay">
    <section>
      <div class="checkbox" >
      <input type="checkbox" value="None" id="checkbox" name="checkbox" checked="checked" >
       <label for="checkbox">
       </label>
       </div>
        <p style="position:absolute; top:280px; left:350px; font-style:normal; font-size:15px; font-weight:600; color:#000">全选</p>
      </section>
      
     
       </div>
       
      
     
     </div>
  
   
     
     


</div>
 <div  class="footer" >
   
<p ><a herf="#">关于我们|<a herf="#">联系方式|<a herf="#">意见建议</a></a></a></p>

</div>  
</body>
</html>