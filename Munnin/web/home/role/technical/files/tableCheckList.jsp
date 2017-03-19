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
                    <th>Id Lista</th>
                    <th>Numero Lista</th>
                    <th>Descripcion Lista</th>
                    <th>Fecha Lista</th>                    
                </tr>
            </thead>
            <tbody id="${idTable}"
                   data-display="${displayResult}"
                   data-actual-state="${lastSearch}page=${page}"
                   data-url-receiver="${urlServlet}">
                <c:forEach items="${contentTable}" var="version" >
                    <tr data-id="${listas.getId()}" 
                        data-data-table="${idTable}">
                        <td>${listas.getId()}</td>
                        <td>${listas.getNombre()}</td>
                        <td>${listas.getDescripcion()}</td>
                        <td>${listas.getFecha()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>