<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>

<template:paginate actualPage="${page}"
                   pages="${pages}"
                   search="${lastSearch}"
                   servlet="${pageContext.request.contextPath}/home/role/coordinator/pagerFunctionary"
                   displayResult="${diplayResult}"/>
<div class="container-fluid">
    <div class="table-responsive">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Documento</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Correo</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${contentTable}" var="funcionario" >
                    <tr data-id="${funcionario.getId()}">
                        <td>${funcionario.getDocumento()}</td>
                        <td>${funcionario.getNombre()}</td>
                        <td>${funcionario.getApellido()}</td>
                        <td>${funcionario.getCorreo()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>