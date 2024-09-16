<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user data</title>
</head>
<body>
<%@ page import="myjspcrud.dao,myjspcrud.pojo,java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="n" %>
<%
    List<pojo> h=dao.getalldata();
    request.setAttribute("h", h);
%>
<table border="1">
<tr>
<th>id</th>
<th>Name</th>
<th>Email</th>
<th>Password</th>
<th>Action</th>
<th>Action</th>
</tr>
<n:forEach items="${h}" var="j">
<tr>
<th>${j.getId()}</th>
<th>${j.getName()}</th>
<th>${j.getEmail()}</th>
<th>${j.getPass()}</th>
<th><a href="delete.jsp?id=${j.getId()}">Delete</a></th>
<th><a href="edit1.jsp?id=${j.getId()}">Edit</a></th>
</tr>
</n:forEach>
</table>


</body>
</html>