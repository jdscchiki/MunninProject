<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tables" tagdir="/WEB-INF/tags/template/basicTemplate/tables" %>

<tables:dataTable displayResult="${displayResult}"
                  idTable="${idTable}"
                  lastSearch="${lastSearch}"
                  page="${page}"
                  pages="${pages}"
                  urlServlet="${urlServlet}">
    <jsp:attribute name="thead">
        <th>Documento</th>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Correo</th>
    </jsp:attribute>
    <jsp:attribute name="tbody">
        <c:forEach items="${contentTable}" var="funcionario" >
            <tables:dataTableContentRow idRow="${funcionario.getId()}" 
                                        idTable="${idTable}">
                <td>${funcionario.getDocumento()}</td>
                <td>${funcionario.getNombre()}</td>
                <td>${funcionario.getApellido()}</td>
                <td>${funcionario.getCorreo()}</td>
            </tables:dataTableContentRow>
        </c:forEach>
    </jsp:attribute>
</tables:dataTable>
