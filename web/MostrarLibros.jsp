<%-- 
    Document   : MostrarLibros
    Created on : 27/09/2018, 08:53:52 PM
    Author     : nunez-pc
--%>
<%@page import="java.util.List"%>
<%@page import="com.nunez.Libro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Lista de libros</title>
    </head>
    <body>
        <%List<Libro> listaDeLibros = Libro.buscarTodos();
            for (Libro libro : listaDeLibros) {%>
        <%=libro.getIsbn()%><%=libro.getTitulo()%><%=libro.getCategoria()%>
        <br/>
        <% }
        %>
        <a href="FormularioInsertarLibro.jsp">Insertar Libro</a>
    </body>
</html>
