<%-- 
    Document   : search
    Created on : 29/03/2017, 09:25:01 AM
    Author     : Monica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<template:basicTemplate actualPage="3"
                        actualRole="5"
                        funcionario="${sessionScope.usuario}"
                        title="Buscar Instructor Munnin"
                        panelTitle="Buscar Material Aprobado">
    <jsp:attribute name="additionalJS">
        <script src="${pageContext.request.contextPath}/resources/js/ajaxMunnin.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/ajaxDataTable.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                ajaxLoadContent("${pageContext.request.contextPath}/home/role/instructor/search/pagerSearch", "fulltable");
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12" id="message_search">
            </div>
            <div class="col-lg-12">
                <form id="formSearch" 
                      class="form-horizontal" 
                      method="POST" 
                      action="${pageContext.request.contextPath}/home/role/instructor/search/pagerSearch"
                      data-ajax-form="true"
                      data-display="fulltable">                    
                    <div class="form-group">                        
                        <label class="control-label col-sm-1" for="searchMunnin">Buscar:</label>
                        <div class="col-sm-5">
                            <div class="input-group">
                                <input type="hidden" name="filtro" value="1">
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
            <div class="col-lg-12" id="fulltable"></div>
        </div>            
    </jsp:body>
</template:basicTemplate>
