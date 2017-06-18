<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<template:basicTemplate actualPage="3"
                        actualRole="2"
                        funcionario="${sessionScope.usuario}"
                        title="Registro Funcionarios Coordinador Munnin"
                        panelTitle="Carga masiva de funcionarios">
    <jsp:attribute name="additionalJS">
        <script src="${pageContext.request.contextPath}/resources/js/ajaxMunnin.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/inputFile.js" type="text/javascript"></script>
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <div class="col-lg-offset-2 col-sm-10" id="message_uploadobject">
                </div>
                <form class="form-horizontal"
                      enctype="multipart/form-data"
                      method="POST"
                      action="${pageContext.request.contextPath}/home/role/coordinator/uploadexceldata/uploaddata"
                      data-ajax-form="true"
                      data-display="message_uploadobject">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="objectFile">Archivo</label>
                        <div class="col-sm-10">
                            <div class="input-group">
                                <label class="input-group-btn">
                                    <span class="btn btn-default">
                                        Buscar&hellip; <input type="file" 
                                                              style="display: none;" 
                                                              name="objectFile" 
                                                              id="objectFile" 
                                                              required="required"
                                                              accept= "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
                                    </span>
                                </label>
                                <input type="text" class="form-control" readonly>
                            </div>
                            <span class="help-block">
                                Puede usar la siguiente <a data-toggle="modal" href="#hintExcel">imagen</a> como ayuda para hacer archivo de excel, o descargar el siguiente <a href="${pageContext.request.contextPath}/resources/file/ejemplo.xlsx">archivo</a> para usarlo como plantilla.
                            </span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-sm-4">
                            <button type="submit" class="btn btn-success">
                                Enviar
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <jsp:include page="/home/role/coordinator/uploadexceldata/modalHint.jsp" />
    </jsp:body>
</template:basicTemplate>