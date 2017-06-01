<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<%@taglib prefix="tables" tagdir="/WEB-INF/tags/template/basicTemplate/tables" %>
<template:basicTemplate actualPage="5"
                        actualRole="2"
                        funcionario="${sessionScope.usuario}"
                        title="Areas Coordinador Munnin"
                        panelTitle="Administrar las áreas del centro">
    <jsp:attribute name="additionalJS">
        <script src="${pageContext.request.contextPath}/resources/js/ajaxMunnin.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/ajaxDataTable.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                ajaxLoadContent("${pageContext.request.contextPath}/home/role/coordinator/area/search", "fulltable");
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12" id="message_areas"></div>
            <div class="col-lg-12">
                <div class="row">
                    <div class="col-lg-6">
                        <tables:dataTableSearch id="formSearchAreaEnable"
                                                urlServlet="${pageContext.request.contextPath}/home/role/coordinator/area/search"
                                                placeholder="Buscar área"
                                                display="fulltable"
                                                width="8"/>
                    </div>
                    <div class="col-lg-6">
                        <button type="button" 
                                class="btn btn-primary tableButton" 
                                data-toggle="modal" 
                                data-target="#registerArea">
                            <span class="glyphicon glyphicon-plus"></span> Crear
                        </button>
                        <tables:dataTableActionButton action="editArea"
                                                      panelTable="formActionAreaEnable"
                                                      icon="glyphicon glyphicon-edit">
                            Editar
                        </tables:dataTableActionButton>
                        <tables:dataTableActionButton action="disable"
                                                      panelTable="formActionAreaEnable"
                                                      icon="glyphicon glyphicon-remove">
                            Inhabilitar
                        </tables:dataTableActionButton>
                    </div>
                </div>
            </div>
            <div class="col-lg-12" id="fulltable"></div>
            <div class="col-lg-12">
                <button type="button" 
                        class="btn btn-link" 
                        data-servlet="${pageContext.request.contextPath}/home/role/coordinator/area/modalShowDisabled.jsp"
                        data-display="message_areas">
                    Ver Áreas Inhabilitadas 
                </button>
            </div>
        </div>
        <tables:dataTableSelectForm id="formActionAreaEnable"
                                    dataTable="tableBodyAreas"
                                    display="message_areas"
                                    urlServlet="${pageContext.request.contextPath}/home/role/coordinator/area/manage" />
        <jsp:include page="/home/role/coordinator/area/modalCreate.jsp" />
    </jsp:body>
</template:basicTemplate>
