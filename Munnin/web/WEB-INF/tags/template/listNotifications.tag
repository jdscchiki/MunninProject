<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag import="java.util.ArrayList"%>
<%@tag import="model.dao.RolDAO"%>
<%@tag description="Model for notifications" pageEncoding="UTF-8"%>

<%@attribute name="notifications" required="true" type="ArrayList"%>

<div class="list-group">
    <c:forEach items="${notifications}" var="notification">
        <c:choose>
            <c:when test="${notification.getRol().getId() == 2 && notification.getMensaje().getId() == 7}" >
                <a href="${pageContext.request.contextPath}/home/role/coordinator/files.jsp?notification=${notification.getId()}" class="list-group-item ${notification.isVisto()?"":"list-group-item-info"}">${notification.getMensaje().getTexto()}</a>
            </c:when>
            <c:when test="${notification.getRol().getId() == 3 && notification.getMensaje().getId() == 8}" >
                <a href="${pageContext.request.contextPath}/home/role/technical/check.jsp?notification=${notification.getId()}" class="list-group-item ${notification.isVisto()?"":"list-group-item-info"}">${notification.getMensaje().getTexto()}</a>
            </c:when>
            <c:when test="${notification.getRol().getId() == 4 && notification.getMensaje().getId() == 8}" >
                <a href="${pageContext.request.contextPath}/home/role/pedagogical/check.jsp?notification=${notification.getId()}" class="list-group-item ${notification.isVisto()?"":"list-group-item-info"}">${notification.getMensaje().getTexto()}</a>
            </c:when>
            <c:when test="${notification.getRol().getId() == 5 && (
                            notification.getMensaje().getId() == 1 ||
                            notification.getMensaje().getId() == 2 ||
                            notification.getMensaje().getId() == 3 ||
                            notification.getMensaje().getId() == 4 ||
                            notification.getMensaje().getId() == 5 ||
                            notification.getMensaje().getId() == 6 
                            )}" >
                <a href="${pageContext.request.contextPath}/home/role/instructor/mystuff.jsp?notification=${notification.getId()}" class="list-group-item ${notification.isVisto()?"":"list-group-item-info"}">${notification.getMensaje().getTexto()}</a>
            </c:when>
            <c:otherwise>
                ERROR
            </c:otherwise>
        </c:choose>
    </c:forEach>
</div>