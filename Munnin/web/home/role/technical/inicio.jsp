<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" session="false"%>
<%-- esto se usa en el top para dar propiedades segun la pagina--%>
<%
    request.setAttribute("title", "Munnin E. Técnico");
    request.setAttribute("navbar", 6);
    request.setAttribute("mainPage", 1);
%>
<jsp:include page="/elements/content/top.jsp" />
<%-- todo el contnido aqui--%>

<jsp:include page="/elements/content/bot.jsp" />