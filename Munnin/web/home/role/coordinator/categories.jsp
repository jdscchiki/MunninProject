<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<template:basicTemplate actualPage="4"
                        actualRole="2"
                        funcionario="${sessionScope.usuario}"
                        title="Categorías Coordinador Munnin"
                        panelTitle="Categorías del centro">

    <jsp:body>
        <div class="row">
            <div class="col-md-12" id="message_functionaries">

            </div>
            <div class="col-sm-6">
                <form id="formSearchCategoryEnable" 
                      class="form-horizontal" 
                      method="POST" 
                      action="${pageContext.request.contextPath}/home/role/coordinator/pagerCategory"
                      data-ajax-form="true"
                      data-display="fulltable">
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="searchMunnin">Buscar Categoria:</label>

                        <div class="input-group col-sm-8">
                            <input type="text" class="form-control" placeholder="Buscar..." id="searchMunnin" name="search">
                            <div class="input-group-btn">
                                <button class="btn btn-default" type="submit">
                                    <i class="glyphicon glyphicon-search"></i>
                                </button>
                            </div>
                        </div>

                    </div>
                </form>
            </div>
            <div class="col-md-6">
                <button type="button" 
                        class="btn btn-primary" 
                        data-toggle="modal" 
                        data-target="#addCategory">
                    Agregar</button>
                <button type="button" 
                        class="btn btn-primary" 
                        data-panel-table="formActionCategoryEnable"
                        data-action="changeRoles">
                    Editar</button>
                <button type="button" 
                        class="btn btn-primary" 
                        data-panel-table="formActionCategoryEnable"
                        data-action="disable">
                    Inhabilitar</button>
            </div>
            <div class="col-md-12" id="fulltable">

            </div>
            <div class="col-md-12">
                <button type="button" 
                        class="btn btn-link" 
                        data-servlet="${pageContext.request.contextPath}/home/role/coordinator/functionary/modalShowDisable.jsp"
                        data-display="message_functionaries" disabled>
                    Ver Categorias Inhabilitadas
                </button>
            </div>
        </div>
        <form id="formActionFunctionaryEnable"
              method="POST"
              action="${pageContext.request.contextPath}/home/role/coordinator/admin-functionary"
              data-display="message_functionaries"
              data-data-table="tableBodyFunctionaries">
            <input type="hidden" name="id" value="-1" data-selected-item="">
            <input type="hidden" name="action" data-action="">
        </form>
        <jsp:include page="/home/role/coordinator/functionary/modalRegisterFunctionary.jsp" />
    </jsp:body>
</template:basicTemplate>
