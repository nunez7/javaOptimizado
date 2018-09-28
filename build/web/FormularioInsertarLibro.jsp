<%-- 
    Document   : FormularioInsertarLibro
    Created on : 27/09/2018, 08:48:17 PM
    Author     : nunez-pc
--%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.nunez.DataBaseHelper"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Formulario Libro</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <script type="text/javascript" src="js/validacion.js"></script>
    </head>
    <body>
        <form action="InsertarLibro.jsp" onsubmit="return validacion();" >
            <fieldset>
                <legend>Formulario alta libro</legend>
                <p><label for="isbn">ISBN:</label>
                    <input id="isbn" type="text" name="isbn" required/></p>
                <p>
                    <label for="titulo">Titulo:</label>
                    <input id="titulo" type="text" name= "titulo" required/>
                </p><p>
                    <select name="categoria" required>
                        <option value="">Seleccionar</option>
                        <%
                            ResultSet rs = null;
                            try {
                                String consultaSQL = "select distinct(categoria) from Libros";
                                DataBaseHelper helper = new DataBaseHelper();
                                rs = helper.seleccionarRegistros(consultaSQL);
                                while (rs.next()) {%>
                        <option value="<%=rs.getString("categoria")%>">
                            <%=rs.getString("categoria")%></option>
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
                                }%>
                    </select>
                    <br/>
                </p>
                <p>
                    <input type="submit" value="Insertar" onclick="validacion()"/>
                </p>
            </fieldset>
        </form>
    </body>
</html>
