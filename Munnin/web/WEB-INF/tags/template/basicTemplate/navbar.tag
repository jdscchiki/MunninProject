<%-- 
    Document   : navbar
    Created on : 22/02/2017, 07:54:37 PM
    Author     : Juan David Segura
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="navbar of basicTemplate" pageEncoding="UTF-8"%>
<%@tag import="model.bean.Funcionario" %>
<%@taglib prefix="navbarLinks" tagdir="/WEB-INF/tags/template/basicTemplate/navbarLinks"%>

<%@attribute name="funcionario" required="true" type="Funcionario"%>
<%@attribute name="actualRole" required="true" type="Integer"%>
<%@attribute name="actualPage" required="true" type="Integer"%>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar" style="padding-top: 1px;padding-bottom: 0px;padding-left: 5px;padding-right: 5px;margin-right: 12px;">
                <div class="containerBtn" onclick="myFunction(this)" style="padding-right: 0px;padding-left: 0px;">
                    <div class="bar1"></div>
                    <div class="bar2"></div>
                    <div class="bar3"></div>
                </div>
            </button>
            <img class="navbar-brand" src="${pageContext.request.contextPath}/resources/img/LogoNavbar.png" alt="munnin-logo" style="padding: 7px 7px;">
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <c:choose>
                    <c:when test="${actualRole == 0}" >
                        <navbarLinks:general actualPage="${actualPage}"/>
                    </c:when>
                    <c:when test="${actualRole == 1}" >
                        <navbarLinks:administrator actualPage="${actualPage}"/>
                    </c:when>
                    <c:when test="${actualRole == 2}" >
                        <navbarLinks:coordinator actualPage="${actualPage}"/>
                    </c:when>
                    <c:when test="${actualRole == 3}" >
                        <navbarLinks:technical actualPage="${actualPage}"/>
                    </c:when>
                    <c:when test="${actualRole == 4}" >
                        <navbarLinks:pedagogical actualPage="${actualPage}"/>
                    </c:when>
                    <c:when test="${actualRole == 5}" >
                        <navbarLinks:instructor actualPage="${actualPage}"/>
                    </c:when>
                    <c:otherwise>
                        <navbarLinks:general actualPage="${actualPage}"/>
                    </c:otherwise>
                </c:choose>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a data-toggle="popover" data-placement="bottom" title="funciona!" data-content="Aqui irian las notificaciones."><span class="glyphicon glyphicon-bell"></span></a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> ${funcionario.getNombre()}</a>
                    <ul class="dropdown-menu ">
                        <li><a ><span class="glyphicon glyphicon-cog"></span> Editar Perfil</a></li>
                        <li><a data-toggle="modal" data-target="#changePassword"><i class="fa fa-shield" aria-hidden="true"> </i>Cambio de contraseña</a></li>
                    </ul>
                </li>
                <li><a href="#vtn" data-toggle="modal"><span class="glyphicon glyphicon-log-in"></span> Salir</a></li>
            </ul>
        </div>
    </div>
</nav>