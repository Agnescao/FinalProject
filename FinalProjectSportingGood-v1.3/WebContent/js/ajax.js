function checkExist(){
                var xmlhttp = new XMLHttpRequest();
                var username = document.forms["regF"]["username"].value;
                var url = "exist.jsp?username=" + username;
                xmlhttp.onreadystatechange = function(){
                    if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
                        if(xmlhttp.responseText == "\n\n\n\n\nUser already exists")
                            document.getElementById("isE").style.color = "red";
                        else
                            document.getElementById("isE").style.color = "green";
                        document.getElementById("isE").innerHTML = xmlhttp.responseText;
                    }
                    
                };
                try{
                xmlhttp.open("GET",url,true);
                xmlhttp.send(null);
            }catch(e){alert("unable to connect to server");
            }
}
function showAnswer(id){
	var xhttp = new XMLHttpRequest();
	var commentId=id;
	console.log(commentId);
	var url = "getAnswer.jsp?commentId=" + commentId;
	 xhttp.onreadystatechange = function(){
		 if(xhttp.readyState == 4 && xhttp.status == 200){
			 
			 document.getElementsByName("replys")[commentId-1].innerHTML= xhttp.responseText;
	 }
};
xhttp.open("GET", url, true);
xhttp.send(null);
}


function saveReply(commentId){
	var xhttp = new XMLHttpRequest();
	var reply=document.getElementsByName("query")[commentId-1].value;
	console.log(reply);
	console.log(commentId);
	var url = "saveReply.jsp?commentId=" + commentId+"&reply="+reply;
	 xhttp.onreadystatechange = function(){
		 if(xhttp.readyState == 4 && xhttp.status == 200){
			 
			 document.getElementsByName("replys")[commentId-1].innerHTML = xhttp.responseText;
	 }
};
xhttp.open("GET", url, true);
xhttp.send(null);
}