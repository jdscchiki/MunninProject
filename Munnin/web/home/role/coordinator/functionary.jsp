<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" session="false"%>
<%
    request.setAttribute("title", "Munnin Coordinador");
    request.setAttribute("navbar", 3);
    request.setAttribute("mainPage", 3);

    String aditionalJS = "";
    aditionalJS += "<script src='" + request.getContextPath() + "/home/role/coordinator/elements/js/functionary.js' languaje='Javascript' type='text/javascript'></script>";
    request.setAttribute("aditionalJS", aditionalJS);
%>
<jsp:include page="/elements/content/top.jsp" />
<div class="panel panel-default">
    <div class="panel-heading"><h3>Administrar los funcionarios del centro</h3></div>
    <div class="panel-body">
        <div class="row">
            <div class="col-lg-10">
                <div id="fulltable">
                    <jsp:include page="/home/role/coordinator/elements/content/functionary/pager.jsp" />
                    <jsp:include page="/home/role/coordinator/elements/content/functionary/table.jsp" />
                </div>
            </div>
            <div class="col-lg-2">
                <button type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#registerFunctionary">Registrar</button>
                <button type="button" class="btn btn-primary btn-block" id="ChangeRoles" class="btn btn-primary btn-block">Cambiar roles</button>
                <button type="button" class="btn btn-primary btn-block" id="remove" class="btn btn-primary btn-block">Inhabilitar</button>
            </div>
            <div class="col-lg-12">
                <button type="button" class="btn btn-link" id="ShowDisabled">Ver Funcionarios Inhabilitados</button>
            </div>
        </div>
        <div id="div_message">
        </div>
    </div>
</div>
<script type="text/javascript">
    var contextPath = ${URIMunnin};
</script>
<jsp:include page="/home/role/coordinator/elements/content/forms/modalRegister.jsp" />
<jsp:include page="/elements/content/bot.jsp" />