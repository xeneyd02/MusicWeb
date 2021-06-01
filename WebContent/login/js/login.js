$("#validationCode_img").click(function(){
	
	$("#validationCode_img").attr("src","/MusicWeb/Login/src/servlet/validateCode?"+Math.random());
	
});
