<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<template:basicTemplate actualPage="5"
                        actualRole="2"
                        funcionario="${sessionScope.usuario}"
                        title="Areas Coordinador Munnin"
                        panelTitle="Administrar las areas del centro">
    <jsp:attribute name="additionalJS">
        <script src="${pageContext.request.contextPath}/resources/js/ajaxDataTable.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/ajaxMunnin.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
               ajaxLoadContent("${pageContext.request.contextPath}/home/role/area/pagerArea", "fulltable");
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12" id="message_areas">

            </div>
            <div class="col-lg-12">
                <form id="formSearchAreaEnable" 
                      class="form-horizontal" 
                      method="POST" 
                      action="${pageContext.request.contextPath}/home/role/area/pagerArea"
                      data-ajax-form="true"
                      data-display="message_areas">                    
                    <div class="form-group">
                        <label class="control-label col-sm-1" for="searchMunnin">Buscar:</label>
                        <div class="col-sm-5">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Buscar area" id="searchMunnin" name="search">
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
                        data-target="#registerArea">
                    Crear Area</button>
            </div>
        </div>
        <form id="formActionAreaEnable"
              method="POST"
              action="${pageContext.request.contextPath}/home/role/coordinator/admin-functionary"
              data-display="message_areas"
              data-ajax-form="true"
              data-data-table="tableBodyAreas">
            <input type="hidden" name="id" value="-1" data-selected-item="">
            <input type="hidden" name="action" data-action="">
        </form>
        <jsp:include page="/home/role/coordinator/area/modalCreateArea.jsp" />
    </jsp:body>
</template:basicTemplate>
