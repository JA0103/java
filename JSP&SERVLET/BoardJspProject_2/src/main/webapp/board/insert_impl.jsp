<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.it.dao.*"%>
<jsp:useBean id="dao" class="com.it.dao.BoardDAO"/>

<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="vo" class="com.it.dao.BoardVO">
	<jsp:setProperty property="*" name="vo"/>
</jsp:useBean>

<%
	dao.boardInsert(vo);
	response.sendRedirect("list.jsp");
%>