<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/jquery-1.3.2.js"></script>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<font color="red">${message}</font>
<br><br>
<form action="fileuploadservlet" method="post" enctype="multipart/form-data">
<!-- <input type="hidden" id="fileNum" name="fileNum" id="1" />  -->
<!--  
File1: <input type="file" name="file1" />
<br>
Desc1: <input type="text" name="desc1" />
<br>
<br id="br">
<input type="submit" id="submit" value="提交" />
<button id="addFile">新增一个附件</button>
 -->
 
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

