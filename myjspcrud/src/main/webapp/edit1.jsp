<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="myjspcrud.dao,myjspcrud.pojo,java.util.*"%>


<jsp:useBean id="u" class="myjspcrud.pojo" scope="page" />
<jsp:setProperty property="*" name="u" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


   <%
   
    String s= request.getParameter("id");
    
   
      pojo p= dao.getdatafetchbyid(Integer.parseInt(s));
   
   out.println(s);
   
 
   %>



  
  <form name="form" method="get" action="edit.jsp">
  
   <input type="hidden" name="id" value="<%= p.getId() %>"><br><br>

   
   
  Enter your name :- <input type="text" name="name" value="<%= p.getName()%>"><br><br>
  
  Enter your email :- <input type="text" name="email" value="<%= p.getEmail()%>"><br><br>
  
  Enter your password :- <input type="text" name="pass" value="<%= p.getPass()%>"><br><br>
  
  
  <input type="submit" value="registration"><br><br>
  
  
  </form>
  
    <a href="view.jsp">View user</a>
  
 



</body>
</html>