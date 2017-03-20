<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<template:basicTemplate actualPage="6"
                        actualRole="2"
                        funcionario="${sessionScope.usuario}"
                        title="Programas Coordinador Munnin"
                        panelTitle="Administrar los programas del centro">
    <jsp:attribute name="additionalJS">
        <script src="${pageContext.request.contextPath}/resources/js/ajaxDataTable.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/ajaxMunnin.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                ajaxLoadContent("${pageContext.request.contextPath}/home/role/coordinator/programs/search", "fulltable");
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12" id="message_programs">

            </div>
            <div class="col-lg-6">
                <form id="formSearchProgramEnable" 
                      class="form-horizontal" 
                      method="POST" 
                      action="${pageContext.request.contextPath}/home/role/coordinator/programs/search"
                      data-ajax-form="true"
                      data-display="fulltable">
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="searchPrograms">Buscar:</label>
                        <div class="col-sm-8">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Buscar programa" id="searchPrograms" name="search">
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
            <div class="col-lg-6">
                <button type="button" 
                        class="btn btn-primary" 
                        data-toggle="modal" 
                        data-target="#addProgram">
                    Agregar</button>
                <button type="button" 
                        class="btn btn-primary" 
                        data-panel-table="formActionProgramsEnable"
                        data-action="disable">
                    Inhabilitar</button>
            </div>
            <div class="col-lg-12" id="fulltable">

            </div>
            <div class="col-lg-12">
                <button type="button" 
                        class="btn btn-link" 
                        data-servlet="${pageContext.request.contextPath}/home/role/coordinator/programs/modalDisabled.jsp"
                        data-display="message_programs">
                    Ver programas inhabilitados
                </button>
            </div>
        </div>
        <form id="formActionProgramsEnable"
              method="POST"
              action="${pageContext.request.contextPath}/home/role/coordinator/programs/manage"
              data-display="message_programs"
              data-data-table="tableBodyPrograms">
            <input type="hidden" name="id" value="-1" data-selected-item="">
            <input type="hidden" name="action" data-action="">
        </form>
        <jsp:include page="/home/role/coordinator/programs/modalAdd.jsp" />
    </jsp:body>
</template:basicTemplate>