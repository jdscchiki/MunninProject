<%-- 
    Document   : error
    Created on : 30/10/2016, 10:57:13 PM
    Author     : Juan David Segura Castro <JBadCode>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Munnin Error</title>
    </head>
    <body>
        <h1>Munnin</h1>
        <p>Lo sentimos, a ocurrido un error</p>
        <p>
            <%
                if (request.getAttribute("Mensaje") != null) {
            %>
            ${Mensaje}
            <%
                }
            %>
        </p>
    </body>
</html>
