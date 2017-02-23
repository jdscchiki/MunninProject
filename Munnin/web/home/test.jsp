<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<%
    ArrayList array = new ArrayList();
    array.add("hola 1");
    array.add("hola 2");
    request.setAttribute("message", array);
%>

<template:basicTemplate title="test"
                        funcionario="${sessionScope.usuario}"
                        actualRole="2"
                        actualPage="1"
                        panelTitle="Administrar">
    <jsp:attribute name="aditionalJS">

    </jsp:attribute>

    <jsp:body>
        <p>hola</p>
        <template:message message="hola" type="info" />
        <template:htmlMessage type="info">
            <jsp:attribute name="message">
                <p>hola</p>
                <p>hola</p>
            </jsp:attribute>
        </template:htmlMessage>
        <template:listMessage messages="${message}" type="info" />
    </jsp:body>


</template:basicTemplate>