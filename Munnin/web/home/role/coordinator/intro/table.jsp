<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>


<div class="col-lg-12">
    <div class="list-group">
    <c:forEach items="${contentTable}" var="notificacion">
        <a href="${pageContext.request.contextPath}/home/role/coordinator/authorize.jsp?notification=${notificacion.getId()}" class="list-group-item ${notificacion.isVisto()?"":"list-group-item-info"}">${notificacion.getMensaje().getTexto()}</a>
    </c:forEach>
    </div>
</div>

<div class="col-lg-12">
    <template:paginate actualPage="${page}"
                       pages="${pages}"
                       search="${lastSearch}"
                       servlet="${urlServlet}"
                       displayResult="${displayResult}"/>
</div>