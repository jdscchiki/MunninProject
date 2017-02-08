<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" session="false"%>
<%-- esto se usa en el top para dar propiedades segun la pagina--%>
<%
    request.setAttribute("title", "Munnin Instructor");
    request.setAttribute("navbar", 4);
    request.setAttribute("mainPage", 1);
%>
<jsp:include page="/elements/content/top.jsp" />

<form action="${URIInstructor}upload-file" method="POST" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="Subir">
</form>
${message}

<jsp:include page="/elements/content/bot.jsp" />