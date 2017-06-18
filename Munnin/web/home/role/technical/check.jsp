<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<%@taglib prefix="tables" tagdir="/WEB-INF/tags/template/basicTemplate/tables" %>
<template:basicTemplate actualPage="3"
                        actualRole="3"
                        funcionario="${sessionScope.usuario}"
                        title="Pendientes Tecnico Munnin"
                        panelTitle="Archivos por Revisar">
    <jsp:attribute name="additionalJS">
        <script src="${pageContext.request.contextPath}/resources/js/ajaxDataTable.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/ajaxMunnin.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                ajaxLoadContent("${pageContext.request.contextPath}/home/role/technical/check/search", "fulltable");
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12" id="message_file"></div>
            <div class="col-lg-12">
                <div class="row">
                    <div class="col-lg-6">
                        <tables:dataTableSearch id="formSearchFileEnable"
                                                urlServlet="${pageContext.request.contextPath}/home/role/technical/check/search"
                                                placeholder="Buscar Archivo"
                                                display="fulltable"
                                                width="8"/>
                    </div>
                </div>
            </div>
            <div class="col-lg-12" id="fulltable"></div>
        </div>
    </jsp:body>
</template:basicTemplate>
