<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<template:basicTemplate actualPage="4"
                        actualRole="2"
                        funcionario="${sessionScope.usuario}"
                        title="Categorias Coordinador Munnin"
                        panelTitle="Categorias del centro">
    <jsp:attribute name="additionalJS">
        <script src="${pageContext.request.contextPath}/resources/js/ajaxMunnin.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/ajaxDataTable.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                ajaxLoadContent("${pageContext.request.contextPath}/home/role/coordinator/pagerCategories", "fulltable");
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12" id="message_categories">

            </div>
            <div class="col-lg-12">
                <form id="formSearchCategoriesEnable" 
                      class="form-horizontal" 
                      method="POST" 
                      action="${pageContext.request.contextPath}/home/role/coordinator/pagerCategories"
                      data-ajax-form="true"
                      data-display="fulltable">                    
                    <div class="form-group">                        
                        <label class="control-label col-sm-1" for="searchMunnin">Buscar:</label>
                        <div class="col-sm-5">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Buscar Categorias" id="searchMunnin" name="search">
                                <div class="input-group-btn">
                                    <button class="btn btn-default" type="submit">
                                        <i class="glyphicon glyphicon-search"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-lg-8" id="fulltable">

            </div>
            <div class="col-lg-2">
                <button type="button" 
                        class="btn btn-primary btn-block" 
                        data-toggle="modal" 
                        data-target="#registerCategories">
                    Crear Categoria</button>
                <button type="button" 
                        class="btn btn-primary btn-block" 
                        data-panel-table="formActionCategoriesEnable"
                        data-action="editCategories">
                    Editar Categoria</button>
                <button type="button" 
                        class="btn btn-primary btn-block" 
                        data-panel-table="formActionCategoriesEnable"
                        data-action="disable">
                    Inhabilitar</button>
            </div>
            <div class="col-lg-12">
                <button type="button" 
                        class="btn btn-link" 
                        data-servlet="${pageContext.request.contextPath}/home/role/coordinator/categories/modalShowDisableCategories.jsp"
                        data-display="message_categories">
                    Ver Categorias Inhabilitadas 
                </button>
            </div>
        </div>
        <form id="formActionCategoriesEnable"
              method="POST"
              action="${pageContext.request.contextPath}/home/role/coordinator/categories/manage"
              data-display="message_categories"
              data-ajax-form="true"
              data-data-table="tableBodyCategories">
            <input type="hidden" name="id" value="-1" data-selected-item="">
            <input type="hidden" name="action" data-action="">
        </form>
        <jsp:include page="/home/role/coordinator/categories/modalCreateCategories.jsp" />
    </jsp:body>
</template:basicTemplate>
