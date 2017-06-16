<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tables" tagdir="/WEB-INF/tags/template/basicTemplate/tables" %>

<tables:dataTableSingleAction displayResult="${displayResult}"
                              idTable="${idTable}"
                              lastSearch="${lastSearch}"
                              page="${page}"
                              pages="${pages}"
                              urlServlet="${urlServlet}"
                              actionDisplay="message_Mystuff"
                              actionUrl="${pageContext.request.contextPath}/home/role/instructor/myStuff/ManageMystuff">
    <jsp:attribute name="thead">
        <th>Número Version</th>
        <th>Estado Version</th>
        <th>Nombre</th>
        <th>Descripcion</th>
        <th>Palabras clave</th>
        </jsp:attribute>
        <jsp:attribute name="tbody">
            <c:forEach items="${contentTable}" var="producto" >
                <tables:dataTableContentRow idRow="${producto.getVersiones().get(0).getId()}" 
                                            idTable="${idTable}">
                <td>${producto.getVersiones().get(0).getNumero()}</td>
                <td>${producto.getVersiones().get(0).getEstado().getNombre()}</td>
                <td>${producto.getNombre()}</td>
                <td>${producto.getDescripcion()}</td>
                <td><div class="tagcloud"><ul><c:forEach items="${producto.getPalabrasClave().split(';')}" var="keyword" ><li><div>${keyword}</div></li></c:forEach></ul></div></td>
            </tables:dataTableContentRow>
        </c:forEach>
    </jsp:attribute>
</tables:dataTableSingleAction>