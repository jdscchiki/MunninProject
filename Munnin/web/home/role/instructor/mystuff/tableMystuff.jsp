<%-- 
    Document   : tableMystuff
    Created on : 18/04/2017, 07:25:54 PM
    Author     : Monica
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>

<template:paginate actualPage="${page}"
                   pages="${pages}"
                   search="${lastSearch}"
                   servlet="${urlServlet}"
                   displayResult="${displayResult}"/>
<div class="container-fluid">
    <div class="table-responsive">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>N�mero Version</th>
                    <th>Estado Version</th>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                    <th>Palabras clave</th>
                </tr>
            </thead>
            <tbody id="${idTable}"
                   data-display="${displayResult}"
                   data-actual-state="${lastSearch}page=${page}"
                   data-url-receiver="${urlServlet}">
                <c:forEach items="${contentTable}" var="producto" >
                    <tr data-id="${producto.getVersiones().get(0).getId()}" 
                        data-data-table="${idTable}">
                        <td>${producto.getVersiones().get(0).getNumero()}</td>
                        <td>${producto.getVersiones().get(0).getEstado().getNombre()}</td>
                        <td>${producto.getNombre()}</td>
                        <td>${producto.getDescripcion()}</td>
                        <td>${producto.getPalabrasClave()}</td>
                        
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>