<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tables" tagdir="/WEB-INF/tags/template/basicTemplate/tables" %>
<tables:dataTable displayResult="${displayResult}"
                  idTable="${idTable}"
                  lastSearch="${lastSearch}"
                  page="${page}"
                  pages="${pages}"
                  urlServlet="${urlServlet}">
    <jsp:attribute name="thead">
        <th>Id Lista</th>
        <th>Nombre Lista</th>
        <th>Descripcion Lista</th>
        <th>Fecha Lista</th>  
        </jsp:attribute>
        <jsp:attribute name="tbody">
            <c:forEach items="${contentTable}" var="lista" >
                <tables:dataTableContentRow idRow="${lista.getId()}" 
                                            idTable="${idTable}">
                <td>${lista.getId()}</td>
                <td>${lista.getNombre()}</td>
                <td>${lista.getDescripcion()}</td>
                <td>${lista.getFecha()}</td>
            </tables:dataTableContentRow>
        </c:forEach>
    </jsp:attribute>
</tables:dataTable>