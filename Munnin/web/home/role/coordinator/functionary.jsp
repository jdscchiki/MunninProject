<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" session="false"%>
<%
    request.setAttribute("title", "Munnin Coordinador");
    request.setAttribute("navbar", 3);
    request.setAttribute("mainPage", 3);

    String aditionalJS = "";
    aditionalJS += "<script src='" + request.getContextPath() + "/home/role/coordinator/elements/js/all.js' languaje='Javascript' type='text/javascript'></script>";
    request.setAttribute("aditionalJS", aditionalJS);
%>
<jsp:include page="/elements/content/top.jsp" />
<div class="row">
    <div class="col-lg-10">
        <div id="fulltable">
            <jsp:include page="/home/role/coordinator/elements/content/functionary/fullPager.jsp" />
        </div>
    </div>
    <div class="col-lg-2">
        <button type="button" class="btn btn-primary btn-block" id="remove" class="btn btn-primary btn-block">Eliminar funcionario</button>
        <button type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#registerFunctionary">Registro de funcionarios</button>
    </div>
</div>
<div id="div_message">
</div>
<script type="text/javascript">
    var contextPath = ${URIMunnin};
</script>
<jsp:include page="/home/role/coordinator/elements/content/forms/modalRegister.jsp" />
<jsp:include page="/elements/content/bot.jsp" />