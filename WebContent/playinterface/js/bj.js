// JavaScript Document
var pos = 4; function initArray() { this.length = initArray.arguments.length; for (var i = 0; i < this.length; i++) { this[i] = initArray.arguments[i]; } } var col=new initArray(); col[0] = "pic1"; col[1] = "pic2"; col[2] = "pic3"; col[3] = "pic4"; function chgpic() { pos++; if (pos<0||pos>3) { pos = 0; } pid.className = col[pos]; setTimeout("chgpic()",2000); }