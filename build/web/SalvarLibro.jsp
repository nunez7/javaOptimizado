<%-- 
    Document   : SalvarLibro
    Created on : 28/09/2018, 08:18:59 AM
    Author     : nunez-pc
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.nunez.Libro"%>
<% String isbn= request.getParameter("isbn");
String titulo= request.getParameter("titulo");
String categoria= request.getParameter("categoria");
Libro libro= new Libro(isbn,titulo,categoria);
libro.salvar();
response.sendRedirect("MostrarLibros.jsp");
%>