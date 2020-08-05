<%--
  Created by IntelliJ IDEA.
  User: massoudhamad
  Date: 30/07/2020
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.employee.mvc.UserDao"%>
<jsp:useBean id="u" class="com.employee.mvc.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>
<%
    int i=UserDao.save(u);
    if(i>0){
        response.sendRedirect("adduser-success.jsp");
    }else{
        response.sendRedirect("adduser-error.jsp");
    }
%>
