<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<%@taglib prefix="tables" tagdir="/WEB-INF/tags/template/basicTemplate/tables/" %>
<template:basicTemplate actualPage="4"
                        actualRole="2"
                        funcionario="${sessionScope.usuario}"
                        title="Categorías Coordinador Munnin"
                        panelTitle="Categorías del centro">
    <jsp:attribute name="additionalJS">
        <script src="${pageContext.request.contextPath}/resources/js/ajaxMunnin.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/ajaxDataTable.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                ajaxLoadContent("${pageContext.request.contextPath}/home/role/coordinator/categories/search", "fulltable");
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12" id="message_categories"></div>
            <div class="col-lg-12">
                <div class="row">
                    <div class="col-lg-6">
                        <tables:dataTableSearch id="formSearchCategoriesEnable"
                                                urlServlet="${pageContext.request.contextPath}/home/role/coordinator/categories/search"
                                                placeholder="Buscar Categorias"
                                                display="fulltable"
                                                width="8"/>
                    </div>
                    <div class="col-lg-6">
                        <button type="button" 
                                class="btn btn-primary tableButton" 
                                data-toggle="modal" 
                                data-target="#registerCategories">
                            <span class="glyphicon glyphicon-plus"></span> Crear
                        </button>
                        <tables:dataTableActionButton action="editCategories"
                                                      panelTable="formActionCategoriesEnable"
                                                      icon="glyphicon glyphicon-pencil">
                            Editar
                        </tables:dataTableActionButton>
                        <tables:dataTableActionButton action="disable"
                                                      panelTable="formActionCategoriesEnable"
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
                        data-servlet="${pageContext.request.contextPath}/home/role/coordinator/categories/modalShowDisabled.jsp"
                        data-display="message_categories">
                    Ver Categorias Inhabilitadas 
                </button>
            </div>
        </div>
        <tables:dataTableSelectForm id="formActionCategoriesEnable"
                                    dataTable="tableBodyCategories"
                                    display="message_categories"
                                    urlServlet="${pageContext.request.contextPath}/home/role/coordinator/categories/manage" />
        <jsp:include page="/home/role/coordinator/categories/modalCreate.jsp" />
    </jsp:body>
</template:basicTemplate>
