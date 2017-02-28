<%-- 
    Document   : message
    Created on : 26/02/2017, 07:36:26 PM
    Author     : Juan David Segura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<!DOCTYPE html>
<html>
    <body>
        <template:message message="${message}"
                          type="${messageType}"/>
    </body>
</html>
