<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript">


$(function(){
	var i=2;
	$("#addFile").click(function(){
		$(this).parent().parent().before("<tr class='file'><td>File"
				+i+":</td><td><input type='file' name='file"
				+i+"' /></td></tr>"
				+"<tr class='desc'><td>Desc"
				+i+":</td><td><input type='text' name='desc"
				+i+"' /><button id='delete"
				+i+"'>删除</button></td></tr>");
		
		       
		          i++;
		
		$("#delete"+(i-1)).click(function(){
			var $tr=$(this).parent().parent();
			$tr.prev("tr").remove();
			$tr.remove();
			
			$(".file").each(function(){
				var n=index+1;
				$(this).find("td:first").text("File"+n);
				$(this).find("td:last input").attr("name","file"+n);
			});
			$(".desc").each(function(){
				var n=index+1;
				$(this).find("td:first").text("Desc"+n);
				$(this).find("td:last input").attr("name","desc"+n);
			});
			i=i-1;
			
		});
		return false;
	});
});

</script>
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
</head>
<body>
<div id="index" >
<div class="b1"><strong>后台管理系统</strong></div>



 
</div>  
<br><br>
<font color="red">${msg}</font>
<br><br>
<form action="app/fileuploadservlet" method="post" enctype="multipart/form-data">

 
 <table>
 <tr class="file">
 <td>File1:</td>
 <td><input type="file" name="file1" /></td>
 </tr>
 <tr class="desc">
 <td>Desc:</td>
 <td><input type="text" name="desc1" /></td>
 </tr>
 <tr>
 <td><input type="submit" value="提交"></td>
 <td><button id="addFile">新增一个附件</button></td>
 </tr>
 </table>
 
</form>

</body>
</html>
