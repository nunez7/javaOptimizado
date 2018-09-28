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
        <%List<Libro> listaDeLibros = null;
            if (request.getParameter("categoria") == null || request.getParameter("categoria").equals("")) {
                listaDeLibros = Libro.buscarTodos();
            } else {
                listaDeLibros = Libro.buscarPorCategoria(request.getParameter("categoria"));
            }
            for (Libro libro : listaDeLibros) {%>
        <%=libro.getIsbn()%>
        <%=libro.getTitulo()%>
        <%=libro.getCategoria()%>
        <a href="BorrarLibro.jsp?isbn=<%=libro.getIsbn()%>">Borrar</a>
        <a href="FormularioEditarLibro.jsp?isbn=<%=libro.getIsbn()%>">Editar</a>
        <br/>
        <% }
        %>
        <a href="FormularioInsertarLibro.jsp">Insertar Libro</a>
    </body>
</html>
