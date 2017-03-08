<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="sidebar of basicTemplate" pageEncoding="UTF-8"%>
<%@tag import="model.bean.Funcionario" %>
<%@attribute name="funcionario" required="true" type="Funcionario"%>
<%@attribute name="activeRole" type="Integer" required="false"%>

<div class="left">
    <c:if test="${funcionario.isAdministrador()}">
        <a href="${pageContext.request.contextPath}/home/role/administrator/intro.jsp" >
            <div class="item ${activeRole==1?"active":""}">
                <span class="fa fa-eye glyphicon" style="font-size:18px"></span>Administrador
            </div>
        </a>
    </c:if>
    <c:if test="${funcionario.isCoordinador()}">
        <a href="${pageContext.request.contextPath}/home/role/coordinator/intro.jsp" >
            <div class="item ${activeRole==2?"active":""}">
                <img src="${pageContext.request.contextPath}/resources/img/coord.png" alt="_icono" class="glyphicon">Coordinador
            </div>
        </a>
    </c:if>
    <c:if test="${funcionario.isTecnico()}">
        <a href="${pageContext.request.contextPath}/home/role/technical/intro.jsp" >
            <div class="item ${activeRole==3?"active":""}">
                <img src="${pageContext.request.contextPath}/resources/img/eTecnico.png" alt="_icono" class="glyphicon">E. Técnico
            </div>
        </a>
    </c:if>
    <c:if test="${funcionario.isPedagogico()}">
        <a href="${pageContext.request.contextPath}/home/role/pedagogical/intro.jsp" >
            <div class="item ${activeRole==4?"active":""}">
                <img src="${pageContext.request.contextPath}/resources/img/ePedagogico.png" alt="_icono" class="glyphicon">E. Pedagógico
            </div>
        </a>
    </c:if>
    <c:if test="${funcionario.isInstructor()}">
        <a href="${pageContext.request.contextPath}/home/role/instructor/intro.jsp" >
            <div class="item ${activeRole==5?"active":""}">
                <span class="fa fa-user-circle glyphicon" style="font-size:18px"></span>Instructor
            </div>
        </a>
    </c:if>
</div>