<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" session="false"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Munnin Error</title>
        <meta charset="utf-8">
    </head>
    <body>
            <h1>Munnin</h1>
            <p>Lo sentimos, a ocurrido un error</p>
            <p>
            <%
                    if (request.getAttribute("mensaje") != null) {
            %>
            ${mensaje}
            <%
                }
            %>
        </p>
    </body>
</html>
