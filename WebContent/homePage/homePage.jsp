<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,
Login.src.domain.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/homePage.css"rel="stylesheet" type="text/css" /> 
<!-- 新歌首发-->
<style type="text/css">
	*{
	padding: 0;
	margin: 0;
	height: auto;
	width: auto;
	}
	html,body{
		height: 100%;
	}
	#container {
			width: 1000px;
			height: 390px;
			overflow: hidden;
	}
	.sections,.section {
		height:100%;
	}
	#container,.sections {
		position: relative;
	}
	.section {
		background-color:#000;
		background-size: cover;
		background-position: 50% 50%;
		text-align: center;
		color: white;
	}
	#section0 {
		background-image:url(images/1.jpg);
	}
	#section1 {
		background-image:url(images/2.jpg);
	}
	#section2 {
		background-image:url(images/3.jpg);
	}
	#section3 {
		background-image:url(images/4.jpg);
	}
</style>

<!-- 这是MV首发-->
<link rel="stylesheet" type="text/css" href="css/style.css">

<script type="text/javascript" src="js/koala.min.1.5.js"></script>
<script type="text/javascript">
Qfast.add('widgets', { path: "js/terminator2.2.min.js", type: "js", requires: ['fx'] });  
Qfast(false, 'widgets', function () {
	K.tabs({
		id: 'decoroll2',//焦点图包裹id  
		conId: "decoimg_a2",//大图域包裹id  
		tabId:"deconum2",//小圆点数字提示id
		tabTn:"a",
		conCn: '.decoimg_b2',//大图域配置class       
		auto: 1,//自动播放 1或0
		effect: 'fade',//效果配置
		eType: 'mouseover',// 鼠标事件
		pageBt:true,//是否有按钮切换页码
		bns: ['.prev', '.next'],//前后按钮配置class                          
		interval: 3000// 停顿时间  
	}) 
}) 
</script>
<!-- 这是精彩推荐的样式和脚本-->
<link type="text/css" rel="Stylesheet" href="css/imageflow.css"/>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/imageflow.js"></script>
<link rel="stylesheet" href="css/pageSwitch.min.css">

<style>

 

/*导航栏*/
#index{
	margin:auto;
	height: 175px;
	border-bottom: #39C solid 2px;
	overflow: hidden;
	background:#CCC  url(../tne%20charts/images/yue.png)no-repeat;
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
	float: none;
	color: #666;
	border: 2px solid  #CCC;
	font-style: normal;
	font-size: 36px;
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
	width: 200px;
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

<!--#box{
	
	top:20px;
	left:400px;
	height:100px;
	width:50px;
	
	
	
} -->
	</style>


</head>

<body  bgcolor="">
<div id="index"><span></span>
  <div class="button1" onkeypress=""align="center" ><a href="#">音乐铺</a></div>
  <div class="button2" align="center"><a href="#" >我的音乐馆</a></div>

<!-- /*使用JS实现搜索框显示默认字体*/ -->
<form action="searchServlet" method="post"> 
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
  <p><a href="../homePage.jsp" style="text-align:justify; text-decoration:blink; position:absolute;top:130px;left:480px;font-size:24px">首页</a></p>
  <p><a href="../singer/singer.jsp"style="text-align:justify; text-decoration:blink; position:absolute;top:130px;left:570px;font-size:24px">歌手</a></p>
  <p><a href="../phb/phb.jsp"style="text-align:justify; text-decoration:blink; position:absolute;top:130px;left:660px;font-size:24px">排行榜</a></p>
  <p><a href="#" style="text-align:justify; text-decoration:blink; position:absolute;top:130px;left:780px;font-size:24px">MV</a></p>
</div>

</div>

<div class="recom">
<center>
<div class="header1" style="font-size:20px">
<h1>新歌首发</h1>
<a href="#">全部</a>
<a herf="#">华语</a>
<a herf="#">欧美</a>
<a herf="#">韩国</a>
<a herf="#">日本</a>
</div>
<div id="container">
	<div class="sections">
		<div class="section" id="section0"><h3>华语</h3></div>
		<div class="section" id="section1"><h3>欧美</h3></div>
		<div class="section" id="section2"><h3>韩国</h3></div>
		<div class="section" id="section3"><h3>日本</h3></div>
      </div>
</div>

<script src="js/jquery-1.11.0.min.js"type="text/javascript"></script>
<script src="js/pageSwitch.min.js"></script>
<script>
	$("#container").PageSwitch({
		direction:'horizontal',
		easing:'ease-in',
		duration:1000,
		autoPlay:true,
		loop:'false'
	});
</script>



<div class="recom">
<center>
<div class="header1" style="font-size:20px">
<h1>MV首播</h1>
<a herf="#">全部</a>
<a herf="#">华语</a>
<a herf="#">欧美</a>
<a herf="#">韩国</a>
<a herf="#">日本</a>
</div>
<div id="decoroll2" class="imgfocus">

	<div id="decoimg_a2" class="imgbox">
		<div class="decoimg_b2"><a href="#"><img src="images/5.jpg"></a></div>
		<div class="decoimg_b2"><a href="#"><img src="images/6.jpg"></a></div>
		<div class="decoimg_b2"><a href="#"><img src="images/7.jpg"></a></div>
		<div class="decoimg_b2"><a href="#"><img src="images/8.jpg"></a></div>
	</div>
	
	<ul id="deconum2" class="num_a2">
		<li><a href="javascript:void(0)" hidefocus="true" target="_self">华语</a></li>
		<li><a href="javascript:void(0)" hidefocus="true" target="_self">欧美</a></li>
		<li><a href="javascript:void(0)" hidefocus="true" target="_self">韩国</a></li>
		<li><a href="javascript:void(0)" hidefocus="true" target="_self">日本</a></li>
	</ul>
	
</div>
<div class="recom">
<div class="header1" style="font-size:20px">

<h1>热门歌单</h1>
</div>


<a herf=""><img src="images/rmgd.jpg"height="300" width="800"/></a>
</div>
<div class="recom">
<div class="header1" style="font-size:20px">
<h1>精彩推荐</h1>
<a herf="#">MV精选</a>
<a herf="#">歌曲推荐</a>
<a herf="#">实力唱将</a>
</div>
<div id="LoopDiv">
<input id="S_Num" type="hidden" value="8" />
<div id="starsIF" class="imageflow">
<img src="images/210858906_R.jpg" width="280" height="300" alt="#" />
<img src="images/211414202_R.png"  width="280" height="300" alt="#" />
<img src="images/211605770_R.jpg" width="280" height="300" alt="#" />
</div>
</div>

<div id="footer">
<p ><a herf="#">关于我们|<a herf="#">联系方式|<a herf="#">意见建议</a></a></a></p>
</div>












</body>
</html>