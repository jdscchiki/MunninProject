<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<%@taglib prefix="tables" tagdir="/WEB-INF/tags/template/basicTemplate/tables/" %>
<template:basicTemplate actualPage="3"
                        actualRole="2"
                        funcionario="${sessionScope.usuario}"
                        title="Funcionarios Coordinador Munnin"
                        panelTitle="Administrar los funcionarios del centro">
    <jsp:attribute name="additionalJS">
        <script src="${pageContext.request.contextPath}/resources/js/ajaxDataTable.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/ajaxMunnin.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                ajaxLoadContent("${pageContext.request.contextPath}/home/role/coordinator/functionary/search", "fulltable");
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12" id="message_functionaries"></div>
            <div class="col-lg-12">
                <div class="row">
                    <div class="col-lg-6">
                        <tables:dataTableSearch id="formSearchFunctionaryEnable"
                                                urlServlet="${pageContext.request.contextPath}/home/role/coordinator/functionary/search"
                                                placeholder="Buscar funcionario"
                                                display="fulltable"
                                                width="8"/>
                    </div>
                    <div class="col-lg-6">
                        <button type="button" 
                                class="btn btn-primary tableButton" 
                                data-toggle="modal" 
                                data-target="#registerFunctionary">
                            <span class="glyphicon glyphicon-plus"></span> Registrar</button>
                            <tables:dataTableActionButton action="changeRoles"
                                                          panelTable="formActionFunctionaryEnable"
                                                          icon="glyphicon glyphicon-pencil">
                                Cambiar roles
                            </tables:dataTableActionButton>
                            <tables:dataTableActionButton action="disable"
                                                          panelTable="formActionFunctionaryEnable"
                                                          icon="glyphicon glyphicon-remove">
                                Inhabilitar
                            </tables:dataTableActionButton>
                        </div>
                    </div>
                </div>
                <div  class="col-lg-12" id="fulltable"></div>
                <div class="col-lg-12">
                    <button type="button" 
                            class="btn btn-link" 
                            data-servlet="${pageContext.request.contextPath}/home/role/coordinator/functionary/modalShowDisable.jsp"
                    data-display="message_functionaries">
                    Ver Funcionarios Inhabilitados
                </button>
            </div>
        </div>
        <tables:dataTableSelectForm id="formActionFunctionaryEnable"
                                    dataTable="tableBodyFunctionaries"
                                    display="message_functionaries"
                                    urlServlet="${pageContext.request.contextPath}/home/role/coordinator/functionary/manage" />
        <jsp:include page="/home/role/coordinator/functionary/modalRegister.jsp" />
    </jsp:body>
</template:basicTemplate>
