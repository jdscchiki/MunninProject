<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="navbar of basicTemplate" pageEncoding="UTF-8"%>
<%@tag import="model.bean.Funcionario" %>
<%@taglib prefix="navbarLinks" tagdir="/WEB-INF/tags/template/basicTemplate/navbarLinks"%>

<%@attribute name="funcionario" required="true" type="Funcionario"%>
<%@attribute name="actualRole" required="true" type="Integer"%>
<%@attribute name="actualPage" required="true" type="Integer"%>

<div class="container-fluid top">
    <div >
        <img src="${pageContext.request.contextPath}/resources/img/logo_sena.png" alt="sena_icono" class="topIconoS">
        <div style="display: inline-block;border-left: 0.5px black solid;height: 80px;vertical-align: middle;margin-right: 30px;margin-left: 30px;margin-top: 10px;"></div>
        <img src="${pageContext.request.contextPath}/resources/img/logo-completo.png" alt="munnin_icono" class="topIconoM">
    </div>
</div>
<nav class="navbar navbar-inverse" data-spy="affix" data-offset-top="112">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span> 
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/home/intro.jsp">Inicio</a>
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
                        <li><a data-toggle="modal" data-target="#changePassword"><span class="glyphicon glyphicon-lock"></span> Cambiar contraseña</a></li>
                        <li><a ><span class="fa fa-question-circle-o glyphicon"></span> Preguntas Frecuentes</a></li>
                    </ul>
                </li>
                <li><a href="#vtn" data-toggle="modal"><span class="glyphicon glyphicon-log-in"></span> Salir</a></li>
            </ul>
        </div>
    </div>
</nav>