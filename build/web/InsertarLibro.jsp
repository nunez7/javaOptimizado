<%-- 
    Document   : InsertarLibro
    Created on : 27/09/2018, 08:49:55 PM
    Author     : nunez-pc
--%>
<%@page import="com.nunez.DataBaseException"%>
<%@page import="com.nunez.Libro"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%
    String isbn = request.getParameter("isbn");
    String titulo = request.getParameter("titulo");
    String categoria = request.getParameter("categoria");
//realizo la consulta usando el DBHelper y el codigo queda simplificado
    Libro libro = new Libro(isbn, titulo, categoria);
    libro.insertar();
    response.sendRedirect("MostrarLibros.jsp");
%>