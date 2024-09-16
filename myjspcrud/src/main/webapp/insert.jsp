<%@ page import="myjspcrud.dao,myjspcrud.pojo" %>
<jsp:useBean id="u" class="myjspcrud.pojo" scope="page" />
<jsp:setProperty property="*" name="u" />

<%
    
        dao.datainsert(u);
        response.sendRedirect("view.jsp");
   
%>
