<%-- 
    Document   : mystuff
    Created on : 18/04/2017, 07:21:14 PM
    Author     : Monica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<template:basicTemplate actualPage="4"
                        actualRole="5"
                        funcionario="${sessionScope.usuario}"
                        title="Mi material Munnin"
                        panelTitle="Buscar mi material ">
    <jsp:attribute name="additionalJS">
        <script src="${pageContext.request.contextPath}/resources/js/ajaxMunnin.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/ajaxDataTable.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/inputFile.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                ajaxLoadContent("${pageContext.request.contextPath}/home/role/instructor/mystuff/pagerMystuff", "fulltable");
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12" id="message_Mystuff">

            </div>
            <div class="col-lg-12">
                <form id="formMystuffEnable" 
                      class="form-horizontal" 
                      method="POST" 
                      action="${pageContext.request.contextPath}/home/role/instructor/mystuff/pagerMystuff"
                      data-ajax-form="true"
                      data-display="fulltable">                    
                    <div class="form-group">                        
                        <label class="control-label col-sm-1" for="searchMunnin">Buscar:</label>
                        <div class="col-sm-5">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Buscar material" id="searchMunnin" name="search">
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
            <div class="col-lg-12" id="fulltable">

            </div>
            <div class="col-lg-2">
                <button type="button" 
                        class="btn btn-primary btn-block"
                        data-panel-table="formMyStuffEnable"
                        data-action="subirObjeto">
                    Ver objeto</button>
            </div>

            <form id="formMyStuffEnable"
                  method="POST"
                  action="${pageContext.request.contextPath}/home/role/instructor/myStuff/ManageMystuff"
                  data-display="message_Mystuff"
                  data-ajax-form="true"
                  data-data-table="tableBodySubir">
                <input type="hidden" name="id" value="-1" data-selected-item="">
                <input type="hidden" name="action" data-action="">
            </form>             
        </div>
    </jsp:body>
</template:basicTemplate>
