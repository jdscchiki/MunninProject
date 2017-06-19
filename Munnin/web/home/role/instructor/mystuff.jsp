<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<%@taglib prefix="tables" tagdir="/WEB-INF/tags/template/basicTemplate/tables" %>
<template:basicTemplate actualPage="4"
                        actualRole="5"
                        funcionario="${sessionScope.usuario}"
                        title="Mi material Munnin"
                        panelTitle="Buscar mi material ">
    <jsp:attribute name="additionalJS">
        <script src="${pageContext.request.contextPath}/resources/js/inputFile.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/ajaxMunnin.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/ajaxDataTable.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                ajaxLoadContent("${pageContext.request.contextPath}/home/role/instructor/mystuff/pagerMystuff", "fulltable");
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12" id="message_Mystuff">

            </div>
            <div class="col-lg-12">
                <tables:dataTableSearch id="formMystuffEnable"
                                        urlServlet="${pageContext.request.contextPath}/home/role/instructor/mystuff/pagerMystuff"
                                        placeholder="Buscar Archivo"
                                        display="fulltable"
                                        width="6"/>
            </div>
            <div class="col-lg-12" id="fulltable"></div>
        </div>
    </jsp:body>
</template:basicTemplate>
