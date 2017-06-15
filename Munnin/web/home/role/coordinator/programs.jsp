<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<%@taglib prefix="tables" tagdir="/WEB-INF/tags/template/basicTemplate/tables/" %>
<template:basicTemplate actualPage="6"
                        actualRole="2"
                        funcionario="${sessionScope.usuario}"
                        title="Programas Coordinador Munnin"
                        panelTitle="Administrar los programas del centro">
    <jsp:attribute name="additionalJS">
        <script src="${pageContext.request.contextPath}/resources/js/ajaxDataTable.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/ajaxMunnin.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                ajaxLoadContent("${pageContext.request.contextPath}/home/role/coordinator/programs/search", "fulltable");
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12" id="message_programs"></div>
            <div class="col-lg-12">
                <div class="row">
                    <div class="col-lg-6">
                        <tables:dataTableSearch id="formSearchFunctionaryEnable"
                                                urlServlet="${pageContext.request.contextPath}/home/role/coordinator/programs/search"
                                                placeholder="Buscar programa"
                                                display="fulltable"
                                                width="8"/>
                    </div>
                    <div class="col-lg-6">
                        <button type="button" 
                                class="btn btn-primary tableButton" 
                                data-toggle="modal" 
                                data-target="#addProgram">
                            <span class="glyphicon glyphicon-plus"></span> Agregar
                        </button>
                        <tables:dataTableActionButton action="edit"
                                                      panelTable="formActionProgramsEnable"
                                                      icon="glyphicon glyphicon-edit">
                            Editar
                        </tables:dataTableActionButton>
                        <tables:dataTableActionButton action="disable"
                                                      panelTable="formActionProgramsEnable"
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
                        data-servlet="${pageContext.request.contextPath}/home/role/coordinator/programs/modalDisabled.jsp"
                        data-display="message_programs">
                    Ver programas inhabilitados
                </button>
            </div>
        </div>
        <tables:dataTableSelectForm id="formActionProgramsEnable"
                                    dataTable="tableBodyPrograms"
                                    display="message_programs"
                                    urlServlet="${pageContext.request.contextPath}/home/role/coordinator/programs/manage" />
        <jsp:include page="/home/role/coordinator/programs/modalAdd.jsp" />
    </jsp:body>
</template:basicTemplate>