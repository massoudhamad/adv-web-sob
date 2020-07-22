<%--
  Created by IntelliJ IDEA.
  User: massoudhamad
  Date: 22/07/2020
  Time: 08:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.mvc.LoginBean"%>
<html>
<head>
    <title>Login Success Page</title>
</head>
<body>
<p>You are successfully logged in!</p>
<%
    LoginBean bean=(LoginBean)request.getAttribute("bean");
    out.print("Welcome, "+bean.getName());
%>
</body>
</html>
