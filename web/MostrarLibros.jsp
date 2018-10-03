<%-- 
    Document   : MostrarLibros
    Created on : 27/09/2018, 08:53:52 PM
    Author     : nunez-pc
--%>
<%@page import="java.util.List"%>
<%@page import="com.nunez.Libro"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="Error.jsp"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Lista de libros</title>
    </head>
    <body>
        <form name="filtroCategoria" action="FiltrarLibrosPorCategoria.do">
            <select name="categoria">
                <option value="seleccionar">Seleccionar</option>
                <c:forEach var="categoria" items="${listaDeCategorias}">
                    <option value="${categoria.cveCategoria}">
                        ${categoria.descripcion}
                    </option>
                </c:forEach>
            </select>
            <input type="submit" value="Filtrar">
        </form>
        <br/>
        <c:forEach var="libro" items="${listaDeLibros}">
            ${libro.isbn} ${libro.titulo} ${libro.categoria.descripcion}
            <a href="BorrarLibro.do?isbn=${libro.isbn}">Borrar</a>
            <a href="FormularioEditarLibro.do?isbn=${libro.isbn}">Editar</a>
            <br />
        </c:forEach>
        <a href="FormularioInsertarLibro.do">Insertar Libro</a>
    </body>
</html>
