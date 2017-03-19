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
                    <th>Id Version</th>
                    <th>Numero Version</th>
                    <th>Fecha Version</th>
                    <th>Nombre Producto</th>                    
                </tr>
            </thead>
            <tbody id="${idTable}"
                   data-display="${displayResult}"
                   data-actual-state="${lastSearch}page=${page}"
                   data-url-receiver="${urlServlet}">
                <c:forEach items="${contentTable}" var="version" >
                    <tr data-id="${version.getId()}" 
                        data-data-table="${idTable}">
                        <td>${version.getId()}</td>
                        <td>${version.getNumero()}</td>
                        <td>${version.getFecha()}</td>
                        <td>${version.getProducto().getNombre()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>