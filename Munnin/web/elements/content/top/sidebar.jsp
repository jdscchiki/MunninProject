<%@page import="modelo.bean.Funcionario"%>
<%@page session="true" %>
<%--
    2- ADMINISTRADOR
    3- COORDINADOR
    4- INSTRUCTOR
    5- PEDAGOGICO
    6- TECNICO
--%>

<%
    Funcionario funcionario = (Funcionario) session.getAttribute("usuario");
%>
<div class="left">
    <%
        if (funcionario.isAdministrador()) {
    %>
    <a href="${URIAdministrator}inicio.jsp" >
        <div class="item ${navbar==2?"active":""}">
            <span class="fa fa-eye glyphicon" style="font-size:18px"></span>Administrador
        </div>
    </a>
    <%
        }
        if (funcionario.isCoordinador()) {
    %>
    <a href="${URICoordinator}inicio.jsp" >
        <div class="item ${navbar==3?"active":""}">
            <span class="fa fa-file-o glyphicon" style="font-size:18px"></span>Coordinador
        </div>
    </a>
    <%
        }
        if (funcionario.isTecnico()) {
    %>
    <a href="${URITechnical}inicio.jsp" >
        <div class="item ${navbar==6?"active":""}">
            <span class="fa fa-group glyphicon" style="font-size:18px"></span>E. Técnico
        </div>
    </a>
    <%
        }
        if (funcionario.isPedagogico()) {
    %>
    <a href="${URIPedagogical}inicio.jsp" >
        <div class="item ${navbar==5?"active":""}">
            <span class="fa fa-group glyphicon" style="font-size:18px"></span>E. Pedagógico
        </div> 
    </a>
    <%
        }
        if (funcionario.isInstructor()) {
    %>
    <a href="${URIInstructor}inicio.jsp" >
        <div class="item ${navbar==4?"active":""}">
            <span class="fa fa-user-circle glyphicon" style="font-size:18px"></span>Instructor
        </div>
    </a>
    <%
        }
    %>
</div>