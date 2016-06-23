<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Welcome To Barclays Chat App</title>
<style type="text/css">

</style>
</head>
<body>
<form:form action="/IntegrateChatGatewayPOC/startChat.html" modelAttribute="nomiChatGatewayRequest">
<div><img style="position: absolute; margin-left: -269px;" src="/img/logo.jpg"></div>
<div><p style="text-align:center;"><span style="font-family:Verdana;font-size:12px;font-weight:bold;font-style:normal;text-decoration:none;color:#104070;">Welcome to Barclays Online Chat.</span></p>
<p style="text-align:center;"><span style="font-family:Verdana;font-size:12px;font-weight:bold;font-style:normal;text-decoration:none;color:#104070;text-decoration:none;">&nbsp;</span></p>
<p style="text-align:center;"><span style="font-family:Verdana;font-size:12px;font-weight:normal;font-style:normal;text-decoration:none;color:#104070;">Please provide us with a few details and we'll connect you with an advisor.</span></p><p style="text-align:center;"><span style="font-family:Verdana;font-size:12px;font-weight:normal;font-style:normal;text-decoration:none;color:#104070;text-decoration:none;">&nbsp;</span></p>
</div>
<!-- <div><p style="text-align:center;"><span style="font-family:Verdana;font-size:12px;font-weight:normal;font-style:normal;text-decoration:none;color:#104070;">Enter Your Name</span>: <input id="name" type=text value=""></p> <br/>
</div>
<div><p style="text-align:center;"><span style="font-family:Verdana;font-size:12px;font-weight:normal;font-style:normal;text-decoration:none;color:#104070;">What would you like to chat about?</span> : <input id="subject" type=text value="" ></p> <br/>
</div> -->
<div>
<table align="center">
    <tr>
        <td>Name :</td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td>What would you like to chat about? :</td>
        <td><form:input path="subject" /></td>
    </tr>
    <!-- <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr> -->
</table>  
</div>
<br>
<div style="text-align:center"><h3><input type="submit" value="Start Chat"></h3></div>
</form:form>
</body>
</html>