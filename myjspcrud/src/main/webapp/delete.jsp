<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="myjspcrud.dao,myjspcrud.pojo" %>
<jsp:useBean id="u" class="myjspcrud.pojo" scope="page" />
<jsp:setProperty property="*" name="u" />

<%
    
        dao.datadelete(u);
        response.sendRedirect("view.jsp");
   
%>