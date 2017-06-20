<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tables" tagdir="/WEB-INF/tags/template/basicTemplate/tables" %>

<tables:dataTable displayResult="${displayResult}"
                  idTable="${idTable}"
                  lastSearch="${lastSearch}"
                  page="${page}"
                  pages="${pages}"
                  urlServlet="${urlServlet}">
    <jsp:attribute name="thead">
        <th>Nombre</th>
        <th>Descripcion</th>
    </jsp:attribute>
    <jsp:attribute name="tbody">
        <c:forEach items="${contentTable}" var="list" >
            <tables:dataTableContentRow idRow="${list.getId()}" 
                                        idTable="${idTable}">
                <td>${list.getNombre()}</td>
                <td>${list.getDescripcion()}</td>
            </tables:dataTableContentRow>
        </c:forEach>
    </jsp:attribute>
</tables:dataTable>
