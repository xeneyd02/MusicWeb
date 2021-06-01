window.onload = function(){
		var divs = document.getElementById("playMusic-btn");
		var len = divs.length;
		for(var i=0;i<len;i++){
			divs[i].onclick = function(){
				for(var j=0;j<len;j++){
					divs[j].style.backgroundColor = "black";
				}
				this.style.backgroundColor = "red";
			};
		}
	};