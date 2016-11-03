<%-- 
    Document   : inicio
    Created on : 3/11/2016, 10:21:19 AM
    Author     : Juan David Segura Castro <JBadCode>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Munnin</title>
        <meta charset="utf-8">
        <jsp:include page="contenido/head.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="contenido/sidenav.jsp"></jsp:include>
            <div class="right">
            <jsp:include page="contenido/navbar.jsp"></jsp:include>
                <div class="container-fluid">
                    <p>Hola</p>
                </div>
            <jsp:include page="contenido/footer.jsp" ></jsp:include>
        </div>
    </body>
</html>
