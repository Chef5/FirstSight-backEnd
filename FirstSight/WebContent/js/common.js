function showtime(){
	setInterval("getTime()",1000);	
}
function getTime(){
	var dt=new Date();
	var year=dt.getFullYear();
	var month=dt.getMonth()+1;
	var day=dt.getDate();
	var hover=dt.getHours();
	if(hover<=9){
		hover="0"+hover;
	}
	var min=dt.getMinutes();
	if(min<=9){
		min="0"+min;
	}
	var sen=dt.getSeconds();
	if(sen<=9){
		sen="0"+sen;
	}
	var strtime=year+"年"+month+"月"+day+"日   "+hover+":"+min+":"+sen;
	var vp=document.getElementsByClassName("ptime")[0];
	vp.innerText=strtime;	
}
