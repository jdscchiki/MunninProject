<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" session="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
    </head>
    <body>
        <h3>La sesión de usuario ha caducado.</h3>
        <p>Por favor ingrese de nuevo en el siguiente enlace. <a href="${pageContext.request.contextPath}/index.jsp">Ingresar</a></p>
    </body>
</html>