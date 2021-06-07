<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Login.src.domain.User,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>歌手-悦动听</title>
<!--<script type="text/javascript" src=""></script><link href="" type="text/css" rel="stylesheet" />-->
<LINK rel=stylesheet type=text/css href="css/lrtk.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/demo.css">
<link rel="stylesheet" type="text/css" href="css/normalize.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:300,700' rel='stylesheet' type='text/css' />
		<script type="text/javascript" src="js/modernizr.custom.79639.js"></script> 
<SCRIPT type=text/javascript src="js/jquery.js"></SCRIPT>
<SCRIPT type=text/javascript charset=utf-8 src="js/lrscroll.js"></SCRIPT>

<style>
/*导航栏*/
#index{
	height: 175px;
	margin:auto;
	border-bottom: #39C solid 2px;
	overflow: hidde;
	background:#CCC url(images/index.png) no-repeat;
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

<div class="h2">推荐歌手</div>
<DIV id=featureContainer>
  <DIV id=feature>
  <DIV id=block>
   <DIV id=botton-scroll>
   <UL class=featureUL>

  <LI class=featureBox>
  <DIV class=box><A href="#" target="_blank"><img src="images/1.jpg" width=290 height=200> </A></DIV>
  <!-- /box --></LI>
  <LI class=featureBox>
  <DIV class=box><A href="#" target="_blank"><img   src="images/2.jpg"width=290 height=200>> </A></DIV>
  <!-- /box --></LI>
  <LI class=featureBox>
  <DIV class=box><A href="#" target="_blank"><img  src="images/3.jpg"  width=290 height=200>> </A></DIV>
  <!-- /box --></LI>
  <LI class=featureBox>
  <DIV class=box><A href="#" target="_blank"><img   src="images/4.jpg" width=290 height=200>> </A></DIV>
  <!-- /box --></LI>
  <LI class=featureBox>
  <DIV class=box><A href="#" target="_blank"><img   src="images/5.jpg" width=290 height=200>> </A></DIV>
  <!-- /box --></LI>
  <LI class=featureBox>
  <DIV class=box><A href="#" target="_blank"><img   src="images/6.jpg" width=290 height=200>> </A></DIV>
  <!-- /box -->
   <LI class=featureBox>
    <DIV class=box><A href="#" target="_blank"><img  src="images/7.jpg"  width=290 height=200> </A></DIV>
</LI></UL></DIV><!-- /botton-scroll --></DIV><!-- /block -->
  <A class=prev href="javascript:void();">Previous</A>
  <A class=next href="javascript:void();">Next</A> 
  </DIV>
<!-- /feature -->
</DIV><!-- /featureContainer -->
<!--<div id="featurebox"> -->
</DIV><!-- /featured --></DIV>
<!-- /body -->
</DIV>
</div>
</LI>
</LI>
</LI>
</LI>
</LI>
</LI>
</div>
</LI>


<dl id="sd">
<div class="sc">
<dt id=we><b>华语歌单</b></dt>
<ol>
<li><a>男歌手</a></li>
<li><a>女歌手</a></li>
<li><a>乐队组合</a></li>
</ol>
<dt id=we><b>欧美歌单</b></dt>
<ol>
<li><a>男歌手</a></li>
<li><a>女歌手</a></li>
<li><a>乐队组合</a></li>
</ol>
<dt id=we><b>日韩歌单</b></dt>
<ol>
<li><a>男歌手</a></li>
<li><a>女歌手</a></li>
<li><a>乐队组合</a></li>
</ol>

</div>
</dl>




<div class="sotr_tag">
 <form action="searchServlet" method="post">
   <button class="hot_cur"><a href="#">热门</a></button>
   <div class="tag_box"><input name="searchen" type="submit" value="A" ></div>
   <div class="tag_box"><input name="searchen" type="submit" value="B" ></div>
   <div class="tag_box"><input name="searchen" type="submit" value="C" ></div>
   <div class="tag_box"><input name="searchen" type="submit" value="D" ></div>
   <div class="tag_box"><input name="searchen" type="submit" value="E" ></div>
   <div class="tag_box"><input name="searchen" type="submit" value="F" ></div>
   <div class="tag_box"><input name="searchen" type="submit" value="G" ></div>
   <div class="tag_box"><input name="searchen" type="submit" value="H" ></div>
   <div class="tag_box"><input name="searchen" type="submit" value="I" ></div>
   <div class="tag_box"><input name="searchen" type="submit" value="J" ></div>
   <div class="tag_box"><input name="searchen" type="submit" value="K" ></div>
   <div class="tag_box"><input name="searchen" type="submit" value="L" ></div>
   <div class="tag_box"><input name="searchen" type="submit" value="M" ></div>
   <div class="tag_box"><input name="searchen" type="submit" value="N" ></div>
   <div class="tag_box"><input name="searchen" type="submit" value="O" ></div>
   <div class="tag_box"><input name="searchen" type="submit" value="P" ></div>
   <div class="tag_box"><input name="searchen" type="submit" value="Q" ></div>
   <div class="tag_box"><input name="searchen" type="submit" value="R" ></div>
   <div class="tag_box"><input name="searchen" type="submit" value="S" ></div>
   <div class="tag_box"><input name="searchen" type="submit" value="T" ></div>
   <div class="tag_box"><input name="searchen" type="submit" value="U" ></div>
   <div class="tag_box"><input name="searchen" type="submit" value="V" ></div>
   <div class="tag_box"><input name="searchen" type="submit" value="W" ></div>
   <div class="tag_box"><input name="searchen" type="submit" value="X" ></div>
   <div class="tag_box"><input name="searchen" type="submit" value="Y" ></div>
   <div class="tag_box"><input name="searchen" type="submit" value="Z" ></div>
  
 
    </form>
 </div>
</div>


<div id="context">
  <div class="container">
			<section class="main">
				<ul class="ch-grid">
					<li>
						<div class="ch-item ch-img-1">
							<div class="ch-info">
								<h3><a href="<%=request.getContextPath() %>/searchSinger/Servlet2Servlet?songid=3">演员</a><br/>
                                <a href="#">丑八怪</a><br/>
                               <a href="#" >绅士</a></h3>
                             
								<p><h2> <a href="#">薛之谦</a></p></h1>
							</div>
						</div>
					</li>
					<li>
						<div class="ch-item ch-img-2">
							<div class="ch-info">
								<h3><a href="#">一万个舍不得</a><br/>
                                <a href="#">以后的以后</a><br/>
                               <a href="<%=request.getContextPath() %>/searchSinger/Servlet2Servlet?songid=11" >爱囚</a></h3>
								<p><h2><a href="#">庄心研 </h1></a></p>
							</div>
						</div>
					</li>
					<li>
					  <div class="ch-item ch-img-3">
					    <div class="ch-info">
					      <h3><a href="#">告白气球</a><br/>
					        <a href="#">青花瓷</a><br/>
					        <a href="#" >晴天</a></h3>
					      <p><h2> <a href="#">周杰伦</h2></a></p>
					      </a>
					      </p>
				        </div>
				      </div>
					</li>
                    
                    
                    <li>
						<div class="ch-item ch-img-4">
							<div class="ch-info">
								<h3><a href="#">让我留在你身边</a><br/>
                                <a href="<%=request.getContextPath() %>/searchSinger/Servlet2Servlet?songid=1">浮夸</a><br/>
                               <a href="#" >因为爱情</a></h3>
                             
								<p><h2> <a href="#">陈奕迅</a></p></h1>
							</div>
						</div>
					</li>
					<li>
						<div class="ch-item ch-img-5">
							<div class="ch-info">
								<h3><a href="#">吻别</a><br/>
                                <a href="#">一路上有你</a><br/>
                               <a href="#" >心如刀割</a></h3>
								<p><h2> <a href="#">张学友</h1></a></p>
							</div>
						</div>
					</li>
					<li>
					  <div class="ch-item ch-img-6">
					    <div class="ch-info">
					      <h3><a href="#">夜空中最亮的星</a><br/>
					        <a href="#">喜欢你</a><br/>
					        <a href="#" >泡沫</a></h3>
					      <p><h2> <a href="#">邓紫棋</h2></a></p>
					    
				        </div>
				      </div>
					</li>
                    
                    <li>
						<div class="ch-item ch-img-7">
							<div class="ch-info">
								<h3><a href="#">可惜没有如果</a><br/>
                                <a href="#">她说</a><br/>
                               <a href="#" >修炼爱情</a></h3>
                             
								<p><h2><a href="#">林俊杰 </a></p></h1>
							</div>
						</div>
					</li>
					<li>
						<div class="ch-item ch-img-8">
							<div class="ch-info">
								<h3><a href="#">青春修炼手册</a><br/>
                                <a href="#">宠</a><br/>
                               <a href="#" >剩下的盛宴</a></h3>
								<p><h2><a href="#">TF-Boys </h1></a></p>
							</div>
						</div>
					</li>
					<li>
					  <div class="ch-item ch-img-9">
					    <div class="ch-info">
					      <h3><a href="#">断桥残雪</a><br/>
					        <a href="#">素颜</a><br/>
					        <a href="#" >晴明之上</a></h3>
					      <p><h2><a href="#">许嵩</h2></a></p>
					      </a>
					      </p>
				        </div>
				      </div>
					</li>
                      </ul>
				</section>
			
</div>

</div>


</div>


<div id="footer">
<p ><a herf="#">关于我们|<a herf="#">联系方式|<a herf="#">意见建议</a></a></a></p>
</div>



</body>
</html>