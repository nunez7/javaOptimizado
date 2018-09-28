<%-- 
    Document   : BorrarLibro
    Created on : 28/09/2018, 08:05:05 AM
    Author     : nunez-pc
--%>
<%@page import="com.nunez.Libro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String isbn= request.getParameter("isbn");
Libro libro= new Libro(isbn);
libro.borrar();
response.sendRedirect("MostrarLibros.jsp");
%>
