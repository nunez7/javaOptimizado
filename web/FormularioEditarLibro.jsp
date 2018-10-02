<%-- 
    Document   : FormularioEditarLibro
    Created on : 28/09/2018, 08:09:34 AM
    Author     : nunez-pc
--%>
<%@page import="java.util.List"%>
<%@page import="com.nunez.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Libro libro = Libro.buscarPorClave(request.getParameter("isbn"));%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Formulario Libro</title> 
        <!-- cabecera y javascript-->
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <script type="text/javascript" src="js/validacion.js"></script>
    </head>
    <body>
        <form id="formularioEdicion" action="SalvarLibro.do">
            <fieldset>
                <legend>Formulario alta libro</legend>
                <p><label for="isbn">ISBN:</label>
                    <input type="text" id="isbn" name="isbn" value="<%=libro.getIsbn()%>"/>
                </p>
                <p><label for="titulo">Titulo:</label>
                    <input type="text" id="titulo" name="titulo" value="<%=libro.getTitulo()%>" />
                </p>
                <p><label for="categoria">Categoria :</label>
                    <select name="categoria">
                        <%
                            List<String> listaDeCategorias = null;
                            listaDeCategorias = Libro.buscarTodasLasCategorias();
                            for (String categoria : listaDeCategorias) {
                                if (libro.getCategoria().equals(categoria)) {%>
                        <option value="<%=categoria%>" selected="selected">
                            <%=categoria%></option>
                            <%} else {%>
                        <option value="<%=categoria%>"><%=categoria%></option>
                        <% }
                            }%>
                    </select>
                    <br/>
                </p>
                <p><input type="submit" value="Salvar" /></p>
            </fieldset>
        </form>
    </body>
</html>
