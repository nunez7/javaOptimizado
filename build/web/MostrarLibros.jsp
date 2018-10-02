<%-- 
    Document   : MostrarLibros
    Created on : 27/09/2018, 08:53:52 PM
    Author     : nunez-pc
--%>
<%@page import="java.util.List"%>
<%@page import="com.nunez.Libro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="/Error.jsp"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Lista de libros</title>
    </head>
    <body>
        <form name="filtroCategoria" action="Filtrar.do">
            <select name="categoria">
                <option value="seleccionar">Seleccionar</option>
                <%
                    List<String> listaDeCategorias = null;
                    if (request.getAttribute("listaDeCategorias") != null) {
                        listaDeCategorias = (List<String>) request.getAttribute("listaDeCategorias");
                        for (String categoria : listaDeCategorias) {
                            if (categoria.equals(request.getParameter("categoria"))) {
                %>
                <option value="<%=categoria%>" selected ><%=categoria%></option>
                <% } else {%>
                <option value="<%=categoria%>"  ><%=categoria%></option>
                <%}
                        }
                    }%>
            </select>
            <input type="submit" value="Filtrar">

        </form>
        <br/>
        <%
            if (request.getAttribute("listaDeLibros") != null) {
                List<Libro> listaDeLibros = (List<Libro>) request.getAttribute("listaDeLibros");
                for (Libro libro : listaDeLibros) {%>
        <%=libro.getIsbn()%>
        <%=libro.getTitulo()%>
        <%=libro.getCategoria()%>
        <a href="BorrarLibro.do?isbn=<%=libro.getIsbn()%>">Borrar</a>
        <a href="FormularioEditarLibro.do?isbn=<%=libro.getIsbn()%>">Editar</a>
        <br/>
        <% }
            }
        %>
        <a href="FormularioInsertarLibro.do">Insertar Libro</a>
    </body>
</html>
