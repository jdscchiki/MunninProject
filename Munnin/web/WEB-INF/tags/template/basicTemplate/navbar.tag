<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="navbar of basicTemplate" pageEncoding="UTF-8"%>
<%@tag import="model.bean.Funcionario" %>
<%@taglib prefix="navbarLinks" tagdir="/WEB-INF/tags/template/basicTemplate/navbarLinks"%>

<%@attribute name="funcionario" required="true" type="Funcionario"%>
<%@attribute name="actualRole" required="true" type="Integer"%>
<%@attribute name="actualPage" required="true" type="Integer"%>

<div class="container-fluid top">
    <img src="${pageContext.request.contextPath}/resources/img/logo_sena.png" alt="sena_icono" class="topIconoS">
    <img src="${pageContext.request.contextPath}/resources/img/logo-completo.png" alt="munnin_icono" class="topIconoM">
</div>
<nav class="navbar navbar-inverse" data-spy="affix" data-offset-top="112">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>                        
            </button>
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
                        <li><a data-toggle="modal" data-target="#changePassword"><span class="glyphicon glyphicon-cog"></span> Editar Perfil</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-credit-card"></span> Calendario</a></li>
                        <li><a href="#" data-toggle="modal"><span class="fa fa-question-circle-o glyphicon"></span> Preguntas Frecuentes</a></li>
                    </ul>
                </li>
                <li><a href="#vtn" data-toggle="modal"><span class="glyphicon glyphicon-log-in"></span> Salir</a></li>
            </ul>
        </div>
    </div>
</nav>