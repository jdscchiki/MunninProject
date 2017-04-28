<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>

<div class="col-lg-12">
    <div class="table-responsive">
        <table class="table">
            <thead>
                <tr>
                    <th>Documento</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Correo</th>
                </tr>
            </thead>
            <tbody id="${idTable}"
                   data-display="${displayResult}"
                   data-actual-state="${lastSearch}page=${page}"
                   data-url-receiver="${urlServlet}">
                <c:forEach items="${contentTable}" var="funcionario" >
                    <tr data-id="${funcionario.getId()}" 
                        data-data-table="${idTable}">
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
<div class="col-lg-12">
    <template:paginate actualPage="${page}"
                       pages="${pages}"
                       search="${lastSearch}"
                       servlet="${urlServlet}"
                       displayResult="${displayResult}"/>
</div>