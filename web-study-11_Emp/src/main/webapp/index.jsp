<%@page import="util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%
	response.sendRedirect("EmpServlet?command=emp_list");
%>