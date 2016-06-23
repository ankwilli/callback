<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#sub').click(function(){
		postMessage();
	});
	
    function postMessage(){
    	
    	var payload = new Object();
    	payload.url = 'C:/barclays-logo/png';

    	var attachment = new Object();
    	attachment.type = 'image';
    	attachment.payload = payload;

    	var attachments = new Array();
    	attachments.push(attachment);
    	
    	
	        var message   =  $('#chatMsg').val();
	        var attachedMsg = {
					  object:"page",
					  entry:[
					    {
					      id : "thegotoBank",
					      time:1458696618911,
					      messaging:[
					        {
					          sender:{
					            id:"ankur"
					          },
					          recipient:{
					            id :"thegotoBank"
					          },
					          timestamp :1458696618268,
					          message:{
					            mid:"mid.1458696618141:b4ef9d19ec21086067",
					            seq:51,
					            attachments:[
					              {
					                type:"image",
					                payload:{
					                  url: "C:/barclays-logo.png"
					                }
					              }
					            ]
					          }
					        }
					      ]
					    }
					  ]
					};
	        
	    	$.ajax({
    			url:"http://localhost:8080/IntegrateChatGatewayPOC/textReply.html",
    			type:'POST',
    			dataType : 'JSON',
    			data:{message : attachments},
    			/* data : {
						  object:"page",
						  entry:[
						    {
						      id : "thegotoBank",
						      time:1458696618911,
						      messaging:[
						        {
						          sender:{
						            id:"ankur"
						          },
						          recipient:{
						            id :"thegotoBank"
						          },
						          timestamp :1458696618268,
						          message:{
						            mid:"mid.1458696618141:b4ef9d19ec21086067",
						            seq:51,
						            attachments:[
						              {
						                type:"image",
						                payload:{
						                  url: "C:/barclays-logo.png"
						                }
						              }
						            ]
						          }
						        }
						      ]
						    }
						  ]
						}, */ 
						/* data : {message : JSON.stringify(attachedMsg)}, */
    			success:function(result)
    			{
    				console.log("success");
    			}
    		});

    }
});
</script>

</head>
<body>
<form:form>
<!-- <table>
<tr> -->
Please type here your message
<textarea id="chatMsg">

</textarea>

<button type="button" id="sub">Send</button>
<!-- </tr>
</table> -->
</form:form>

</body>
</html>