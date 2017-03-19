<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
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
                ajaxLoadContent("${pageContext.request.contextPath}/home/role/coordinator/pagerFile", "fulltable");
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12" id="message_file">

            </div>
            <div class="col-lg-12">
                <form id="formSearchFileEnable" 
                      class="form-horizontal" 
                      method="POST" 
                      action="${pageContext.request.contextPath}/home/role/coordinator/pagerFile"
                      data-ajax-form="true"
                      data-display="fulltable">                    
                    <div class="form-group">                        
                        <label class="control-label col-sm-1" for="searchMunnin">Buscar:</label>
                        <div class="col-sm-5">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Buscar Archivo" id="searchMunnin" name="search">
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
                        data-panel-table="formActionFileEnable"
                        data-action="calificarArchivo">
                    Calificar</button>
                <button type="button" 
                        class="btn btn-primary btn-block" 
                        data-panel-table="formActionFileEnable"
                        data-action="checkList">
                    Lista de Chequeo</button>
        </div>
        <form id="formActionFileEnable"
              method="POST"
              action="${pageContext.request.contextPath}/home/role/technical/files/manage"
              data-display="message_file"
              data-ajax-form="true"
              data-data-table="tableBodyFile">
            <input type="hidden" name="id" value="-1" data-selected-item="">
            <input type="hidden" name="action" data-action="">
        </form>
    </jsp:body>
</template:basicTemplate>
