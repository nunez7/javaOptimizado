<%-- 
    Document   : Error
    Created on : 29/09/2018, 11:40:11 AM
    Author     : nunez-pc
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Página de error</title>
    </head>
    <body>
        Ha ocurrido un error en la aplicacion :<%=exception.getMessage()%>
        Error Interno:<%=exception.getCause().getMessage()%>
    </body>
</html>
