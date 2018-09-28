<%-- 
    Document   : MostrarLibros
    Created on : 27/09/2018, 08:53:52 PM
    Author     : nunez-pc
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<%@page import="com.nunez.DataBaseHelper"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Lista de libros</title>
    </head>
    <body>
        <%
            ResultSet rs = null;
            try {
                //2 Creamos la consulta de selección
                String consultaSQL = "SELECT isbn,titulo,categoria FROM Libros";
                //3 y 4 Ejecutsettamos la sentencia y lo almacenamos en un resul
                DataBaseHelper helper = new DataBaseHelper();
                rs = helper.seleccionarRegistros(consultaSQL);
                //5 Recorre el ResultSet y lo imprime
                while (rs.next()) {%>
        <%=rs.getString("isbn")%>
        <%=rs.getString("titulo")%>
        <%=rs.getString("categoria")%>
        <br/>
        <% }
            } catch (SQLException e) {
                System.out.println("Error accediendo a la base de datos"
                        + e.getMessage());
            } finally {
                //6 Cierra los recursos
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        System.out.println("Error cerrando el resultset" + e.getMessage());
                    }
                }
            }
        %>
        <a href="FormularioInsertarLibro.jsp">Insertar Libro</a>
    </body>
</html>
