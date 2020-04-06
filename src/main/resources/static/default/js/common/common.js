/**
 * 获取路径
 */
function getPath(){
	var u = window.location;/*      http://localhost:8888/web/user/list    */
	var p = window.location.pathname;/*    /web/user/list               */
	var ps = p.split("/");
	var pth = "";
	for(var i = 0; i < ps.length; i++){
		if(ps[i]!=null && ps[i]!=''){
			pth = ps[i];
			break;
		}
	}
	// https://localhost:8888/web
	return window.location.protocol /* https://  */
		+ "//" 
		+ window.location.host /*  localhost:8888   */
		+ "/"
		+ pth;  /*  web  */
}

/**
 * string 判断空
 */
String.prototype.isEmpty = function () {
	if (this==null) {
		return true;
	}
	var str=this.trim();
	if (str==null || str=='' || str=='underfriend' || str=='null') {
		return true;
	}
    return false;
}

/**
 * string 将日期转成 yyyy-MM-dd 格式
 */
Date.prototype.format=function(date){
	if(!isNotNull(date)){
		return "";
	}else{
		return formatDate(date ,'yyyy-MM-dd');
	}
}
	
	
	
	