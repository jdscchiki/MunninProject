<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>

<div class="col-lg-12">
    <template:paginate actualPage="${page}"
                       pages="${pages}"
                       search="${lastSearch}"
                       servlet="${urlServlet}"
                       displayResult="${displayResult}"/>
</div>
<div class="col-lg-12">
    <div class="table-responsive">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Area</th>
                </tr>
            </thead>
            <tbody id="${idTable}"
                   data-display="${displayResult}"
                   data-actual-state="${lastSearch}page=${page}"
                   data-url-receiver="${urlServlet}">
                <c:forEach items="${contentTable}" var="program" >
                    <tr data-id="${program.getId()}" 
                        data-data-table="${idTable}">
                        <td>${program.getNombre()}</td>
                        <td>${program.getArea().getNombre()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>