<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<template:basicTemplate actualPage="3"
                        actualRole="2"
                        funcionario="${sessionScope.usuario}"
                        title="Funcionarios Coordinador Munnin"
                        panelTitle="Administrar los funcionarios del centro">
    <jsp:attribute name="additionalJS">
        <script src="${pageContext.request.contextPath}/resources/js/ajaxDataTable.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/ajaxMunnin.js" type="text/javascript"></script>
        <script type="text/javascript">
            
        </script>
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12" id="message_functionaries">

            </div>
            <div class="col-lg-12">
                <form id="formSearchFunctionaryEnable" 
                      class="form-horizontal" 
                      method="POST" 
                      action="${pageContext.request.contextPath}/home/role/coordinator/pagerFunctionary"
                      data-ajax-form="true"
                      data-display="fulltable">
                    <div class="form-group">
                        <label class="control-label col-sm-1" for="searchMunnin">Buscar:</label>
                        <div class="col-sm-5">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Buscar funcionario" id="searchMunnin" name="search">
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
                <jsp:include page="functionary/table.jsp" />
            </div>
            <div class="col-lg-2">
                <button type="button" 
                        class="btn btn-primary btn-block" 
                        data-toggle="modal" 
                        data-target="#registerFunctionary">
                    Registrar</button>
                <button type="button" 
                        class="btn btn-primary btn-block" 
                        data-panel-table="formActionFunctionaryEnable"
                        data-action="changeRoles">
                    Cambiar roles</button>
                <button type="button" 
                        class="btn btn-primary btn-block" 
                        data-panel-table="formActionFunctionaryEnable"
                        data-action="disable">
                    Inhabilitar</button>
            </div>
            <div class="col-lg-12">
                <button type="button" class="btn btn-link" id="showDisabled">Ver Funcionarios Inhabilitados</button>
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
