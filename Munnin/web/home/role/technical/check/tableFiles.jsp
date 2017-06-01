<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tables" tagdir="/WEB-INF/tags/template/basicTemplate/tables" %>

<tables:dataTableSingleAction displayResult="${displayResult}"
                              idTable="${idTable}"
                              lastSearch="${lastSearch}"
                              page="${page}"
                              pages="${pages}"
                              urlServlet="${urlServlet}"
                              actionDisplay="message_file"
                              actionUrl="${pageContext.request.contextPath}/home/role/technical/check/select">
    <jsp:attribute name="thead">
        <th>Id Version</th>
        <th>Numero Version</th>
        <th>Fecha Version</th>
        <th>Nombre Producto</th> 
        </jsp:attribute>
        <jsp:attribute name="tbody">
            <c:forEach items="${contentTable}" var="version" >
                <tables:dataTableContentRow idRow="${version.getId()}" 
                                            idTable="${idTable}">
                <td>${version.getId()}</td>
                <td>${version.getNumero()}</td>
                <td>${version.getFecha()}</td>
                <td>${version.getProducto().getNombre()}</td>
            </tables:dataTableContentRow>
        </c:forEach>
    </jsp:attribute>
</tables:dataTableSingleAction>