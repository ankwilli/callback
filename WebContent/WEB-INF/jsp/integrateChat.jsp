<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IntegrationWithChatGateway</title>
</head>
<body>
<div align="center"><h2>Integration With ChatGateway</h2></div>
<%-- ${message} --%>
	<br>
	<br>
	<div style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align:center;">
		Nomi web chat gateway
	</div>
<div align="center">
<table border="1px" bordercolor="black" width=80% align="center">
                <tr>
                    <td>Agent/Guest</td>
                    <td>Message</td>
                </tr>
                <c:forEach items="${model.chatList}" var="element">
                    <tr>
                       <%--  <td><c:out
							value="${element.agentOrGuest}" /></td>
                        <td><c:out value="${element.message}" /></td> --%>
                        <td>${element.agentOrGuest}</td>
                        <td>${element.message}</td>
                        
                    </tr>
                </c:forEach>
            </table>
</div>
</body>
</html>