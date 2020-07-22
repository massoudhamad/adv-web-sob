<%--
  Created by IntelliJ IDEA.
  User: massoudhamad
  Date: 15/07/2020
  Time: 09:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>E-Shop Chwaka</title>
  </head>
  <body>
<h3>E-Book Search</h3>
  <form method="get" action="EBookServlet">
    Choose an author:
    <input type="checkbox" name="author" value="Khaitham" />Khaitham
    <input type="checkbox" name="author" value="Mohammad Ali" />Ali
    <input type="checkbox" name="author" value="Kumar" />Kumar
    <br /><br />
    Choose a price range:
    <input type="radio" name="price" value="50" checked />less than $50
    <input type="radio" name="price" value="100" />less than $100
    <br /><br />
    <input type="submit" value="Search" />
    <input type="reset" value="Clear" />
  </form>
  </body>
</html>
