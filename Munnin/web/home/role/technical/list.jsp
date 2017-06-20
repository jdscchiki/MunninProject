<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<%@taglib prefix="tables" tagdir="/WEB-INF/tags/template/basicTemplate/tables/" %>
<template:basicTemplate actualPage="2"
                        actualRole="4"
                        funcionario="${sessionScope.usuario}"
                        title="Listas de chequeo E. Pedagógico Munnin"
                        panelTitle="Listas de Chequeo">
    <jsp:attribute name="additionalJS">
        <script src="${pageContext.request.contextPath}/resources/js/ajaxDataTable.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/ajaxMunnin.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                ajaxLoadContent("${pageContext.request.contextPath}/home/role/technical/list/search", "fulltable");
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12" id="message_list"></div>
            <div class="col-lg-12">
                <div class="row">
                    <div class="col-lg-6">
                        <tables:dataTableSearch id="formSearchCategoriesEnable"
                                                urlServlet="${pageContext.request.contextPath}/home/role/technical/list/search"
                                                placeholder="Buscar Categorias"
                                                display="fulltable"
                                                width="8"/>
                    </div>
                    <div class="col-lg-6">
                        <button type="button" 
                                class="btn btn-primary tableButton" 
                                data-toggle="modal" 
                                data-target="#modalListT">
                            <span class="glyphicon glyphicon-plus"></span> Nueva Lista
                        </button>
                        <tables:dataTableActionButton action="disable"
                                                      panelTable="formActionList"
                                                      icon="glyphicon glyphicon-remove">
                            Eliminar
                        </tables:dataTableActionButton>
                    </div>
                </div>
            </div>
            <div class="col-lg-12" id="fulltable"></div>
        </div>
        <tables:dataTableSelectForm id="formActionList"
                                    dataTable="tableBodyList"
                                    display="message_list"
                                    urlServlet="${pageContext.request.contextPath}/home/role/technical/list/manage" />
        <jsp:include page="/home/role/technical/list/modalNewChecklistT.jsp" />
    </jsp:body>

</template:basicTemplate>