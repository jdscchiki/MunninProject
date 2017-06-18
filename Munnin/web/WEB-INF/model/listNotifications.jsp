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
        <div class="col-lg-12">
            <template:listNotifications notifications="${contentTable}"/>
        </div>
        <div class="col-lg-12">
            <template:paginate actualPage="${page}"
                               pages="${pages}"
                               search="${lastSearch}"
                               servlet="${urlServlet}"
                               displayResult="${displayResult}"/>
        </div>
    </body>
</html>
