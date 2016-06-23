<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Barclays Chat App</title>
</head>
<link href="chat.css" type="text/css" rel="stylesheet">
<link href="jquery-ui-themes.css" type="text/css" rel="stylesheet">
<link href="typography.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="json2.js"></script>
<script type="text/javascript">
var agentPickedOrNot='false';
var csrfToken='';
var jSessionId='';
    function CheckAgentPickedOrNot() {
    	console.log('CheckAgentPickedOrNot');
    	//Initiate_AuthChat_Operation();
    	console.log('CheckAgentPickedOrNot----'+agentPickedOrNot);
        if(agentPickedOrNot=='false'){
        	Initiate_AuthChat_Operation();
        }else{
        	Chat_Operation(csrfToken,jSessionId);
        	/* if(agentPickedOrNot=='true'){
                int = setInterval(function(){Agent_Chat_Operation();},3000);
            } */
        }
    }
    
    
    
    function Initiate_AuthChat_Operation(){
    	console.log('Initiate_AuthChat_Operation');
    	//var csrfToken = $('#csrfToken').val();
       // var jSessionId = $('#jSessionId').val();
        var question   = $('#question').val();
         var custName   = $('#custName').val();
//alert("in NC004 values--1--"+csrfToken+"--2--"+jSessionId+"--3--"+question+"--4--"+custName);
    	$.ajax({
    			url:"/IntegrateChatGatewayPOC/initiateChatOperation.html",
    			type:'POST',
    			/* headers: { 
    			    Accept : "application/json"
    			},
    			dataType: 'json',*/
    			data:{
    				custName :custName,
            			question : question
            			//jSessionId : jSessionId,
            			//csrfToken: csrfToken
            		 },
    			success:function(result)
    			{
    				console.log('success')
    				 var obj = JSON.parse(result);
    				console.log('in success'+obj);
    				console.log('Token-'+obj.csrfToken+'--jsessionid---'+obj.jSessionId);
    				csrfToken=obj.csrfToken;
    				jSessionId=obj.jSessionId;
    				var gateway_response = obj.op_status;
    				if(gateway_response == "00000")
    				{
    					console.log('status - 00000');
    					agentPickedOrNot = obj.hasAgentPickedUp;
    					console.log("1---"+agentPickedOrNot);
    					if(obj.hasAgentPickedUp){
    						Chat_Operation(csrfToken,jSessionId);
    						 if(agentPickedOrNot=='true'){
    		                		int = setInterval(function(){Agent_Chat_Operation(csrfToken,jSessionId);},3000);
    		            	  } 
    						//int = setInterval(function(){Chat_Operation();},3000);
    					}
    				}
    				else if(gateway_response == "00003" || gateway_response == "NME07"){
    					console.log('status - 00003');
    				}
    				else if(gateway_response == "NME02"){
    					console.log('status - NME02');
    				}
    			},
    			error:function error(xhr,status,error)
    			{
    				console.log('status - error'+xhr);
    				console.log("status......"+error);
    				console.log("status......"+status);
    				//Chat_Operation();
    			}
    		});

    }
    
    function Chat_Operation(csrfToken,jSessionId){
    	console.log('Chat_Operation');
    	//var csrfToken = $('#csrfToken').val();
       //var jSessionId = $('#jSessionId').val();
        var question   = $('#question').val();
         var custName   = $('#custName').val();
//alert("in NC006 values--1--"+csrfToken+"--2--"+jSessionId+"--3--"+question+"--4--"+custName);
    	$.ajax({
    			url:"/IntegrateChatGatewayPOC/startConversation.html",
    			type:'POST',
    			/* headers: { 
    			    Accept : "application/json"
    			},
    			dataType: 'json',*/
    			data:{
    				custName :custName,
            			question : question,
            			jSessionId : jSessionId,
            			csrfToken: csrfToken,
            			requestType: 'U002'
            		 },
    			success:function(result)
    			{
    				console.log('success')
    				var obj = JSON.parse(result);
    				console.log('in success'+obj != null);
    				
    				if(obj == null){
                  	   //do nothing
                     }else{
    				$.each(obj, function(obj, chatList) {
    					console.log('message-'+chatList.message+'--agent/guest---'+chatList.agentOrGuest);
                           // var r = "<option value='" + a.testName + "'>" + a.testName + "</option>";
                           // $("#noOfTestName").append(r)
	    					var append_chat = '<div><p>'
								+ chatList.agentOrGuest
								+ '</p><p>'
								+ chatList.message
								+ '</p></div>';
	    					$('.chatarea').append(
	    						append_chat);
                    })
                  }
    				/*  var obj = JSON.parse(result);
    				console.log('in success'+obj);
    				var element=obj.chatList; 
    				console.log('in element'+element);
    				console.log('message-'+element.message+'--agent/guest---'+element.agentOrGuest); */
    				/* var append_chat = '<div><p>You</p><p>'
						+ chat
						+ '</p></div>';
				$('.chatarea').append(
						append_chat); */
    				//var gateway_response = obj.op_status;
    				/* if(gateway_response == "00000")
    				{
    					console.log('status - 00000');
    					if(obj.hasAgentPickedUp){
    						Chat_Operation();
    						//int = setInterval(function(){Chat_Operation();},3000);
    					}
    				}
    				else if(gateway_response == "00003" || gateway_response == "NME07"){
    					console.log('status - 00003');
    				}
    				else if(gateway_response == "NME02"){
    					console.log('status - NME02');
    				} */
    			},
    			error:function error(xhr,status,error)
    			{
    				console.log('status - error'+xhr);
    				console.log("status......"+error);
    				console.log("status......"+status);
    				//Chat_Operation();
    			}
    		});
    }

    /* if(agentPickedOrNot=='true'){
    int = setInterval(function(){Agent_Chat_Operation();},3000);
    }
     */
    function Agent_Chat_Operation(csrfToken,jSessionId){
    	console.log('Agent_Chat_Operation');
    	//var csrfToken = $('#csrfToken').val();
        //var jSessionId = $('#jSessionId').val();
        var question   = $('#question').val();
         var custName   = $('#custName').val();
//alert("in NC006 values--1--"+csrfToken+"--2--"+jSessionId+"--3--"+question+"--4--"+custName);
    	$.ajax({
    			url:"/IntegrateChatGatewayPOC/startConversation.html",
    			type:'POST',
    			/* headers: { 
    			    Accept : "application/json"
    			},
    			dataType: 'json',*/
    			data:{
    					custName :custName,
            			question : question,
            			jSessionId : jSessionId,
            			csrfToken: csrfToken,
            			requestType: 'U001'
            		 },
    			success:function(result)
    			{
    				console.log('success Agent_Chat_Operation')
    				var obj = JSON.parse(result);
    				console.log('in success Agent_Chat_Operation'+obj);
    				//if(obj == null){
    				if(obj == null){
                 	   //do nothing
                    }else{
    				$.each(obj, function(obj, chatList) {
    					if(chatList.action == 'A002'){
    					console.log('message-Agent_Chat_Operation-'+chatList.message+'--agent/guest-Agent_Chat_Operation--'+chatList.agentOrGuest);
                           // var r = "<option value='" + a.testName + "'>" + a.testName + "</option>";
                           // $("#noOfTestName").append(r)
	    					var append_chat = '<div><p>'
								+ chatList.agentOrGuest
								+ '</p><p>'
								+ chatList.message
								+ '</p></div>';
	    					$('.chatarea').append(
	    						append_chat);
    					}else if(chatList.action == 'A003'){
    						console.log('message-Agent_Chat_Operation-action--'+chatList.action+'--agent/guest-Agent_Chat_Operation--'+chatList.agentOrGuest);
    						console.log('agent is typing');
    					}else{
    						console.log('do nothing in for each loop');
    					}
                    })
                   }
    			},
    			error:function error(xhr,status,error)
    			{
    				console.log('status - error'+xhr);
    				console.log("status......"+error);
    				console.log("status......"+status);
    				//Chat_Operation();
    			}
    		});
    }

</script>
<body>
<form:form action=""  modelAttribute="nomiCustomerInfo">
	<br>
	<div>
<table align="center">
    <tr>
        <!-- <td>Token :</td> -->
        <td><%-- <form:input path="csrfToken" />${model.csrfToken} --%>
        	<%-- <form:hidden path="csrfToken" />${model.csrfToken} --%>
        </td>
    </tr>
    <tr>
        <!-- <td>JsessionId :</td> -->
        <td><%-- <form:input path="jSessionId" />${model.jSessionId} --%>
       <%--  <form:hidden path="jSessionId" />${model.jSessionId} --%>
        </td>
    </tr>
    <!-- <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr> -->
</table>  
</div>
	
	
        	<div>
        	<div><p style="text-align:center;"><span style="font-family:Verdana;font-size:12px;font-weight:bold;font-style:normal;text-decoration:none;color:#104070;">Welcome to Barclays Online Chat.</span></p>
				<p style="text-align:center;"><span style="font-family:Verdana;font-size:12px;font-weight:bold;font-style:normal;text-decoration:none;color:#104070;text-decoration:none;">&nbsp;</span></p>
				<p style="text-align:center;"><span style="font-family:Verdana;font-size:12px;font-weight:normal;font-style:normal;text-decoration:none;color:#104070;">Please provide us with a few details and we'll connect you with an advisor.</span></p><p style="text-align:center;"><span style="font-family:Verdana;font-size:12px;font-weight:normal;font-style:normal;text-decoration:none;color:#104070;text-decoration:none;">&nbsp;</span></p>
			</div>
			<br>
			<div class="chatarea content_accessibility access_contrast" id="chatarea" align="center"></div>
			<br>
            <div align="center">
                <div>
                     <label for="txtUserName">Your Name</label>
                   <!--  <input type="text" name="username" id="txtUserName" value="Please type in your name"/> -->
                   <form:input path="custName" />
                </div>
                <label for="taCapDetails">Your Question</label>
               <!--  <textarea id="taCapDetails" rows="4" cols="50">Please type in your question</textarea> -->               
               <form:textarea path="question" />
            </div>
            <div>
                <div align="center">255 characters left</div>
                <div>
                	<div style="text-align:center"><input type="button" name="Send" value="Send" onclick="CheckAgentPickedOrNot();"/></div>
                </div>
            </div>
            </div>
<%-- <div align="center">
<table border="1px" bordercolor="black" width=80% align="center">
                <tr>
                    <td>Agent/Guest</td>
                    <td>Message</td>
                </tr>
                <c:forEach items="${model.chatList}" var="element">
                    <tr>
                        <td><c:out
							value="${element.agentOrGuest}" /></td>
                        <td><c:out value="${element.message}" /></td>
                        <td>${element.agentOrGuest}</td>
                        <td>${element.message}</td>
                        
                    </tr>
                </c:forEach>
            </table>
</div> --%>
<!-- <div class="chatarea content_accessibility access_contrast" id="chatarea">
</div> -->
	</form:form>
</body>
</html>
