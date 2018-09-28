<%-- 
    Document   : FormularioInsertarLibro
    Created on : 27/09/2018, 08:48:17 PM
    Author     : nunez-pc
--%>
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
                    <input id="isbn" type="text" name="isbn"/></p>
                <p>
                    <label for="titulo">Titulo:</label>
                    <input id="titulo" type="text" name= "titulo"/>
                </p><p>
                    <label for="categoria">Categoria :</label>
                    <input id="categoria" type="text" name="categoria"/>
                </p>
                <p>
                    <input type="submit" value="Insertar" onclick="validacion()"/>
                </p>
            </fieldset>
        </form>
    </body>
</html>
