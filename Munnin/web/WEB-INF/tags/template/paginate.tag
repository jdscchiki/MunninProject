<%-- 
    Document   : message
    Created on : 26/02/2017, 04:22:43 PM
    Author     : Juan David Segura
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag import="java.util.ArrayList"%>
<%@tag description="usual message model of the application" pageEncoding="UTF-8"%>

<%@attribute name="search" required="false" type="String"%>
<%@attribute name="pages" required="true" type="ArrayList<Integer>"%>
<%@attribute name="actualPage" required="true"%>
<%@attribute name="servlet" required="true"%>
<%@attribute name="displayResult" required="true"%>

<ul class="pagination" data-servlet="${servlet}" data-display="${displayResult}">
    <c:forEach items="${pages}" var="page" >
        <li class="${(actualPage==page)?'active':''}">
            <a data-link-page="${search}page=${page}">${page}</a>
        </li>
    </c:forEach>
</ul>