<%-- 
    Document   : listMessage
    Created on : 22/02/2017, 10:03:39 PM
    Author     : Juan David Segura
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag import="java.util.ArrayList"%>
<%@tag import="model.dao.RolDAO"%>
<%@tag description="Model for notifications" pageEncoding="UTF-8"%>

<%@attribute name="notifications" required="true" type="ArrayList"%>

<div class="list-group">
    <c:forEach items="${notifications}" var="notification">
        <c:choose>
            <c:when test="${notification.getRol().getId() == 2 && notification.getMensaje().getId() == 7}" >
                <a href="${pageContext.request.contextPath}/home/role/coordinator/authorize.jsp?notification=${notification.getId()}" class="list-group-item ${notification.isVisto()?"":"list-group-item-info"}">${notification.getMensaje().getTexto()}</a>
            </c:when>
            <c:when test="${notification.getRol().getId() == 3 && notification.getMensaje().getId() == 8}" >
                <a href="${pageContext.request.contextPath}/home/role/technical/qualify.jsp?notification=${notification.getId()}" class="list-group-item ${notification.isVisto()?"":"list-group-item-info"}">${notification.getMensaje().getTexto()}</a>
            </c:when>
            <c:when test="${notification.getRol().getId() == 4 && notification.getMensaje().getId() == 8}" >
                <a href="${pageContext.request.contextPath}/home/role/pedagogical/qualify.jsp?notification=${notification.getId()}" class="list-group-item ${notification.isVisto()?"":"list-group-item-info"}">${notification.getMensaje().getTexto()}</a>
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